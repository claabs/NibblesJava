
import java.awt.Color;
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
   
   @Override
   public boolean equals(Object o)
   {
      if (o == null)
         return false;
      if (o.getClass() != SnakeHead.class)
         return false;
      SnakeHead head = (SnakeHead) o;
      return position.equals(head.position)
            && getDirection()==head.getDirection();
   }
   
}
