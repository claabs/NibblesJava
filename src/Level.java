
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
   private SnakeHead.Orientation[] snakeOrientations = new SnakeHead.Orientation[2];
   private Point2D.Double[] snakeSpawns = new Point2D.Double[2];

   public Level()
   {
      for (int i = 0; i < levelGrid.length; i++)
         for (int j = 0; j < levelGrid[i].length; j++)
            levelGrid[i][j] = GameSpace.SpaceType.OPEN;
      for (int i = 0; i < snakeOrientations.length; i++)
         snakeOrientations[i] = SnakeHead.Orientation.RIGHT;
      for (int i = 0; i < snakeSpawns.length; i++)
         snakeSpawns[i] = new Point2D.Double(0, 0);
   }

   public Level(GameSpace.SpaceType[][] levelGrid,
         SnakeHead.Orientation[] snakeOrientations,
         Point2D.Double[] snakeSpawns)
   {
      this.levelGrid = levelGrid;
      this.snakeOrientations = snakeOrientations;
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

   public void setSnakeOrientations(SnakeHead.Orientation[] snakeOrientations)
   {
      this.snakeOrientations = snakeOrientations;
   }

   public SnakeHead.Orientation[] getSnakeOrientations()
   {
      return snakeOrientations;
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
      for (int i = 0; i < snakeOrientations.length; i++)
         if (level.snakeOrientations[i] != snakeOrientations[i])
            return false;
      for (int i = 0; i < snakeSpawns.length; i++)
         if (!level.snakeSpawns[i].equals(snakeSpawns[i]))
            return false;
      return true;
   }

}
