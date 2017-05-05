
import java.awt.event.*;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles the listening of all of the user keyboard
          presses. 

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class KeyboardListener extends KeyAdapter
{

   private final GameManager manager;

   
   /**
   This constructor builds a new Keyboard Listener by taking in a game 
   manager and setting it equal to the classes game manager.
   
   @param inManager Current Nibbles game manager.
   */
   public KeyboardListener(GameManager inManager)
   {
      manager = inManager;
   }

   /**
   This method will handle all of the keyboard presses made by the user.
   
   @param e Key pressed by the user.
   */
   @Override
   public void keyPressed(KeyEvent e)
   {
      GameManager.eventEnum managerState = manager.getCurrentState();
      switch (managerState)
      {
         case introScreen:
            manager.progressState();
            break;
         case numberOfPlayersScreen:
            if (manager.getNumberOfPlayers() != -1 && e.getKeyCode() == KeyEvent.VK_ENTER)
               manager.progressState();
            else if (e.getKeyChar() == '1')
               manager.setNumberOfPlayers(1);
            else if (e.getKeyChar() == '2')
               manager.setNumberOfPlayers(2);
            break;
         case skillLevelScreen:
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
            break;
         case increaseSpeedScreen:
            if (Character.toLowerCase(e.getKeyChar()) == 'y')
               manager.setIncreaseSpeed(true);
            else if (Character.toLowerCase(e.getKeyChar()) == 'n')
               manager.setIncreaseSpeed(false);
            else if (e.getKeyCode() == KeyEvent.VK_ENTER)
               manager.progressState();
            break;
         case monochromeOrColorScreen:
            if (Character.toLowerCase(e.getKeyChar()) == 'm')
               manager.setMonochrome(true);
            else if (Character.toLowerCase(e.getKeyChar()) == 'c')
               manager.setMonochrome(false);
            else if (e.getKeyCode() == KeyEvent.VK_ENTER)
               manager.progressState();
            break;
         case startOfLevel:
         case playerDied:
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
               manager.progressState();
            break;
         case gameOver:
            if (Character.toLowerCase(e.getKeyChar()) == 'y')
               manager.restart();
            else if (Character.toLowerCase(e.getKeyChar()) == 'n')
               System.exit(0);
            break;
         case paused:
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
               manager.unpause();
            break;
         case gameplayScreen:
            Snake[] snakes = manager.getSnakes();
            switch (e.getKeyCode())
            {
               case KeyEvent.VK_RIGHT:
                     snakes[0].setDirection(Snake.Direction.RIGHT);
                  break;
               case KeyEvent.VK_UP:
                     snakes[0].setDirection(Snake.Direction.UP);
                  break;
               case KeyEvent.VK_LEFT:
                     snakes[0].setDirection(Snake.Direction.LEFT);
                  break;
               case KeyEvent.VK_DOWN:
                     snakes[0].setDirection(Snake.Direction.DOWN);
                  break;
               case KeyEvent.VK_P:
                  manager.pause();
            }
            if (manager.getNumberOfPlayers() == 2)
            {
               switch (e.getKeyCode())
               {
                  case KeyEvent.VK_D:
                        snakes[1].setDirection(Snake.Direction.RIGHT);
                     break;
                  case KeyEvent.VK_W:
                        snakes[1].setDirection(Snake.Direction.UP);
                     break;
                  case KeyEvent.VK_A:
                        snakes[1].setDirection(Snake.Direction.LEFT);
                     break;
                  case KeyEvent.VK_S:
                        snakes[1].setDirection(Snake.Direction.DOWN);
               }
            }
      }
   }
}
