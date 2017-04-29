
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

      GameManager.eventEnum managerState = manager.getCurrentState();
      if (managerState == GameManager.eventEnum.introScreen)
         manager.progressState();
      else if (managerState == GameManager.eventEnum.numberOfPlayersScreen)
      {
         if (manager.getNumberOfPlayers() != -1 && e.getKeyCode() == KeyEvent.VK_ENTER)
            manager.progressState();
         else if (e.getKeyChar() == '1')
            manager.setNumberOfPlayers(1);
         else if (e.getKeyChar() == '2')
            manager.setNumberOfPlayers(2);
      }
      else if (managerState == GameManager.eventEnum.skillLevelScreen)
      {
         char keyChar = e.getKeyChar();
         if (keyChar <= '9' && keyChar >= '0')
         {
            if (manager.getSkill() < 100)
            {
               int possibleSkill = Integer.parseInt(Integer.toString(manager.getSkill()) + keyChar);
               if (possibleSkill <= 100)
                  manager.setSkill(possibleSkill);
            }
         }
         else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
         {
            String skillString = Integer.toString(manager.getSkill());
            if (skillString.length() > 0)
            {
               skillString = skillString.substring(0, skillString.length() - 1);
               if (skillString.equals(""))
                  manager.setSkill(0);
               else
                  manager.setSkill(Integer.parseInt(skillString));
            }
         }
         else if (e.getKeyCode() == KeyEvent.VK_ENTER)
            if (manager.getSkill() != 0)
               manager.progressState();
      }
      else if (managerState == GameManager.eventEnum.increaseSpeedScreen)
      {
         if (Character.toLowerCase(e.getKeyChar()) =='y')
            manager.setIncreaseSpeed(true);
         else if (Character.toLowerCase(e.getKeyChar())=='n')
            manager.setIncreaseSpeed(false);
         else if (e.getKeyCode()==KeyEvent.VK_ENTER)
            manager.progressState();
      }
      else if (managerState == GameManager.eventEnum.monochromeOrColorScreen)
      {
         if (Character.toLowerCase(e.getKeyChar()) =='m')
            manager.setMonochrome(true);
         else if (Character.toLowerCase(e.getKeyChar())=='c')
            manager.setMonochrome(false);
         else if (e.getKeyCode()==KeyEvent.VK_ENTER)
            manager.progressState();
      }
      else if (managerState == GameManager.eventEnum.gameplayScreen)
         switch (e.getKeyCode())
         {
            //PLAYER 1
            case KeyEvent.VK_RIGHT:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.LEFT)
                  manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.RIGHT);
               break;
            case KeyEvent.VK_UP:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.DOWN)
                  manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.UP);
               break;
            case KeyEvent.VK_LEFT:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.RIGHT)
                  manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.LEFT);
               break;
            case KeyEvent.VK_DOWN:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) != Snake.Direction.UP)
                  manager.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.DOWN);
               break;
            //Player 2
            case KeyEvent.VK_D:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.LEFT)
                  manager.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.RIGHT);
               break;
            case KeyEvent.VK_W:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.DOWN)
                  manager.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.UP);
               break;
            case KeyEvent.VK_A:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.RIGHT)
                  manager.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.LEFT);
               break;
            case KeyEvent.VK_S:
               if (manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) != Snake.Direction.UP)
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
