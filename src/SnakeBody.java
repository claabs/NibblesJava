
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
public class SnakeBody extends SnakeSegment
{

   /**
   This constructor 
   
   @param oldEndOfSnake 
   */
   public SnakeBody(SnakeSegment oldEndOfSnake)
   {
      super(oldEndOfSnake.getPosition(), oldEndOfSnake.getDirection());

   }

   /**
   This constructor 
   
   @param spawnLocation
   @param spawnDirection 
   */
   public SnakeBody(Point2D.Double spawnLocation, Snake.Direction spawnDirection)
   {
      super(spawnLocation, spawnDirection);
   }

}
