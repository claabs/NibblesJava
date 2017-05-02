
import java.awt.geom.Point2D;

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
public class SnakeHead extends SnakeSegment
{

   /**
   This constructor 
   
   @param spawnPoint
   @param dir 
   */
   SnakeHead(Point2D.Double spawnPoint, Snake.Direction dir)
   {
      super(spawnPoint, dir);
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
      if (o.getClass() != SnakeHead.class)
         return false;
      SnakeHead head = (SnakeHead) o;
      return position.equals(head.position)
            && getDirection() == head.getDirection();
   }

   /**
   This constructor 
   
   @return 
   */
   @Override
   public int hashCode()
   {
      int hash = 5;
      return hash;
   }

}
