
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class GamePanel extends JPanel
{

   private static final Font DISPLAY_FONT = new Font(Font.MONOSPACED, Font.BOLD, 14);
   private static final int MARGIN_SIZE = 10;
   private CellContents gameBoard[][];
   private final int charWidth;
   private Level level;
   private static int charHeight;
   private Timer timer;
   private int sparkleCycle;
   private final int xOffset;
   private final int yOffset;

   private final GameManager manager;

   public enum CellContents
   {
      EMPTY, WALL, FOOD, SNAKE, SNAKEHEAD
   };

   public GamePanel(int boardWidth, int boardHeight, int inCharWidth, GameManager inManager)
   {
      sparkleCycle = 0;
      manager = inManager;
      charWidth = inCharWidth;
      charHeight = 2 * charWidth;
      gameBoard = new CellContents[boardWidth][boardHeight];
      xOffset = MARGIN_SIZE;
      yOffset = MARGIN_SIZE + charHeight;
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
            gameBoard[column][row] = CellContents.EMPTY;
      setPreferredSize(
            new Dimension(charWidth * boardWidth + 2 * MARGIN_SIZE,
                  charWidth * boardHeight + 2 * MARGIN_SIZE + charHeight));
      ActionListener taskPerformer = (ActionEvent evt)
            -> 
            {
               repaint();
      };
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

   public CellContents getContents(int column, int row)
   {
      return gameBoard[column][row];
   }

   public void setContents(double column, double row, CellContents contents)
   {
      gameBoard[(int) column][(int) row] = contents;
   }

   private void updateFood()
   {
      Food food = manager.getFood();
      Point2D.Double foodPosition = food.getPosition();
      setContents(foodPosition.x, foodPosition.y, GamePanel.CellContents.FOOD);
   }

   private void drawSparkles(Graphics2D g)
   {
      g.setColor(Color.red);
      for (int i = sparkleCycle; i < gameBoard.length; i += 5)
      {
         g.drawString("*", xOffset + i * charWidth, MARGIN_SIZE);
         int yPos = yOffset + (21 * charHeight);
         g.drawString("*", xOffset + (gameBoard.length - i) * charWidth, yPos);
      }
      for (int i = sparkleCycle; i < gameBoard[0].length; i += 5)
      {
         g.drawString("*", xOffset + (gameBoard.length * charWidth), yOffset + i * charWidth - 5 * charWidth);
         g.drawString("*", xOffset, yOffset + ((gameBoard[0].length - i) * charWidth) - 5 * charWidth);
      }
      if (sparkleCycle >= 5)
         sparkleCycle = 0;
      sparkleCycle++;

   }

   public void slowTimerDown()
   {
      timer.setDelay(250);
   }

   public void speedUpTimer()
   {
      timer.setDelay(20);
   }

   private void showIntroScreen(Graphics2D g)
   {
      g.setFont(DISPLAY_FONT);
      g.setColor(Color.black);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(Color.white);
      int yPos = MARGIN_SIZE + 4 * charHeight;
      int xPos = xOffset + 27 * charWidth;
      g.drawString("Q B a s i c   N i b b l e s", xPos, yPos);
      g.setColor(Color.gray);
      yPos += 2 * charHeight;
      xPos = xOffset + 20 * charWidth;
      g.drawString("Copyright (C) Microsoft Corporation 1990", xPos, yPos);
      yPos += 2 * charHeight;
      xPos = xOffset + 9 * charWidth;
      g.drawString("Nibbles is a game for one or two players.  Navigate your snakes", xPos, yPos);
      yPos += charHeight;
      g.drawString("around the game board trying to eat up numbers while avoiding", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 7 * charWidth;
      g.drawString("running into walls or other snakes.  The more numbers you eat up,", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 11 * charWidth;
      g.drawString("the more points you gain and the longer your snake becomes.", xPos, yPos);
      yPos += 2 * charHeight;
      xPos = xOffset + 34 * charWidth;
      g.drawString("Game Controls", xPos, yPos);
      yPos += 2 * charHeight;
      xPos = xOffset + 13 * charWidth;
      g.drawString("General             Player 1               Player 2", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 35 * charWidth;
      g.drawString("(Up)                   (Up)", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 12 * charWidth;
      g.drawString("P - Pause                " + '\u2191' + "                      W", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 28 * charWidth - 2;//Different because unicode arrow is not 8px wide
      g.drawString("(Left) " + '\u2190' + "  " + '\u2192' + " (Right)   (Left) A   D (Right)", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 37 * charWidth;
      g.drawString('\u2193' + "                      S", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 34 * charWidth;
      g.drawString("(Down)                 (Down)", xPos, yPos);
      yPos += 4 * charHeight;
      xPos = xOffset + 27 * charWidth;
      g.drawString("Press any key to continue", xPos, yPos);
      drawSparkles(g);
   }

   private boolean flashState = false;

   private void showSkillLevelScreen(Graphics2D g, boolean focused)
   {
      showNumberOfPlayersScreen(g, false);
      String stringToShow = "Skill level (1 to 100)? ";
      int skill = manager.getSkill();
      if (skill > 0)
         stringToShow += Integer.toString(manager.getSkill());
      if (focused && flashState)
         stringToShow += "_";
      int xPos = xOffset + 20 * charWidth;
      int yPos = yOffset + 5 * charHeight;
      g.setColor(Color.gray);
      g.drawString(stringToShow, xPos, yPos);
      xPos = xOffset + 21 * charWidth;
      yPos += charHeight;
      g.drawString("1   = Novice", xPos, yPos);
      yPos += charHeight;
      g.drawString("90  = Expert", xPos, yPos);
      yPos += charHeight;
      g.drawString("100 = Twiddle Fingers", xPos, yPos);
      yPos += charHeight;
      xPos = xOffset + 14 * charWidth;
      g.drawString("(Computer speed may affect your skill level)", xPos, yPos);
   }

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
      int xPos = xOffset + 19 * charWidth;
      int yPos = yOffset + 3 * charHeight;
      g.drawString(stringToShow, xPos, yPos);
   }

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
      int xPos = xOffset + 14 * charWidth;
      int yPos = yOffset + 12 * charHeight;
      g.setColor(Color.gray);
      g.drawString(stringToShow, xPos, yPos);
   }

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
      int xPos = xOffset + 16 * charWidth;
      int yPos = yOffset + 14 * charHeight;
      g.setColor(Color.gray);
      g.drawString(stringToShow, xPos, yPos);
   }

   private void showStartOfLevelScreen(Graphics2D g)
   {
      drawGameBoard(g);

   }

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
            updateFood();
            drawGameBoard(g2);
            paintInformationLine(g2);
            drawSnakes(g2);
            if (manager.isPaused())
               drawPauseScreen(g2);
            break;
      }
   }

   public void stopTimer()
   {
      timer.stop();
   }

   public void startTimer()
   {
      timer.start();
   }

   private void loadLevel()
   {
      level = manager.getLevel();
      CellContents[][] tempGrid = level.getLevelGrid();
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
            gameBoard[column][row] = tempGrid[column][row];
   }

   private void drawGameBoard(Graphics2D g)
   {
      loadLevel();
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
         {
            g.setColor(getContentColor(getContents(column, row)));
            int xPos = xOffset + column * charWidth;
            int yPos = yOffset + row * charWidth;
            g.fillRect(xPos, yPos, charWidth, charWidth);
         }
   }

   private void drawSnakes(Graphics2D g)
   {
      Snake[] snakes = manager.getSnakes();
      for (int i = 0; i < snakes.length; i++)
      {
         Point2D.Double headLocation = snakes[i].getHeadLocation();
         g.setColor(getContentColor(CellContents.SNAKEHEAD));
         int xPos = xOffset + (int) headLocation.x * charWidth;
         int yPos = yOffset + (int) headLocation.y * charWidth;
         g.fillRect(xPos, yPos, charWidth, charWidth);
         g.setColor(getContentColor(CellContents.SNAKE));
         java.util.List<SnakeSegment> segments = snakes[i].getSnakeSegments();
         for (int j = 0; j < segments.size(); j++)
         {
            Point2D.Double segmentPosition = segments.get(j).getPosition();
            xPos = xOffset + (int) segmentPosition.x * charWidth;
            yPos = yOffset + (int) segmentPosition.y * charWidth;
            g.fillRect(xPos, yPos, charWidth, charWidth);
         }
      }
   }

   private void flushGameBoard()
   {
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
            gameBoard[column][row] = CellContents.EMPTY;
   }

   private void drawPauseScreen(Graphics2D g)
   {
      g.setColor(Color.white);
      int xPos = xOffset + 23 * charWidth;
      int yPos = yOffset + 9 * charHeight;
      int gWidth = 33 * charWidth;
      int gHeight = 3 * charHeight;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      g.setColor(Color.red);
      xPos = xOffset + 24 * charWidth;
      yPos = yOffset + (int) (9.5 * charHeight);
      gWidth = 31 * charWidth;
      gHeight = 2 * charHeight;
      g.fillRect(xPos, yPos, gWidth, gHeight);
      g.setColor(Color.white);
      xPos = xOffset + 26 * charWidth;
      yPos = yOffset + (int) (10.75 * charHeight);
      g.drawString("Game Paused ... Push Space", xPos, yPos);
   }

   private void paintInformationLine(Graphics2D g)
   {
      g.setColor(Color.blue);
      //getWidth() was previously width, which is previously being initalized to boardWidth in the constructor.
      g.fillRect(MARGIN_SIZE, MARGIN_SIZE, charWidth * gameBoard.length, charHeight);
      g.setColor(Color.white);
      int yPos = yOffset - 2;
      String sammyString = "SAMMY-->  Lives: "
            + Integer.toString(manager.getPlayerLives(GameManager.playerEnum.PLAYER_ONE))
            + "     "
            + Integer.toString(manager.getPlayerScore(GameManager.playerEnum.PLAYER_ONE));
      int xPos = xOffset + 48 * charWidth;
      g.drawString(sammyString, xPos, yPos);
      if (manager.getNumberOfPlayers() == 2)
      {
         String jakeString = Integer.toString(manager.getPlayerScore(GameManager.playerEnum.PLAYER_TWO))
               + "  Lives: "
               + Integer.toString(manager.getPlayerLives(GameManager.playerEnum.PLAYER_TWO))
               + "  <--JAKE";
         xPos = xOffset + charWidth;
         g.drawString(jakeString, xPos, yPos);
      }
   }

   private Color getContentColor(CellContents content)
   {
      switch (content)
      {
         case WALL:
            return Color.red;
         case FOOD:
            return Color.white;
         case SNAKE:
            return Color.orange;
         case SNAKEHEAD:
            return Color.yellow;
         default:
         case EMPTY:
            return Color.blue;
      }
   }

}
