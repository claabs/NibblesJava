
import java.util.Random;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import javax.swing.*;
import sun.audio.*;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class manages all of the game's primary functions. It will
          handle functions like progressing the state of the game, killing
          players, setting skill levels, increasing game speed, switching
          levels, pausing the game and acquiring food.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class GameManager
{

   public static final int CHAR_WIDTH = 8;
   public static final int CHAR_HEIGHT = 2 * CHAR_WIDTH;

   private static final Random random = new Random();
   private int currentLevel = 0;
   private final GamePanel gameBoard;
   private final LevelConstructor levelConstructor = new LevelConstructor();
   private Level level = null;
   private Snake players[];
   private final Timer timer;
   private int updateInterval = 60;  // ms
   private final JFrame window;
   private Food[] food = new Food[2];
   private int numberOfPlayers = -1;
   private int skill = 0;
   private boolean increaseSpeed;
   private eventEnum currentState = eventEnum.introScreen;
   public static boolean monochrome;
   private int lastDeath;

   private static final int NUM_ROWS = 48;
   private static final int NUM_COLUMNS = 80;

   private final ActionListener taskPerformer = (ActionEvent)
         -> 
         {
            updateGame();
   };

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
      gameOver,
      playerDied,
      paused
   }

   /**
    This is the constructor that will create, display, and start the game.

    @param inWindow The window that the game will start, run, and display on.
    */
   public GameManager(JFrame inWindow)
   {
      window = inWindow;
      gameBoard = new GamePanel(NUM_COLUMNS, NUM_ROWS, this);
      timer = new Timer(updateInterval, taskPerformer);
      window.getContentPane().add(gameBoard);
      window.pack();
      window.addKeyListener((KeyListener) new KeyboardListener(this));
      window.setVisible(true);
   }

   /**
    This method will set the number of players.

    @param inNumberOfPlayers The number of players.
    */
   public void setNumberOfPlayers(int inNumberOfPlayers)
   {
      numberOfPlayers = inNumberOfPlayers;
   }

   /**
    This method will return the skill level.

    @return The skill level.
    */
   public int getSkill()
   {
      return skill;
   }

   /**
    This method will set the skill level.

    @param inSkill The skill level.
    */
   public void setSkill(int inSkill)
   {
      skill = inSkill;
   }

   /**
    This method will return the games current state.

    @return The current state of the game.
    */
   public eventEnum getCurrentState()
   {
      return currentState;
   }

   /**
   This method 
   
   @return 
   */
   public boolean getIncreaseSpeed()
   {
      return increaseSpeed;
   }

   /**
   This method 
   
   @param inIncreaseSpeed 
   */
   public void setIncreaseSpeed(boolean inIncreaseSpeed)
   {
      increaseSpeed = inIncreaseSpeed;
   }

   /**
   This method 
   
   @return 
   */
   public boolean getMonochrome()
   {
      return monochrome;
   }

   /**
   This method 
   
   @param inMonochrome 
   */
   public void setMonochrome(boolean inMonochrome)
   {
      monochrome = inMonochrome;
   }

   /**
   This method will restart the game with the initial settings.
   */
   public void restart()
   {
      currentLevel = 0;
      prepGame();
      currentState = eventEnum.startOfLevel;
   }

   /**
    This method will get the game ready to play the current level.
   */
   private void prepGame()
   {
      for (int i = 0; i < numberOfPlayers; i++)
         players[i] = new Snake(new Point2D.Double(5, 5), Snake.Direction.UP);
      loadLevel(currentLevel);
      food = spawnFood(1);
   }

   /**
    This method will spawn the food randomly. DOES NOT CHECK FOR SNAKE!

    @param foodValue The value of the food.

    @return One food instance composed of two food objects, one on top of the
            other.
    */
   private Food[] spawnFood(int foodValue)
   {
      Food food1 = new Food(foodValue, getRandomPosition(), 0);
      Food food2 = new Food(foodValue, new Point2D.Double(food1.position.x, food1.position.y - 1), 1);
      if (level.getLevelGrid()[(int) food2.position.x][(int) food2.position.y].getClass() == EmptyCell.class)
         return new Food[]
         {
            food1, food2
         };
      else
         return spawnFood(foodValue);
   }

   /**
    This method will progress the games state to the next from its current
    state.
    */
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
            try
            {
               InputStream inputStream = new FileInputStream("./resources/theme-fast.wav");
               AudioStream audioStream = new AudioStream(inputStream);
               AudioPlayer.player.start(audioStream);
            }
            catch (IOException e)
            {
               System.err.println("File not found.");
            }
            startGame();
            break;
         case playerDied:
            for (int i = 0; i < numberOfPlayers; i++)
               if (players[i].getLives() == 0)
                  currentState = eventEnum.gameOver;
            if (currentState == eventEnum.playerDied)
            {
               currentState = eventEnum.gameplayScreen;
               respawn();
               food = spawnFood(1);
               startGame();
            }
      }
   }

   /**
    This method will return the number of players.

    @return The number of players.
    */
   public int getNumberOfPlayers()
   {
      return numberOfPlayers;
   }

   /**
    This method will start both the game engine timer and the game display
    timer.
    */
   private void startGame()
   {
      timer.start();
      gameBoard.startTimer();
   }

   /**
    This method will re-spawn both players without penalizing them.
    */
   private void respawn()
   {
      for (Snake player : players)
         player.respawn();
   }

   /**
    This method will load the level using the level index.

    @param levelIndex The level index.
    */
   private void loadLevel(int levelIndex)
   {
      level = levelConstructor.getLevel(levelIndex);
      Snake.Direction[] startingDirections = level.getStartingDirections();
      Point2D.Double[] spawnPoints = level.getSpawnPoints();
      for (int i = 0; i < numberOfPlayers; i++)
         players[i].moveSpawn(spawnPoints[i], startingDirections[i]);
   }

   /**
    This method will return the current level that is being played.

    @return The current level that is being played.
    */
   public Level getLevel()
   {
      return level;
   }

   /**
    This method will be called by the timer only if the game is not paused.
    */
   private void updateGame()
   {
      for (int i = 0; i < players.length; i++)
      {
         Point2D.Double headPos = players[i].getHeadLocation();
         Collidable contents = gameBoard.getContents((int) headPos.x, (int) headPos.y);
         if (players[i].checkCollison(contents))
            if (contents.getClass() == Food.class)
            {
               players[i].eat(food[0]);
               if (players[i].getNumTimesEaten() == 8)
               {
                  nextLevel();
                  return;
               }
               food = spawnFood(food[i].getValue() + 1);
            }
            else if (contents.getClass() == Wall.class)
            {
               killPlayer(i);
               return;
            }
         players[i].iterateForward();
         for (Snake otherPlayer : players)
            if (players[i].collidedWithOtherSnake(otherPlayer))
            {
               killPlayer(i);
               return;
            }
      }
   }

   /**
    This method will put the game into the start of level state and load the
    next level.
    */
   private void nextLevel()
   {
      timer.stop();
      currentState = eventEnum.startOfLevel;
      currentLevel++;
      loadLevel(currentLevel);
      food = spawnFood(1);
   }

   /**
    This method will return a random position on the level that is an
    EmptyCell. DOES NOT CHECK FOR SNAKE!!!

    @return 
    */
   private Point2D.Double getRandomPosition()
   {
      Point2D.Double possiblePosition
            = new Point2D.Double(
                  (double) (int) (random.nextDouble() * NUM_COLUMNS),
                  (double) (int) (random.nextDouble() * NUM_ROWS)
            );
      if (level.getLevelGrid()[(int) possiblePosition.x][(int) possiblePosition.y].getClass() == EmptyCell.class)
         return possiblePosition;
      else
         return getRandomPosition();
   }

   /**
    This method will stop the game, kill the player, and set the game into the
    player died state.

    @param playerIndex The index of the player to kill.
    */
   private void killPlayer(int playerIndex)
   {
      timer.stop();
      players[playerIndex].die();
      lastDeath = playerIndex;
      currentState = eventEnum.playerDied;
   }

   /**
    This method will return the index of the player who last died.

    @return The index of the player who last died.
    */
   public int getLastDeath()
   {
      return lastDeath;
   }

   /**
    This method will return the snakes of the game.

    @return The snakes of the game.
    */
   public Snake[] getSnakes()
   {
      return players;
   }

   /**
    This method will pause the game engine.
    */
   public void pause()
   {
      currentState = eventEnum.paused;
      timer.stop();
   }

   /**
    This method will unpause the game.
    */
   public void unpause()
   {
      currentState = eventEnum.gameplayScreen;
      timer.start();
   }

   /**
    This method will return the food.

    @return The food.
    */
   public Food[] getFood()
   {
      return food;
   }
}
