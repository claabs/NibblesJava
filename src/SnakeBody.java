
import java.awt.geom.Point2D;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class SnakeBody extends SnakeSegment
{

   public SnakeBody(SnakeSegment oldEndOfSnake)
   {
      super(oldEndOfSnake.getPosition(), oldEndOfSnake.getDirection());

   }

   public SnakeBody(Point2D.Double spawnLocation, Snake.Direction spawnDirection)
   {
      super(spawnLocation, spawnDirection);
   }

}
