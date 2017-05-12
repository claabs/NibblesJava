
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

/**
 Course: SE-3860 Spring 2017 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles the drawing of all of the various game level
 components on the games panel.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class GamePanel extends JPanel
{

   private Font displayFont;
   private static final int MARGIN_SIZE = 0;
   private Collidable gameBoard[][];
   private Level level;
   private Timer timer;
   private int sparkleCycle;
   private final int xOffset;
   private final int yOffset;
   private boolean flashState;
   private final File fontFile = new File("resources/LessPerfectDOSVGA.ttf");
   private final GameManager manager;
   private final AudioEffectPlayer audio = new AudioEffectPlayer();
   private ActionListener taskPerformer = (ActionEvent)
         -> 
         {
            repaint();
   };

   public enum CellContents
   {
      EMPTY, WALL, FOOD, SNAKE, SNAKEHEAD
   };

   /**
    This constructor builds a new game panel with a specified width, height,
    and a game manager.

    @param boardWidth  Width of the board.
    @param boardHeight Height of the board.
    @param inManager   To-be active game manager.
    */
   public GamePanel(int boardWidth, int boardHeight, GameManager inManager)
   {
      sparkleCycle = 0;
      manager = inManager;
      gameBoard = new Collidable[boardWidth][boardHeight];
      xOffset = MARGIN_SIZE;
      yOffset = MARGIN_SIZE + GameManager.CHAR_HEIGHT;
      setPreferredSize(
            new Dimension(GameManager.CHAR_WIDTH * boardWidth + 2 * MARGIN_SIZE,
                  GameManager.CHAR_WIDTH * boardHeight + 2 * MARGIN_SIZE + GameManager.CHAR_HEIGHT));

      timer = new Timer(15, taskPerformer);
      timer.start();
      audio.playSound("theme-slow.wav");
      try
      {
         displayFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
      }
      catch (FontFormatException | IOException ex)
      {
         System.out.println("Error: Font not found.");
      }
      displayFont = displayFont.deriveFont(16f);

   }

   /**
    This method

    @param column
    @param row

    @return
    */
   public Collidable getContents(int column, int row)
   {
      return gameBoard[column][row];
   }

   /**
    This method

    @param column
    @param row
    @param contents
    */
   private void setContents(double column, double row, Collidable contents)
   {
      gameBoard[(int) column][(int) row] = contents;
   }

   /**
    This method will draw sparkles along the border of the intro screen.

    @param g Graphics to be drawn upon.
    */
   private void drawSparkles(Graphics2D g)
   {
      g.setColor(new Color(170, 0, 0));
      for (int i = sparkleCycle; i < gameBoard.length; i += 5)
      {
         g.drawString("*", MARGIN_SIZE + i * GameManager.CHAR_WIDTH, MARGIN_SIZE + 12);
         int yPos = yOffset + (21 * GameManager.CHAR_HEIGHT);
         g.drawString("*", xOffset + (gameBoard.length - i) * GameManager.CHAR_WIDTH, yPos);
      }
      for (int i = sparkleCycle; i < gameBoard[0].length - 5; i += 5)
      {
         g.drawString("*", MARGIN_SIZE + ((gameBoard.length - 1) * GameManager.CHAR_WIDTH), yOffset + i * GameManager.CHAR_WIDTH - 4);
         g.drawString("*", xOffset, yOffset + ((gameBoard[0].length - i) * GameManager.CHAR_WIDTH) - 6 * GameManager.CHAR_WIDTH);
      }

      sparkleCycle = (sparkleCycle + 1) % 5;

   }

   /**
    This method will slow the timer down.
    */
   public void slowTimerDown()
   {
      timer.setDelay(250);
   }

   /**
    This method will speed the timer up.
    */
   public void speedUpTimer()
   {
      timer.setDelay(20);
   }

   /**
    This method will draw/display the intro screen.

    @param g Graphics to be drawn upon.
    */
   private void showIntroScreen(Graphics2D g)
   {
      g.setFont(displayFont);
      g.setColor(new Color(0, 0, 0));
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(new Color(255, 255, 255));
      int yPos = MARGIN_SIZE + 4 * GameManager.CHAR_HEIGHT;
      int xPos = xOffset + 27 * GameManager.CHAR_WIDTH;
      g.drawString("Q B a s i c   N i b b l e s", xPos, yPos);
      g.setColor(new Color(170, 170, 170));
      yPos += 2 * GameManager.CHAR_HEIGHT;
      xPos = xOffset + 20 * GameManager.CHAR_WIDTH;
      g.drawString("Copyright (C) Microsoft Corporation 1990", xPos, yPos);
      yPos += 2 * GameManager.CHAR_HEIGHT;
      xPos = xOffset + 9 * GameManager.CHAR_WIDTH;
      g.drawString("Nibbles is a game for one or two players.  Navigate your snakes", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      g.drawString("around the game board trying to eat up numbers while avoiding", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 7 * GameManager.CHAR_WIDTH;
      g.drawString("running into walls or other snakes.  The more numbers you eat up,", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 11 * GameManager.CHAR_WIDTH;
      g.drawString("the more points you gain and the longer your snake becomes.", xPos, yPos);
      yPos += 2 * GameManager.CHAR_HEIGHT;
      xPos = xOffset + 34 * GameManager.CHAR_WIDTH;
      g.drawString("Game Controls", xPos, yPos);
      yPos += 2 * GameManager.CHAR_HEIGHT;
      xPos = xOffset + 13 * GameManager.CHAR_WIDTH;
      g.drawString("General             Player 1               Player 2", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 35 * GameManager.CHAR_WIDTH;
      g.drawString("(Up)                   (Up)", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 12 * GameManager.CHAR_WIDTH;
      g.drawString("P - Pause                                       W", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 28 * GameManager.CHAR_WIDTH;//Different because unicode arrow is not 8px wide
      g.drawString("(Left)      (Right)    (Left) A   D (Right)", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 37 * GameManager.CHAR_WIDTH;
      g.drawString("                       S", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 34 * GameManager.CHAR_WIDTH;
      g.drawString("(Down)                 (Down)", xPos, yPos);
      yPos += 4 * GameManager.CHAR_HEIGHT;
      xPos = xOffset + 27 * GameManager.CHAR_WIDTH;
      g.drawString("Press any key to continue", xPos, yPos);
      drawSparkles(g);
      drawArrowsOnIntroScreen(g);
   }

   private void drawArrowsOnIntroScreen(Graphics2D g)
   {
      Font arrowFont = new Font(Font.MONOSPACED, Font.BOLD, 14);
      g.setFont(arrowFont);
      g.setColor(new Color(170, 170, 170));
      int xPos = xOffset + 37 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 16 * GameManager.CHAR_HEIGHT;
      g.drawString("\u2191", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 35 * GameManager.CHAR_WIDTH - 4;//Different because unicode arrow is not 8px wide
      g.drawString("\u2190", xPos, yPos);
      xPos += 3.75 * GameManager.CHAR_WIDTH;
      g.drawString("\u2192", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 37 * GameManager.CHAR_WIDTH;
      g.drawString("\u2193", xPos, yPos);
      g.setFont(displayFont);
   }

   /**
    This method will draw/display the skill level screen.

    @param g       Graphics to be drawn upon.
    @param focused Determines whether the underscore character should be
                   flashing if true, false otherwise. It is primarily meant to
                   draw the focus of the user.
    */
   private void showSkillLevelScreen(Graphics2D g, boolean focused)
   {
      showNumberOfPlayersScreen(g, false);
      String stringToShow = "Skill level (1 to 100)? ";
      int skill = manager.getSkill();
      if (skill > 0)
         stringToShow += Integer.toString(manager.getSkill());
      if (focused && flashState)
         stringToShow += "_";
      int xPos = xOffset + 20 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 5 * GameManager.CHAR_HEIGHT;
      g.setColor(new Color(170, 170, 170));
      g.drawString(stringToShow, xPos, yPos);
      xPos = xOffset + 21 * GameManager.CHAR_WIDTH;
      yPos += GameManager.CHAR_HEIGHT;
      g.drawString("1   = Novice", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      g.drawString("90  = Expert", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      g.drawString("100 = Twiddle Fingers", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 14 * GameManager.CHAR_WIDTH;
      g.drawString("(Computer speed may affect your skill level)", xPos, yPos);
   }

   /**
    This method will draw/display the number of players screen.

    @param g       Graphics to be drawn upon.
    @param focused Determines whether the underscore character should be
                   flashing if true, false otherwise. It is primarily meant to
                   draw the focus of the user.
    */
   private void showNumberOfPlayersScreen(Graphics2D g, boolean focused)
   {
      g.setColor(new Color(0, 0, 0));
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(new Color(170, 170, 170));
      String stringToShow = "How many players (1 or 2)? ";
      int numberOfPlayers = manager.getNumberOfPlayers();
      if (numberOfPlayers == 1)
         stringToShow += "1";
      else if (numberOfPlayers == 2)
         stringToShow += "2";
      if (focused && flashState)
         stringToShow += "_";
      int xPos = xOffset + 19 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 3 * GameManager.CHAR_HEIGHT;
      g.drawString(stringToShow, xPos, yPos);
   }

   /**
    This method will draw/display the increase speed screen.

    @param g       Graphics to be drawn upon.
    @param focused Determines whether the underscore character should be
                   flashing if true, false otherwise. It is primarily meant to
                   draw the focus of the user.
    */
   private void showIncreaseSpeedScreen(Graphics2D g, boolean focused)
   {
      showSkillLevelScreen(g, false);
      String stringToShow = "Increase game speed during play (Y or N)? ";
      if (manager.getIncreaseSpeed())
         stringToShow += "Y";
      else
         stringToShow += "N";
      if (focused && flashState)
         stringToShow += "_";
      int xPos = xOffset + 14 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 12 * GameManager.CHAR_HEIGHT;
      g.setColor(new Color(170, 170, 170));
      g.drawString(stringToShow, xPos, yPos);
   }

   /**
    This method will display the select whether the game should be in color or
    monochrome screen.

    @param g       Graphics to be drawn upon.
    @param focused Determines whether the underscore character should be
                   flashing if true, false otherwise. It is primarily meant to
                   draw the focus of the user.
    */
   private void showMonochromeOrColorScreen(Graphics2D g, boolean focused)
   {
      showIncreaseSpeedScreen(g, false);
      String stringToShow = "Monochrome or color monitor (M or C)? ";
      if (manager.getMonochrome())
         stringToShow += "M";
      else
         stringToShow += "C";
      if (focused && flashState)
         stringToShow += "_";
      int xPos = xOffset + 16 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 14 * GameManager.CHAR_HEIGHT;
      g.setColor(new Color(170, 170, 170));
      g.drawString(stringToShow, xPos, yPos);
   }

   /**
    This method will draw/display the start of the level screen.

    @param g Graphics to be drawn upon.
    */
   private void showStartOfLevelScreen(Graphics2D g)
   {
      drawGameBoard(g);
      if (manager.getLevel().getLevelNumber() != 1)
         paintPlayerInfoHeader(g);
      drawWhiteRedBox(g);
      g.setColor(new Color(255, 255, 255));
      int xPos = xOffset + 30 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + (int) (10.75 * GameManager.CHAR_HEIGHT);
      g.drawString("Level " + Integer.toString(manager.getLevel().getLevelNumber()) + ",  Push Space", xPos, yPos);
   }

   /**
    This method will draw/display the game over screen.

    @param g Graphics to be drawn upon.
    */
   private void showGameOverScreen(Graphics2D g)
   {
      drawGameBoard(g);
      paintPlayerInfoHeader(g);
      g.setColor(new Color(255, 255, 255));
      int xPos = xOffset + 23 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 8 * GameManager.CHAR_HEIGHT;
      int gWidth = 33 * GameManager.CHAR_WIDTH;
      int gHeight = 5 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      g.setColor(new Color(170, 0, 0));
      xPos = xOffset + 24 * GameManager.CHAR_WIDTH;
      yPos = yOffset + (int) (8.5 * GameManager.CHAR_HEIGHT);
      gWidth = 31 * GameManager.CHAR_WIDTH;
      gHeight = 4 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      xPos = xOffset + 31 * GameManager.CHAR_WIDTH;
      yPos = yOffset + 10 * GameManager.CHAR_HEIGHT - GameManager.CHAR_WIDTH;
      g.setColor(new Color(255, 255, 255));
      g.drawString("G A M E   O V E R", xPos, yPos);
      xPos = xOffset + 30 * GameManager.CHAR_WIDTH;
      yPos = yOffset + 12 * GameManager.CHAR_HEIGHT - GameManager.CHAR_WIDTH;
      g.drawString("Play Again?   (Y/N)", xPos, yPos);
   }

   /**
    This method will draw/display the screen notifying that the player died.

    @param g Graphics to be drawn upon.
    */
   private void showPlayerDiedScreen(Graphics2D g)
   {
      drawGameBoard(g);
      paintPlayerInfoHeader(g);
      drawWhiteRedBox(g);
      g.setColor(new Color(255, 255, 255));
      int xPos = xOffset + 26 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + (int) (11 * GameManager.CHAR_HEIGHT);
      if (manager.getLastDeath() == 0)
         g.drawString("Sammy Dies! Push Space! --->", xPos, yPos);
      else
         g.drawString("<---- Jake Dies! Push Space", xPos, yPos);
   }

   /**
    This method will paint the screen depending on what state the game manager
    is in.

    @param g Graphics to be drawn upon.
    */
   @Override
   public void paintComponent(Graphics g)
   {
      g.setColor(getBackground());
      g.fillRect(0, 0, getWidth(), getHeight());
      Graphics2D g2 = (Graphics2D) g;
      g2.setFont(displayFont);
      flashState = !flashState;
      switch (manager.getCurrentState())
      {
         case introScreen:
            showIntroScreen(g2);
            break;
         case numberOfPlayersScreen:
            showNumberOfPlayersScreen(g2, true);
            break;
         case skillLevelScreen:
            showSkillLevelScreen(g2, true);
            break;
         case increaseSpeedScreen:
            showIncreaseSpeedScreen(g2, true);
            break;
         case monochromeOrColorScreen:
            showMonochromeOrColorScreen(g2, true);
            break;
         case startOfLevel:
            showStartOfLevelScreen(g2);
            break;
         case gameplayScreen:
            drawGamePlayScreen(g2);
            break;
         case paused:
            drawPauseScreen(g2);
            break;
         case playerDied:
            showPlayerDiedScreen(g2);
            break;
         case gameOver:
            showGameOverScreen(g2);
      }
   }

   /**
    This method will draw the play screen of the game.

    @param g Graphics to be drawn upon.
    */
   private void drawGamePlayScreen(Graphics2D g)
   {
      drawGameBoardWithFood(g);
      drawSnakes(g);
   }

   /**
    This method will load the level, set by the game manager, onto the game
    board.
    */
   private void loadLevel()
   {
      level = manager.getLevel();
      if (level == null)
         level = new Level();
      Collidable[][] tempGrid = level.getLevelGrid();
      for (int column = 0; column < gameBoard.length; column++)
         System.arraycopy(tempGrid[column], 0, gameBoard[column], 0, gameBoard[column].length);
   }

   /**
    This method will draw the game board.

    @param g Graphics to be drawn upon.
    */
   private void drawGameBoard(Graphics2D g)
   {
      try
      {
         loadLevel();
      }
      catch (Exception e)
      {
         level = new Level();
      }
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
         {
            int xPos = xOffset + column * GameManager.CHAR_WIDTH;
            int yPos = yOffset + row * GameManager.CHAR_WIDTH;
            gameBoard[column][row].draw(g, xPos, yPos);
         }
      if (manager.getMonochrome())
         g.setColor(new Color(0, 0, 0));
      else
         g.setColor(new Color(0, 0, 170));
      g.fillRect(xOffset, MARGIN_SIZE, gameBoard.length * GameManager.CHAR_WIDTH, GameManager.CHAR_HEIGHT);
   }

   /**
    This method will draw the game board with food on it.

    @param g Graphics to be drawn upon.
    */
   private void drawGameBoardWithFood(Graphics2D g)
   {
      try
      {
         loadLevel();
      }
      catch (Exception e)
      {
         level = new Level();
      }
      Food[] foods = manager.getFood();
      for (int i = 0; i < foods.length; i++)
         if (foods[i] != null)
            setContents(foods[i].position.x, foods[i].position.y, foods[i]);
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
         {
            int xPos = xOffset + column * GameManager.CHAR_WIDTH;
            int yPos = yOffset + row * GameManager.CHAR_WIDTH;
            gameBoard[column][row].draw(g, xPos, yPos);
         }
      paintPlayerInfoHeader(g);

   }

   /**
    This method will draw the snakes.

    @param g Graphics to be drawn upon.
    */
   private void drawSnakes(Graphics2D g)
   {
      Snake[] snakes = manager.getSnakes();
      for (int i = 0; i < manager.getNumberOfPlayers(); i++)
         snakes[i].draw(g, xOffset, yOffset);
   }

   /**
    This method will draw the white red box displayed before the start of each
    round, at the end of each round, and during pause screens.

    @param g Graphics to be drawn upon.
    */
   private void drawWhiteRedBox(Graphics2D g)
   {
      g.setColor(new Color(255, 255, 255));
      int xPos = xOffset + 23 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 9 * GameManager.CHAR_HEIGHT;
      int gWidth = 33 * GameManager.CHAR_WIDTH;
      int gHeight = 3 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      g.setColor(new Color(170, 0, 0));
      xPos = xOffset + 24 * GameManager.CHAR_WIDTH;
      yPos = yOffset + (int) (9.5 * GameManager.CHAR_HEIGHT);
      gWidth = 31 * GameManager.CHAR_WIDTH;
      gHeight = 2 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
   }

   /**
    This method will draw the pause screen when the game is paused.

    @param g Graphics to be drawn upon.
    */
   private void drawPauseScreen(Graphics2D g)
   {
      drawGamePlayScreen(g);
      drawWhiteRedBox(g);
      g.setColor(new Color(255, 255, 255));
      int xPos = xOffset + 26 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + (int) (10.75 * GameManager.CHAR_HEIGHT);
      g.drawString("Game Paused ... Push Space", xPos, yPos);
   }

   /**
    This method will paint the player information that is display at the top
    of the game panel.

    @param g Graphics to be drawn upon.
    */
   private void paintPlayerInfoHeader(Graphics2D g)
   {
      Snake[] snakes = manager.getSnakes();
      if (snakes[0] != null)
      {
         if (manager.getMonochrome())
            g.setColor(new Color(0, 0, 0));
         else
            g.setColor(new Color(0, 0, 170));
         g.fillRect(MARGIN_SIZE, MARGIN_SIZE, GameManager.CHAR_WIDTH * gameBoard.length, GameManager.CHAR_HEIGHT);
         g.setColor(new Color(255, 255, 255));
         int yPos = yOffset - 2;
         String sammyString = "SAMMY-->  Lives: "
               + Integer.toString(snakes[0].getLives())
               + "     "
               + Integer.toString(snakes[0].getScore());
         int xPos = xOffset + 48 * GameManager.CHAR_WIDTH;
         g.drawString(sammyString, xPos, yPos);
         if (manager.getNumberOfPlayers() == 2)
         {
            String jakeString = Integer.toString(snakes[1].getScore())
                  + "  Lives: "
                  + Integer.toString(snakes[1].getLives())
                  + "  <--JAKE";
            xPos = xOffset + GameManager.CHAR_WIDTH;
            g.drawString(jakeString, xPos, yPos);
         }
      }
   }
}
