
import java.awt.geom.Point2D;
import java.util.Arrays;

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
public class Level
{

   private final Collidable[][] levelGrid;
   private final Snake.Direction[] snakeDirections;
   private final Point2D.Double[] snakeSpawns;
   private final int levelNumber;

   /**
   This constructor 
   
   @param levelGrid
   @param snakeOrientations
   @param snakeSpawns
   @param levelNumber 
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

   /**
   This method 
   
   @return 
   */
   public Collidable[][] getLevelGrid()
   {
      return levelGrid;
   }

   /**
   This method 
   
   @return 
   */
   public Snake.Direction[] getStartingDirections()
   {
      return snakeDirections;
   }

   /**
   This method 
   
   @return 
   */
   public Point2D.Double[] getSpawnPoints()
   {
      return snakeSpawns;
   }
   
   /**
   This method 
   
   @return 
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
            if (level.levelGrid[i][j] != levelGrid[i][j])
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
   This method 
   
   @return 
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
