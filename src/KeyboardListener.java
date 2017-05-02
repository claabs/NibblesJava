
import java.awt.event.*;

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
public class KeyboardListener extends KeyAdapter
{

   private final GameManager manager;

   
   /**
   This constructor 
   
   @param inManager 
   */
   KeyboardListener(GameManager inManager)
   {
      manager = inManager;
   }

   /**
   This method 
   
   @param e 
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
            Snake.Direction directionLastMoved = snakes[0].getDirectionLastMoved();
            switch (e.getKeyCode())
            {
               case KeyEvent.VK_RIGHT:
                  if (directionLastMoved != Snake.Direction.LEFT)
                     snakes[0].setDirection(Snake.Direction.RIGHT);
                  break;
               case KeyEvent.VK_UP:
                  if (directionLastMoved != Snake.Direction.DOWN)
                     snakes[0].setDirection(Snake.Direction.UP);
                  break;
               case KeyEvent.VK_LEFT:
                  if (directionLastMoved != Snake.Direction.RIGHT)
                     snakes[0].setDirection(Snake.Direction.LEFT);
                  break;
               case KeyEvent.VK_DOWN:
                  if (directionLastMoved != Snake.Direction.UP)
                     snakes[0].setDirection(Snake.Direction.DOWN);
                  break;
               case KeyEvent.VK_P:
                  manager.pause();
            }
            if (manager.getNumberOfPlayers() == 2)
            {
               directionLastMoved = snakes[1].getDirectionLastMoved();
               switch (e.getKeyCode())
               {
                  case KeyEvent.VK_D:
                     if (directionLastMoved != Snake.Direction.LEFT)
                        snakes[1].setDirection(Snake.Direction.RIGHT);
                     break;
                  case KeyEvent.VK_W:
                     if (directionLastMoved != Snake.Direction.DOWN)
                        snakes[1].setDirection(Snake.Direction.UP);
                     break;
                  case KeyEvent.VK_A:
                     if (directionLastMoved != Snake.Direction.RIGHT)
                        snakes[1].setDirection(Snake.Direction.LEFT);
                     break;
                  case KeyEvent.VK_S:
                     if (directionLastMoved != Snake.Direction.UP)
                        snakes[1].setDirection(Snake.Direction.DOWN);
               }
            }
      }
   }
}
