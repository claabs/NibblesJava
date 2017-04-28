
import java.util.LinkedList;
import java.util.ListIterator;

/**

   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class Snake 
{
   
   // Nick and Noah Area
   private static final int MAX_SNAKE_LENGTH = 1000;
   private static final int GROW_FACTOR = 4;
   private boolean alive;
   private LinkedList<SnakeSegment> body;
   private int lives;
   private int score;
   
   public Snake()
   {
      body.add(new SnakeHead());
      body.add(new SnakeSegment());
   }
         
   
   private void growSnake(int growValue)
   {
      if ( body.size() > MAX_SNAKE_LENGTH - 30 )
      {
         for ( int i = 0; i < growValue * GROW_FACTOR; i++ )
         {
            body.add(new SnakeSegment());
         }
      }
   }
   
   private void iterateForward()
   {
      
   }
   
   private boolean snakeCollision()
   {
      return body.get(0).isColliding();
         
   }
   
   private boolean wallCollision()
   {
      return false;
   }
   
   // End Nick and Noah Area

}
