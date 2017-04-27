
import java.awt.*;
import javax.swing.*;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class GamePanel extends JComponent
{

   private CellContents gameBoard[][];
   private final int sideLength;
   private boolean displayPause = false;

   enum CellContents
   {
      EMPTY, WALL, FOOD, SNAKE, SNAKEHEAD
   };

   public GamePanel(int boardWidth, int boardHeight, int squareLength)
   {
      sideLength = squareLength;
      gameBoard = new CellContents[boardWidth][boardHeight];
      for (int column = 0; column < gameBoard.length - 1; column++)
         for (int row = 0; row < gameBoard[column].length - 1; row++)
            gameBoard[column][row] = CellContents.EMPTY;
   }

   public CellContents getContents(int column, int row)
   {
      try
      {
         return gameBoard[column][row];
      }
      catch (IndexOutOfBoundsException e)
      {
         System.err.println("Out of bounds exception:\n" + e.toString());
         return CellContents.EMPTY;
      }
   }

   public void showPause(boolean pause)
   {
      displayPause = pause;
   }

   @Override
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.gray);
      g2.drawRect(0, 0, WIDTH, HEIGHT);
      for (int column = 0; column < gameBoard.length - 1; column++)
         for (int row = 0; row < gameBoard[column].length - 1; row++)
         {
            g2.setColor(getContentColor(getContents(column, row)));
            int xPos = 10 + row * sideLength;
            int yPos = 10 + column * sideLength;
            g2.fillRect(xPos, yPos, sideLength, sideLength);
         }
      if (displayPause)
      {
         g2.setColor(Color.black);
         g2.setFont(new Font("Courier New", Font.PLAIN, 64));
         int sWidth = g2.getFontMetrics().stringWidth("Paused");
         int sHeight = g2.getFontMetrics().getHeight();
         g2.drawString("Paused", (getWidth() / 2 - sWidth / 2) + 10, (getHeight() / 2 - sHeight / 2) + 10);
      }
   }

   private Color getContentColor(CellContents content)
   {
      switch (content)
      {
         case WALL:
            return Color.black;
         case FOOD:
            return Color.green;
         case SNAKE:
            return Color.blue;
         case SNAKEHEAD:
            return Color.red;
         default:
         case EMPTY:
            return Color.white;
      }
   }

}
