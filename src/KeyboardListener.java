import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**

   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class KeyboardListener extends KeyAdapter
{

   public void keyPressed(KeyEvent e)
   {
      //PLAYER 1
      switch (e.getKeyCode())
      {
         case KeyEvent.VK_KP_RIGHT:	// -> Right 
            //if it's not the opposite direction
            if (GameManager.directionSnake1 != 2)
            {
               GameManager.directionSnake1 = 1;
            }
            break;
         case KeyEvent.VK_KP_UP:	// -> Top
            if (GameManager.directionSnake1 != 4)
            {
               GameManager.directionSnake1 = 3;
            }
            break;

         case KeyEvent.VK_KP_LEFT: 	// -> Left 
            if (GameManager.directionSnake1 != 1)
            {
               GameManager.directionSnake1 = 2;
            }
            break;

         case KeyEvent.VK_KP_DOWN:	// -> Bottom
            if (GameManager.directionSnake1 != 3)
            {
               GameManager.directionSnake1 = 4;
            }
            break;

         default:
            break;
      }
       //PLAYER 2
      switch (e.getKeyCode())
      {
         case KeyEvent.VK_D:	// -> Right 
            //if it's not the opposite direction
            if (GameManager.directionSnake2 != 2)
            {
               GameManager.directionSnake2 = 1;
            }
            break;
         case KeyEvent.VK_W:	// -> Top
            if (GameManager.directionSnake2 != 4)
            {
               GameManager.directionSnake2 = 3;
            }
            break;

         case KeyEvent.VK_A: 	// -> Left 
            if (GameManager.directionSnake2 != 1)
            {
               GameManager.directionSnake2 = 2;
            }
            break;

         case KeyEvent.VK_S:	// -> Bottom
            if (GameManager.directionSnake2 != 3)
            {
               GameManager.directionSnake2 = 4;
            }
            break;

         default:
            break;
      }
   }
}
