
import java.util.Random;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * Course: SE-3860 Spring 2017 Project: Reengineering Project (Part 2) |
 * Nibbles Purpose: This class manages all of the game's primary
 * functions. It will handle functions like progressing the state of the
 * game, killing players, setting skill levels, increasing game speed,
 * switching levels, pausing the game and acquiring food.
 *
 * @author Nick Sosinski
 * @author Charlie Laabs
 * @author Noah Moss
 * @author Jake Ira
 * @author Ed VanDerJagt
 */
public class GameManager
{

   public static final int CHAR_WIDTH = 8;
   public static final int CHAR_HEIGHT = 2 * CHAR_WIDTH;
   public static final int TIMES_EATEN_FOR_WIN = 9;
   public static final int MAX_LEVEL_INDEX = 9;

   private static Random random;
   private int currentLevel = 0;
   public GamePanel gameBoard;
   private final LevelConstructor levelConstructor = new LevelConstructor();
   private Level level = null;
   private Timer timer;
   private int updateInterval = 55;  // ms
   private JFrame window;
   private Food[] food = new Food[2];
   private int numberOfPlayers = -1;
   private int skill = 0;
   private boolean increaseSpeed;
   private eventEnum currentState = eventEnum.introScreen;
   public static boolean monochrome;
   private int lastDeath;
   private int numTimesEaten = 0;

   private final AudioEffectPlayer audio = new AudioEffectPlayer();

   private static final Snake players[] = new Snake[2];
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
    * This is the constructor that will create, display, and start the
    * game.
    *
    * @param inWindow The window that the game will start, run, and
    * display on.
    */
   public GameManager(JFrame inWindow)
   {
      prepWindow(inWindow);
      random = new Random();
   }

   public GameManager(JFrame inWindow, int seed)
   {
      prepWindow(inWindow);
      random = new Random(seed);
   }

   private void prepWindow(JFrame inWindow)
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
    * This method will set the number of players.
    *
    * @param inNumberOfPlayers The number of players.
    */
   public void setNumberOfPlayers(int inNumberOfPlayers)
   {
      numberOfPlayers = inNumberOfPlayers;
   }

   /**
    * This method will return the skill level.
    *
    * @return The skill level.
    */
   public int getSkill()
   {
      return skill;
   }

   /**
    * This method will set the skill level.
    *
    * @param inSkill The skill level.
    */
   public void setSkill(int inSkill)
   {
      skill = inSkill;
   }

   /**
    * This method will return the games current state.
    *
    * @return The current state of the game.
    */
   public eventEnum getCurrentState()
   {
      return currentState;
   }

   /**
    * This method will return the amount of speed to increase the speed
    * of the game by.
    *
    * @return The amount of speed to increase the speed of the game by.
    */
   public boolean getIncreaseSpeed()
   {
      return increaseSpeed;
   }

   /**
    * This method takes in a speed to increase the game by and sets the
    * increase speed value to be equal to that passed in value.
    *
    * @param inIncreaseSpeed The amount of speed to increase the speed
    * of the game by.
    */
   public void setIncreaseSpeed(boolean inIncreaseSpeed)
   {
      increaseSpeed = inIncreaseSpeed;
   }

   /**
    * This method returns whether the game is in a monochrome color or
    * not.
    *
    * @return Whether the game is in a monochrome color or not.
    */
   public boolean getMonochrome()
   {
      return monochrome;
   }

   /**
    * This method will set the color of the game to monochrome.
    *
    * @param isInMonochrome Sets the color of the game to be monochrome
    * if true, color if false.
    */
   public void setMonochrome(boolean isInMonochrome)
   {
      monochrome = isInMonochrome;
   }

   /**
    * This method will restart the game with the initial settings.
    */
   public void restart()
   {
      currentLevel = 0;
      prepGame();
      currentState = eventEnum.startOfLevel;
   }

   /**
    * This method will get the game ready to play the current level.
    */
   private void prepGame()
   {
      for (int i = 0; i < numberOfPlayers; i++)
      {
         players[i] = new Snake(new Point2D.Double(5, 5), Snake.Direction.UP, i + 1);
      }
      loadLevel(currentLevel);
      food = spawnFood(1);
      numTimesEaten = 0;
   }

   /**
    * This method will spawn the food randomly.
    *
    * @param foodValue The value of the food.
    *
    * @return One food instance composed of two food objects, one on top
    * of the other.
    */
   private Food[] spawnFood(int foodValue)
   {
      Food food1 = new Food(foodValue, getRandomPosition(), 0);
      Food food2 = new Food(foodValue, new Point2D.Double(food1.position.x, food1.position.y - 1), 1);
      if (canFoodSpawn(food1) && canFoodSpawn(food2))
      {
         return new Food[]
         {
            food1, food2
         };
      }
      else
      {
         return spawnFood(foodValue);
      }
   }

