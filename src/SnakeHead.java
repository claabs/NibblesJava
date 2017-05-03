
import java.awt.Color;
import java.awt.geom.Point2D;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles the head of the snake; namely, anything that
          isn't the body of the snake.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class SnakeHead extends SnakeSegment
{

   /**
   This constructor creates a new snake head at a specific spawn point
   facing a specific direction.
   
   @param spawnPoint Specific spawn point.
   @param dir Specific spawn direction.
   */
   SnakeHead(Point2D.Double spawnPoint, Snake.Direction dir, Snake parent)
   {
      super(spawnPoint, dir, parent);
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
   This method generates a random hash code for this object and returns it.
   
   @return Random hash code for the object.
   */
   @Override
   public int hashCode()
   {
      int hash = 5;
      return hash;
   }

}
