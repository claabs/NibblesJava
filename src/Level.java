
import java.awt.geom.Point2D;
import java.util.Arrays;

/**
 Course: SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles returning the snake spawn points, the
 starting
 snake directions, the level grid and the current level number.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class Level
{

   private Collidable[][] levelGrid;
   private final Snake.Direction[] snakeDirections;
   private final Point2D.Double[] snakeSpawns;
   private final int levelNumber;

   /**
    This constructor will build a new level for Nibbles.

    @param levelGrid The arrangement of empty spaces and walls for the
    level.
    @param snakeOrientations The orientations of which the snakes face
    when they
    spawn.
    @param snakeSpawns The location where the snakes will spawn.
    @param levelNumber The number of the level (level numbers start at 1).
    */
   public Level(Collidable[][] levelGrid,
         Snake.Direction[] snakeOrientations,
         Point2D.Double[] snakeSpawns,
         int levelNumber)
   {
      this.levelGrid = levelGrid;
      this.snakeDirections = snakeOrientations;
      this.snakeSpawns = snakeSpawns;
      this.levelNumber = levelNumber;
   }

   public Level()
   {
      levelGrid = new Collidable[LevelConstructor.WIDTH][LevelConstructor.HEIGHT];
      for (int i = 0; i < levelGrid.length; i++)
         for (int j = 0; j < levelGrid[0].length; j++)
            levelGrid[i][j] = new EmptyCell(new Point2D.Double(i, j));
      snakeDirections = new Snake.Direction[]
      {
         Snake.Direction.UP, Snake.Direction.UP
      };
      snakeSpawns = new Point2D.Double[]
      {
         new Point2D.Double(20, 20), new Point2D.Double(40, 40)
      };
      levelNumber = 99;
   }

   /**
    This method will return the level grid.

    @return The level grid.
    */
   public Collidable[][] getLevelGrid()
   {
      return levelGrid;
   }

   /**
    This method will return the starting directions of the snake.

    @return The starting directions of the snake.
    */
   public Snake.Direction[] getStartingDirections()
   {
      return snakeDirections;
   }

   /**
    This method will return the spawn points of the snake.

    @return The spawn points of the snake.
    */
   public Point2D.Double[] getSpawnPoints()
   {
      return snakeSpawns;
   }

   /**
    This method will return the number of the level.

    @return The number of the level.
    */
   public int getLevelNumber()
   {
      return levelNumber;
   }

   /**
    This method returns true if two objects are the same data-wise.

    @param o The other object.

    @return True if the two objects are the same data-wise.
    */
   @Override
   public boolean equals(Object o)
   {
      if (o == null)
         return false;
      if (o.getClass() != Level.class)
         return false;
      Level level = (Level) o;
      for (int i = 0; i < levelGrid.length; i++)
         for (int j = 0; j < levelGrid[i].length; j++)
            if (level.levelGrid[i][j].getClass() != levelGrid[i][j].getClass())
               return false;
      for (int i = 0; i < snakeDirections.length; i++)
         if (level.snakeDirections[i] != snakeDirections[i])
            return false;
      for (int i = 0; i < snakeSpawns.length; i++)
         if (!level.snakeSpawns[i].equals(snakeSpawns[i]))
            return false;
      return true;
   }

   /**
    This method generates a random hash code for this object and returns
    it.

    @return Random hash code for the object.
    */
   @Override
   public int hashCode()
   {
      int hash = 7;
      hash = 67 * hash + Arrays.deepHashCode(this.levelGrid);
      hash = 67 * hash + Arrays.deepHashCode(this.snakeDirections);
      hash = 67 * hash + Arrays.deepHashCode(this.snakeSpawns);
      hash = 67 * hash + this.levelNumber;
      return hash;
   }

}
