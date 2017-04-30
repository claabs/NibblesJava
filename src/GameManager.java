
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class GameManager
{

   private static final int MARGIN_SPACING = 20;
   private static final int TITLE_BAR_HEIGHT = 25;
   //Nick and Noah Area
   private boolean accelerate;
   private int currentLevel = 0;
   private int difficulty;
   private final GamePanel gameBoard;
   private LevelConstructor levelConstructor = new LevelConstructor();
   private Level level = null;
   private Snake players[];
   private int speed;
   private boolean paused;
   public Timer timer;
   private int updateInterval = 60;  // ms
   private final JFrame window;
   private Food food;
   private int numberOfPlayers;
   private int skill;
   private boolean increaseSpeed;
   private boolean monochrome;
   private eventEnum currentState;
   private static Random random = new Random(5);

   public static final int CHAR_WIDTH = 8;
   public static final int CHAR_HEIGHT = 2 * CHAR_WIDTH;
   private static final int NUM_ROWS = 48;
   private static final int NUM_COLUMNS = 80;

   public enum playerEnum
   {
      PLAYER_ONE, PLAYER_TWO
   }

   public enum eventEnum
   {
      introScreen,
      numberOfPlayersScreen,
      skillLevelScreen,
      increaseSpeedScreen,
      monochromeOrColorScreen,
      startOfLevel,
      gameplayScreen,
      gameOver
   }

   public GameManager(JFrame inWindow)
   {
      window = inWindow;
      food = new Food(1, new Point2D.Double(30, 30));
      currentState = eventEnum.introScreen;
      numberOfPlayers = -1;
      skill = 0;
      gameBoard = new GamePanel(NUM_COLUMNS, NUM_ROWS, this);
      ActionListener taskPerformer = (ActionEvent evt)
            -> 
            {
               run();
      };
      timer = new Timer(updateInterval, taskPerformer);
      window.getContentPane().add(gameBoard);
      window.pack();
      window.addKeyListener((KeyListener) new KeyboardListener(this));
      window.setVisible(true);
   }

   public void setNumberOfPlayers(int inNumberOfPlayers)
   {
      numberOfPlayers = inNumberOfPlayers;
   }

   public int getSkill()
   {
      return skill;
   }

   public void setSkill(int inSkill)
   {
      skill = inSkill;
   }

   public eventEnum getCurrentState()
   {
      return currentState;
   }

   public boolean getIncreaseSpeed()
   {
      return increaseSpeed;
   }

   public void setIncreaseSpeed(boolean inIncreaseSpeed)
   {
      increaseSpeed = inIncreaseSpeed;
   }

   public boolean getMonochrome()
   {
      return monochrome;
   }

   public void setMonochrome(boolean inMonochrome)
   {
      monochrome = inMonochrome;
   }

   public void restart()
   {
      currentLevel = 0;
      prepGame();
      currentState = eventEnum.startOfLevel;
   }

   private void prepGame()
   {
      for (int i = 0; i < numberOfPlayers; i++)
         players[i] = new Snake(new Point2D.Double(5, 5), Snake.Direction.UP);
      loadLevel(currentLevel);
   }

   public void progressState()
   {
      switch (currentState)
      {
         case introScreen:
            gameBoard.slowTimerDown();
            currentState = eventEnum.numberOfPlayersScreen;
            break;
         case numberOfPlayersScreen:
            currentState = eventEnum.skillLevelScreen;
            players = new Snake[numberOfPlayers];
            prepGame();
            break;
         case skillLevelScreen:
            currentState = eventEnum.increaseSpeedScreen;
            break;
         case increaseSpeedScreen:
            currentState = eventEnum.monochromeOrColorScreen;
            break;
         case monochromeOrColorScreen:
            currentState = eventEnum.startOfLevel;
            break;
         case startOfLevel:
            currentState = eventEnum.gameplayScreen;
            gameBoard.stopTimer();
            gameBoard.speedUpTimer();
            startGame();
            break;
         default:
      }
   }

   public int getNumberOfPlayers()
   {
      return numberOfPlayers;
   }

   private void startGame()
   {
      timer.start();
      gameBoard.startTimer();
   }

   private void respawn()
   {
      for (int i = 0; i < players.length; i++)
         players[i].respawn();
   }

   private int getIntFromPlayerEnum(playerEnum player)
   {
      if (player == playerEnum.PLAYER_ONE)
         return 0;
      else if (player == playerEnum.PLAYER_TWO)
         return 1;
      return -1;
   }

   //public static SnakeDirection[] directionSnake = new SnakeDirection[2];
   public void setPlayerDirection(playerEnum player, Snake.Direction direction)
   {
      players[getIntFromPlayerEnum(player)].setDirection(direction);
   }

   public Snake.Direction getDirectionLastMoved(playerEnum player)
   {
      return players[getIntFromPlayerEnum(player)].getDirectionLastMoved();
   }

   public int getPlayerLives(playerEnum player)
   {
      return players[getIntFromPlayerEnum(player)].getLives();
   }

   public int getPlayerScore(playerEnum player)
   {
      return players[getIntFromPlayerEnum(player)].getScore();
   }

   private void loadLevel(int levelIndex)
   {
      level = levelConstructor.getLevel(levelIndex);
      Snake.Direction[] startingDirections = level.getStartingDirections();
      Point2D.Double[] spawnPoints = level.getSpawnPoints();
      for (int i = 0; i < numberOfPlayers; i++)
         players[i].moveSpawn(spawnPoints[i], startingDirections[i]);
   }

   public Level getLevel()
   {
      return level;
   }

   public int getLevelNumber()
   {
      return currentLevel + 1;
   }

   /**
    This method will be called by the timer only if the game is not paused.
    */
   private void updateGame()
   {
      for (int i = 0; i < players.length; i++)
      {
         Point2D.Double headPos = players[i].getHeadLocation();
         if (gameBoard.getContents((int) headPos.x, (int) headPos.y) == GamePanel.CellContents.WALL)
         {
            killPlayer(i);
            return;
         }
         else
         {
            players[i].iterateForward();
            for (int j = 0; j < players.length; j++)
            {
               Snake otherPlayer = players[j];
               java.util.List segments = otherPlayer.getSnakeSegments();
               for (int k = 0; k < segments.size(); k++)
                  if (players[i].checkCollison((Collidable) segments.get(k)))
                  {
                     killPlayer(i);
                     return;
                  }
            }
            if (players[i].checkCollison(food))
            {
               players[i].eat(food);
               if (players[i].getNumTimesEaten() == 8)
               {
                  nextLevel();
                  return;
               }
               food = new Food(food.getValue() + 1, getRandomPosition());
            }
         }
      }
   }

   private void nextLevel()
   {
      timer.stop();
      currentState = eventEnum.startOfLevel;
      currentLevel++;
      loadLevel(currentLevel);
      food = new Food(1, getRandomPosition());
   }

   private Point2D.Double getRandomPosition()
   {
      Point2D.Double possiblePosition
            = new Point2D.Double(
                  (double) (int) (random.nextDouble() * NUM_COLUMNS),
                  (double) (int) (random.nextDouble() * NUM_ROWS)
            );
      if (gameBoard.getContents((int) possiblePosition.x, (int) possiblePosition.y) == GamePanel.CellContents.EMPTY)
         return possiblePosition;
      else
         return getRandomPosition();
   }

   private void killPlayer(int playerIndex)
   {
      timer.stop();
      players[playerIndex].die();
      if (players[playerIndex].gameOver())
         currentState = eventEnum.gameOver;
      else
      {
         respawn();
         timer.start();
      }

   }

   public Snake[] getSnakes()
   {
      return players;
   }

   public void pause()
   {
      paused = true;
   }

   public void unpause()
   {
      paused = false;
   }

   public void run()
   {
      if (!paused)
         updateGame();
   }

   public Food getFood()
   {
      return food;
   }

   public boolean isPaused()
   {
      return paused;
   }
}
