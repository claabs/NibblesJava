
import java.awt.geom.Point2D;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class Level
{
   // Nick and Noah Area

   private final GamePanel.CellContents[][] levelGrid;
   private final Snake.Direction[] snakeDirections;
   private final Point2D.Double[] snakeSpawns;

   public Level(GamePanel.CellContents[][] levelGrid,
         Snake.Direction[] snakeOrientations,
         Point2D.Double[] snakeSpawns)
   {
      this.levelGrid = levelGrid;
      this.snakeDirections = snakeOrientations;
      this.snakeSpawns = snakeSpawns;
   }

   public GamePanel.CellContents[][] getLevelGrid()
   {
      return levelGrid;
   }

   public Snake.Direction[] getStartingDirections()
   {
      return snakeDirections;
   }

   public Point2D.Double[] getSpawnPoints()
   {
      return snakeSpawns;
   }

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

}