   /**
    * This method checks for obstacles in the way of a food spawn.
    *
    * @param food A food being checked for placement.
    *
    * @return Whether or not the space is clear and the food can spawn
    * there.
    */
   private boolean canFoodSpawn(Food food)
   {
      if (level.getLevelGrid()[(int) food.position.x][(int) food.position.y].getClass() != EmptyCell.class)
      {
         return false;
      }
      for (int i = 0; i < numberOfPlayers; i++)
      {
         if (players[i].collidedWithCollidable(food))
         {
            return false;
         }
      }
      return true;
   }

   /**
    * This method will progress the games state to the next from its
    * current state.
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
            //players = new Snake[numberOfPlayers];
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
            audio.playSound("theme-fast.wav");
            gameBoard.speedUpTimer();
            timer.start();
            break;
         case playerDied:
            for (int i = 0; i < numberOfPlayers; i++)
            {
               if (players[i].getLives() == 0)
               {
                  currentState = eventEnum.gameOver;
               }
            }
            if (currentState == eventEnum.playerDied)
            {
               currentState = eventEnum.gameplayScreen;
               audio.playSound("theme-fast.wav");
               respawn();
               food = spawnFood(1);
            }
      }
   }

   /**
    * This method will return the number of players.
    *
    * @return The number of players.
    */
   public int getNumberOfPlayers()
   {
      return numberOfPlayers;
   }

   /**
    * This method will re-spawn both players without penalizing them.
    */
   private void respawn()
   {
      for (int i = 0; i < numberOfPlayers;i++)
      {
         players[i].respawn();
      }
   }

   /**
    * This method will load the level using the level index.
    *
    * @param levelIndex The level index.
    */
   private void loadLevel(int levelIndex)
   {
      level = levelConstructor.getLevel(levelIndex);
      Snake.Direction[] startingDirections = level.getStartingDirections();
      Point2D.Double[] spawnPoints = level.getSpawnPoints();
      for (int i = 0; i < numberOfPlayers; i++)
      {
         players[i].moveSpawn(spawnPoints[i], startingDirections[i]);
         respawn();
      }
   }

   /**
    * This method will return the current level that is being played.
    *
    * @return The current level that is being played.
    */
   public Level getLevel()
   {
      return level;
   }

   /**
    * This method checks player collisions in regards as to whether the
    * player has collided with food, collided with a wall, or collided
    * with another player. It will be called by the timer only if the
    * game is not paused.
    */
   private void updateGame()
   {
      if (currentState == eventEnum.gameplayScreen)
      {
         for (int i = 0; i < numberOfPlayers; i++)
         {
            Point2D.Double headPos = players[i].getHeadLocation();
            Collidable contents = gameBoard.getContents((int) headPos.x, (int) headPos.y);
            if (players[i].checkCollison(contents))
            {
               if (contents.getClass() == Food.class)
               {
                  players[i].eat(food[0]);
                  numTimesEaten++;
                  if (numTimesEaten == TIMES_EATEN_FOR_WIN)
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
            }
            players[i].iterateForward();
            for (int j=0;j<numberOfPlayers;j++)
               if (players[i].collidedWithOtherSnake(players[j]))
               {
                  killPlayer(i);
                  return;
                }
        }
      }
   }

   /**
    * This method will put the game into the start of level state and
    * load the next level.
    */
   private void nextLevel()
   {
      currentState = eventEnum.startOfLevel;
      if (currentLevel < MAX_LEVEL_INDEX)
         currentLevel++;
      loadLevel(currentLevel);
      food = spawnFood(1);
      numTimesEaten = 0;
   }

   /**
    * This method will return a random position on the level that is an
    * EmptyCell.
    *
    * @return
    */
   private Point2D.Double getRandomPosition()
   {
      Point2D.Double possiblePosition
         = new Point2D.Double(
            (double) (int) (random.nextDouble() * NUM_COLUMNS),
            (double) (int) (random.nextDouble() * NUM_ROWS)
         );
      if (level.getLevelGrid()[(int) possiblePosition.x][(int) possiblePosition.y].getClass() == EmptyCell.class)
      {
         return possiblePosition;
      }
      else
      {
         return getRandomPosition();
      }
   }

   /**
    * This method will stop the game, kill the player, and set the game
    * into the player died state.
    *
    * @param playerIndex The index of the player to kill.
    */
   private void killPlayer(int playerIndex)
   {
      players[playerIndex].die();
      numTimesEaten = 0;

      lastDeath = playerIndex;
      currentState = eventEnum.playerDied;
   }

   /**
    * This method will return the index of the player who last died.
    *
    * @return The index of the player who last died.
    */
   public int getLastDeath()
   {
      return lastDeath;
   }

   /**
    * This method will return the snakes of the game.
    *
    * @return The snakes of the game.
    */
   public Snake[] getSnakes()
   {
      return players;
   }

   /**
    * This method will pause the game engine.
    */
   public void pause()
   {
      currentState = eventEnum.paused;
   }

   /**
    * This method will un-pause the game.
    */
   public void unpause()
   {
      currentState = eventEnum.gameplayScreen;
   }

   /**
    * This method will return the food.
    *
    * @return The food.
    */
   public Food[] getFood()
   {
      return food;
   }
}
