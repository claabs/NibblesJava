
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter
{

   public void keyPressed(KeyEvent e)
   {
      switch (e.getKeyCode())
      {
         case 39:	// -> Right 
            //if it's not the opposite direction
            if (GameManager.directionSnake != 2)
            {
               GameManager.directionSnake = 1;
            }
            break;
         case 38:	// -> Top
            if (GameManager.directionSnake != 4)
            {
               GameManager.directionSnake = 3;
            }
            break;

         case 37: 	// -> Left 
            if (GameManager.directionSnake != 1)
            {
               GameManager.directionSnake = 2;
            }
            break;

         case 40:	// -> Bottom
            if (GameManager.directionSnake != 3)
            {
               GameManager.directionSnake = 4;
            }
            break;

         default:
            break;
      }
   }
}
