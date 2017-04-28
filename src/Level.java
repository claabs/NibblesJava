
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

   private GameSpace.SpaceType[][] levelGrid = new GameSpace.SpaceType[80][48];
   private Snake.Direction[] snakeDirections = new Snake.Direction[2];
   private Point2D.Double[] snakeSpawns = new Point2D.Double[2];

   public Level()
   {
      for (int i = 0; i < levelGrid.length; i++)
         for (int j = 0; j < levelGrid[i].length; j++)
            levelGrid[i][j] = GameSpace.SpaceType.OPEN;
      for (int i = 0; i < snakeDirections.length; i++)
         snakeDirections[i] = Snake.Direction.RIGHT;
      for (int i = 0; i < snakeSpawns.length; i++)
         snakeSpawns[i] = new Point2D.Double(0, 0);
   }

   public Level(GameSpace.SpaceType[][] levelGrid,
         Snake.Direction[] snakeOrientations,
         Point2D.Double[] snakeSpawns)
   {
      this.levelGrid = levelGrid;
      this.snakeDirections = snakeOrientations;
      this.snakeSpawns = snakeSpawns;
   }

   public void setLevelGrid(GameSpace.SpaceType[][] levelGrid)
   {
      this.levelGrid = levelGrid;
   }

   public GameSpace.SpaceType[][] getLevelGrid()
   {
      return levelGrid;
   }

   public void setSnakeOrientations(Snake.Direction[] snakeOrientations)
   {
      this.snakeDirections = snakeOrientations;
   }

   public Snake.Direction[] getSnakeOrientations()
   {
      return snakeDirections;
   }

   public void setSnakeSpawns(Point2D.Double[] snakeSpawns)
   {
      this.snakeSpawns = snakeSpawns;
   }

   public Point2D[] getSnakeSpawns()
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
