
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

   private GameManager manager;

   KeyboardListener(GameManager inManager)
   {
      manager = inManager;
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      //PLAYER 1
      switch (e.getKeyCode())
      {
         case KeyEvent.VK_RIGHT:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.LEFT)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.RIGHT);
            break;
         case KeyEvent.VK_UP:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.DOWN)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.UP);
            break;
         case KeyEvent.VK_LEFT:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.RIGHT)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.LEFT);
            break;
         case KeyEvent.VK_DOWN:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.UP)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.DOWN);
            break;
         case KeyEvent.VK_D:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.LEFT)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.RIGHT);
            break;
         case KeyEvent.VK_W:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.DOWN)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.UP);
            break;
         case KeyEvent.VK_A:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.RIGHT)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.LEFT);
            break;
         case KeyEvent.VK_S:
            if (manager.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.UP)
               manager.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.DOWN);
            break;
         case KeyEvent.VK_P:
            manager.pause();
            break;

         case KeyEvent.VK_SPACE:
            manager.unpause();
         default:
            break;
      }
   }
}
