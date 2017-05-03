
import java.awt.geom.Point2D;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles the body of the snake; namely, anything that 
          isn't the head of the snake.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class SnakeBody extends SnakeSegment
{

   /**
   This constructor creates a new snake body pointed in the direction of the
   past segment with the location of the past segment.
   
   @param oldEndOfSnake Old end of the snake.
   */
   public SnakeBody(SnakeSegment oldEndOfSnake, Snake parent)
   {
      super(oldEndOfSnake.getPosition(), oldEndOfSnake.getDirection(), parent);
   }

   /**
   This constructor creates a new snake body at a specific spawn location
   facing a specific direction.
   
   @param spawnLocation Specific spawn location.
   @param spawnDirection Specific spawn direction.
   */
   public SnakeBody(Point2D.Double spawnLocation, Snake.Direction spawnDirection, Snake parent)
   {
      super(spawnLocation, spawnDirection, parent);
   }

}
