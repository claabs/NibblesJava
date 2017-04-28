
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

   @Override
   public void keyPressed(KeyEvent e)
   {
      //PLAYER 1
      switch (e.getKeyCode())
      {
         case KeyEvent.VK_KP_RIGHT:
         case KeyEvent.VK_RIGHT:
            if (GameManager.directionSnake[0] != GameManager.SnakeDirection.LEFT)
               GameManager.directionSnake[0] = GameManager.SnakeDirection.RIGHT;
            break;
         case KeyEvent.VK_KP_UP:
            case KeyEvent.VK_UP:
            if (GameManager.directionSnake[0] != GameManager.SnakeDirection.DOWN)
               GameManager.directionSnake[0] = GameManager.SnakeDirection.UP;
            break;
         case KeyEvent.VK_KP_LEFT:
            case KeyEvent.VK_LEFT:
            if (GameManager.directionSnake[0] != GameManager.SnakeDirection.RIGHT)
               GameManager.directionSnake[0] = GameManager.SnakeDirection.LEFT;
            break;
         case KeyEvent.VK_KP_DOWN:
            case KeyEvent.VK_DOWN:
            if (GameManager.directionSnake[0] != GameManager.SnakeDirection.UP)
               GameManager.directionSnake[0] = GameManager.SnakeDirection.DOWN;
            break;
         case KeyEvent.VK_D:
            if (GameManager.directionSnake[1] != GameManager.SnakeDirection.LEFT)
               GameManager.directionSnake[1] = GameManager.SnakeDirection.RIGHT;
            break;
         case KeyEvent.VK_W:
            if (GameManager.directionSnake[1] != GameManager.SnakeDirection.DOWN)
               GameManager.directionSnake[1] = GameManager.SnakeDirection.UP;
            break;
         case KeyEvent.VK_A:
            if (GameManager.directionSnake[1] != GameManager.SnakeDirection.RIGHT)
               GameManager.directionSnake[1] = GameManager.SnakeDirection.LEFT;
            break;
         case KeyEvent.VK_S:
            if (GameManager.directionSnake[1] != GameManager.SnakeDirection.UP)
               GameManager.directionSnake[1] = GameManager.SnakeDirection.DOWN;
            break;
         case KeyEvent.VK_P:
            GameManager.pause();
            break;
            
         case KeyEvent.VK_SPACE:
            GameManager.unpause();
         default:
            break;
      }
   }
}
