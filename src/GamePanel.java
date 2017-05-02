
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import sun.audio.*;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class 

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class GamePanel extends JPanel
{

   private static final Font DISPLAY_FONT = new Font(Font.MONOSPACED, Font.BOLD, 14);
   private static final int MARGIN_SIZE = 0;
   private Collidable gameBoard[][];
   private Level level;
   private Timer timer;
   private int sparkleCycle;
   private final int xOffset;
   private final int yOffset;
   private boolean flashState;
   private final GameManager manager;
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
   This constructor 
   
   @param boardWidth
   @param boardHeight
   @param inManager 
   */
   public GamePanel(int boardWidth, int boardHeight, GameManager inManager)
   {
      sparkleCycle = 0;
      manager = inManager;
      gameBoard = new Collidable[boardWidth][boardHeight];
      xOffset = MARGIN_SIZE;
      yOffset = MARGIN_SIZE + GameManager.CHAR_HEIGHT;
      /*for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
            gameBoard[column][row] = CellContents.EMPTY;*/
      setPreferredSize(
            new Dimension(GameManager.CHAR_WIDTH * boardWidth + 2 * MARGIN_SIZE,
                  GameManager.CHAR_WIDTH * boardHeight + 2 * MARGIN_SIZE + GameManager.CHAR_HEIGHT));

      timer = new Timer(15, taskPerformer);
      timer.start();
      try
      {
         InputStream inputStream = new FileInputStream("./resources/theme-slow.wav");
         AudioStream audioStream = new AudioStream(inputStream);
         AudioPlayer.player.start(audioStream);
      }
      catch (IOException e)
      {
         System.err.println("File not found.");
      }
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
   This method 
   
   @param g 
   */
   private void drawSparkles(Graphics2D g)
   {
      g.setColor(Color.red);
      for (int i = sparkleCycle; i < gameBoard.length; i += 5)
      {
         g.drawString("*", MARGIN_SIZE + i * GameManager.CHAR_WIDTH, MARGIN_SIZE + GameManager.CHAR_HEIGHT);
         int yPos = yOffset + (21 * GameManager.CHAR_HEIGHT);
         g.drawString("*", xOffset + (gameBoard.length - i) * GameManager.CHAR_WIDTH, yPos);
      }
      for (int i = sparkleCycle; i < gameBoard[0].length - 4; i += 5)
      {
         g.drawString("*", MARGIN_SIZE + ((gameBoard.length - 1) * GameManager.CHAR_WIDTH), yOffset + i * GameManager.CHAR_WIDTH - 2 * GameManager.CHAR_WIDTH);
         g.drawString("*", xOffset, yOffset + ((gameBoard[0].length - i) * GameManager.CHAR_WIDTH) - 5 * GameManager.CHAR_WIDTH);
      }
      if (sparkleCycle >= 5)
         sparkleCycle = 0;
      sparkleCycle++;

   }

   /**
   This method 
   */
   public void slowTimerDown()
   {
      timer.setDelay(250);
   }

   /**
   This method 
   */
   public void speedUpTimer()
   {
      timer.setDelay(20);
   }

   /**
   This method 
   
   @param g 
   */
   private void showIntroScreen(Graphics2D g)
   {
      g.setFont(DISPLAY_FONT);
      g.setColor(Color.black);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(Color.white);
      int yPos = MARGIN_SIZE + 4 * GameManager.CHAR_HEIGHT;
      int xPos = xOffset + 27 * GameManager.CHAR_WIDTH;
      g.drawString("Q B a s i c   N i b b l e s", xPos, yPos);
      g.setColor(Color.gray);
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
      g.drawString("P - Pause                " + '\u2191' + "                      W", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 28 * GameManager.CHAR_WIDTH - 2;//Different because unicode arrow is not 8px wide
      g.drawString("(Left) " + '\u2190' + "  " + '\u2192' + " (Right)   (Left) A   D (Right)", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 37 * GameManager.CHAR_WIDTH;
      g.drawString('\u2193' + "                      S", xPos, yPos);
      yPos += GameManager.CHAR_HEIGHT;
      xPos = xOffset + 34 * GameManager.CHAR_WIDTH;
      g.drawString("(Down)                 (Down)", xPos, yPos);
      yPos += 4 * GameManager.CHAR_HEIGHT;
      xPos = xOffset + 27 * GameManager.CHAR_WIDTH;
      g.drawString("Press any key to continue", xPos, yPos);
      drawSparkles(g);
   }

   /**
   This method 
   
   @param g
   @param focused 
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
      g.setColor(Color.gray);
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
   This method 
   
   @param g
   @param focused 
   */
   private void showNumberOfPlayersScreen(Graphics2D g, boolean focused)
   {
      g.setColor(Color.black);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(Color.gray);
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
   This method 
   
   @param g
   @param focused 
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
      g.setColor(Color.gray);
      g.drawString(stringToShow, xPos, yPos);
   }

   /**
   This method 
   
   @param g
   @param focused 
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
      g.setColor(Color.gray);
      g.drawString(stringToShow, xPos, yPos);
   }

   /**
   This method 
   
   @param g 
   */
   private void showStartOfLevelScreen(Graphics2D g)
   {
      drawGameBoard(g);
      drawWhiteRedBox(g);
      g.setColor(Color.white);
      int xPos = xOffset + 30 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + (int) (10.75 * GameManager.CHAR_HEIGHT);
      g.drawString("Level " + Integer.toString(manager.getLevel().getLevelNumber()) + ",  Push Space", xPos, yPos);
   }

   /**
   This method 
   
   @param g 
   */
   private void showGameOverScreen(Graphics2D g)
   {
      drawGameBoard(g);
      g.setColor(Color.white);
      int xPos = xOffset + 23 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 8 * GameManager.CHAR_HEIGHT;
      int gWidth = 33 * GameManager.CHAR_WIDTH;
      int gHeight = 5 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      g.setColor(Color.red);
      xPos = xOffset + 24 * GameManager.CHAR_WIDTH;
      yPos = yOffset + (int) (8.5 * GameManager.CHAR_HEIGHT);
      gWidth = 31 * GameManager.CHAR_WIDTH;
      gHeight = 4 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      xPos = xOffset + 31 * GameManager.CHAR_WIDTH;
      yPos = yOffset + 10 * GameManager.CHAR_HEIGHT - GameManager.CHAR_WIDTH;
      g.setColor(Color.white);
      g.drawString("G A M E   O V E R", xPos, yPos);
      xPos = xOffset + 30 * GameManager.CHAR_WIDTH;
      yPos = yOffset + 12 * GameManager.CHAR_HEIGHT - GameManager.CHAR_WIDTH;
      g.drawString("Play Again?   (Y/N)", xPos, yPos);
   }

   /**
   This method 
   
   @param g 
   */
   private void showPlayerDiedScreen(Graphics2D g)
   {
      drawGameBoard(g);
      drawWhiteRedBox(g);
      g.setColor(Color.white);
      int xPos = xOffset + 26 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + (int) (11 * GameManager.CHAR_HEIGHT);
      if (manager.getLastDeath() == 0)
         g.drawString("Sammy Dies! Push Space! --->", xPos, yPos);
      else
         g.drawString("<---- Jake Dies! Push Space", xPos, yPos);
   }

   /**
   This method 
   
   @param g 
   */
   @Override
   public void paintComponent(Graphics g)
   {
      g.setColor(getBackground());
      g.fillRect(0, 0, getWidth(), getHeight());
      Graphics2D g2 = (Graphics2D) g;
      g2.setFont(DISPLAY_FONT);
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
   This method 
   
   @param g 
   */
   private void drawGamePlayScreen(Graphics2D g)
   {
      drawGameBoardWithFood(g);
      drawSnakes(g);
   }

   /**
   This method 
   */
   public void stopTimer()
   {
      timer.stop();
   }

   /**
   This method 
   */
   public void startTimer()
   {
      timer.start();
   }

   /**
   This method 
   */
   private void loadLevel()
   {
      level = manager.getLevel();
      Collidable[][] tempGrid = level.getLevelGrid();
      for (int column = 0; column < gameBoard.length; column++)
         System.arraycopy(tempGrid[column], 0, gameBoard[column], 0, gameBoard[column].length);
   }

   /**
   This method 
   
   @param g 
   */
   private void drawGameBoard(Graphics2D g)
   {
      loadLevel();
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
         {
            int xPos = xOffset + column * GameManager.CHAR_WIDTH;
            int yPos = yOffset + row * GameManager.CHAR_WIDTH;
            gameBoard[column][row].draw(g, xPos, yPos);
         }
      paintInformationLine(g);

   }

   /**
   This method 
   
   @param g 
   */
   private void drawGameBoardWithFood(Graphics2D g)
   {
      loadLevel();
      Food[] foods = manager.getFood();
      for (Food food : foods)
         setContents(food.position.x, food.position.y, food);
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
         {
            int xPos = xOffset + column * GameManager.CHAR_WIDTH;
            int yPos = yOffset + row * GameManager.CHAR_WIDTH;
            gameBoard[column][row].draw(g, xPos, yPos);
         }
      paintInformationLine(g);

   }

   /**
   This method 
   
   @param g 
   */
   private void drawSnakes2(Graphics2D g)
   {
      for (Snake snake : manager.getSnakes())
      {
         Point2D.Double headLocation = snake.getHeadLocation();
         g.setColor(Color.yellow);
         int xPos = xOffset + (int) headLocation.x * GameManager.CHAR_WIDTH;
         int yPos = yOffset + (int) headLocation.y * GameManager.CHAR_WIDTH;
         g.fillRect(xPos, yPos, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH);
         g.setColor(Color.orange);
         java.util.List<SnakeSegment> segments = snake.getSnakeSegments();
         for (int j = 0; j < segments.size(); j++)
         {
            Point2D.Double segmentPosition = segments.get(j).getPosition();
            xPos = xOffset + (int) segmentPosition.x * GameManager.CHAR_WIDTH;
            yPos = yOffset + (int) segmentPosition.y * GameManager.CHAR_WIDTH;
            g.fillRect(xPos, yPos, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH);
         }
      }
   }

   /**
   This method 
   
   @param g 
   */
   private void drawSnakes(Graphics2D g)
   {
      for (Snake snake : manager.getSnakes())
         snake.draw(g, xOffset, yOffset);
   }

   /*private void flushGameBoard()
   {
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
            gameBoard[column][row] = CellContents.EMPTY;
   }*/
   
   /**
   This method 
   
   @param g 
   */
   private void drawWhiteRedBox(Graphics2D g)
   {
      g.setColor(Color.white);
      int xPos = xOffset + 23 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + 9 * GameManager.CHAR_HEIGHT;
      int gWidth = 33 * GameManager.CHAR_WIDTH;
      int gHeight = 3 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      g.setColor(Color.red);
      xPos = xOffset + 24 * GameManager.CHAR_WIDTH;
      yPos = yOffset + (int) (9.5 * GameManager.CHAR_HEIGHT);
      gWidth = 31 * GameManager.CHAR_WIDTH;
      gHeight = 2 * GameManager.CHAR_HEIGHT;
      g.fillRect(xPos, yPos, gWidth, gHeight);
   }

   /**
   This method 
   
   @param g 
   */
   private void drawPauseScreen(Graphics2D g)
   {
      drawGamePlayScreen(g);
      drawWhiteRedBox(g);
      g.setColor(Color.white);
      int xPos = xOffset + 26 * GameManager.CHAR_WIDTH;
      int yPos = yOffset + (int) (10.75 * GameManager.CHAR_HEIGHT);
      g.drawString("Game Paused ... Push Space", xPos, yPos);
   }

   /**
   This method 
   
   @param g 
   */
   private void paintInformationLine(Graphics2D g)
   {
      Snake[] snakes = manager.getSnakes();
      g.setColor(Color.blue);
      g.fillRect(MARGIN_SIZE, MARGIN_SIZE, GameManager.CHAR_WIDTH * gameBoard.length, GameManager.CHAR_HEIGHT);
      g.setColor(Color.white);
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
