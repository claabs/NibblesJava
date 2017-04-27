
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

   private GameSpace.SpaceType[][] levelGrid;
   private SnakeHead.Orientation[] snakeOrientations = new SnakeHead.Orientation[2];
   private Point2D[] snakeSpawns = new Point2D[2];

   public void setLevelGrid( GameSpace.SpaceType[][] levelGrid )
   {
      this.levelGrid = levelGrid;
   }
   
   public GameSpace.SpaceType[][] getLevelGrid()
   {
      return levelGrid;
   }
   
   public void setSnakeOrientations( SnakeHead.Orientation[] snakeOrientations )
   {
      this.snakeOrientations = snakeOrientations;
   }
   
   public SnakeHead.Orientation[] getSnakeOrientations()
   {
      return snakeOrientations;
   }
   
   public void setSnakeSpawns( Point2D[] snakeSpawns )
   {
      this.snakeSpawns = snakeSpawns;
   }
   
   public Point2D[] getSnakeSpawns()
   {
      return snakeSpawns;
   }
}
