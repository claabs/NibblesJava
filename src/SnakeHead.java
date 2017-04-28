
import java.awt.geom.Point2D;



/**

   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class SnakeHead extends SnakeSegment
{
   
   SnakeHead(Point2D.Double spawnPoint, Snake.Direction dir)
   {
      super(spawnPoint, dir);
   }
   
   // Nick and Noah Area
   
   @Override
   public boolean isColliding()
   {
      return false;
   }
   // End Nick and Noah Area

}
