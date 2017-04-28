
import java.awt.*;
import java.awt.geom.Point2D;
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

   private final CellContents gameBoard[][];
   private final int sideLength;
   private boolean displayPause = false;
   private Level level;

   private GameManager manager;

   public enum CellContents
   {
      EMPTY, WALL, FOOD, SNAKE, SNAKEHEAD
   };

   public GamePanel(int boardWidth, int boardHeight, int squareLength, GameManager inManager)
   {
      manager = inManager;
      sideLength = squareLength;
      gameBoard = new CellContents[boardWidth][boardHeight];
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
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
         System.err.println(Integer.toString(column));
         System.err.println(Integer.toString(row));
         return CellContents.EMPTY;
      }
   }

   public void setContents(double column, double row, CellContents contents)
   {
      try
      {
         gameBoard[(int) column][(int) row] = contents;
      }
      catch (IndexOutOfBoundsException e)
      {
         System.err.println("Out of bounds exception:\n" + e.toString());
      }
   }

   private void updateFood()
   {
      Food food = manager.getFood();
      Point2D.Double foodPosition = food.getPosition();
      setContents(foodPosition.x, foodPosition.y, GamePanel.CellContents.FOOD);
   }

   private void updateSnakes()
   {
      Snake[] snakes = manager.getSnakes();
      for (int i = 0; i < snakes.length; i++)
      {
         Point2D.Double headLocation = snakes[i].getHeadLocation();
         setContents(headLocation.x, headLocation.y, GamePanel.CellContents.SNAKEHEAD);
         java.util.List<SnakeSegment> segments = snakes[i].getSnakeSegments();
         for (int j = 0; j < segments.size(); j++)
         {
            Point2D.Double segmentPosition = segments.get(j).getPosition();
            setContents(segmentPosition.x, segmentPosition.y, GamePanel.CellContents.SNAKE);
         }
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
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
            gameBoard[column][row] = CellContents.EMPTY;
      updateSnakes();
      updateFood();
      for (int column = 0; column < gameBoard.length; column++)
         for (int row = 0; row < gameBoard[column].length; row++)
         {
            g2.setColor(getContentColor(getContents(column, row)));
            int xPos = 10 + column * sideLength;
            int yPos = 10 + row * sideLength;
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
            return Color.red;
         case FOOD:
            return Color.white;
         case SNAKE:
            return Color.orange;
         case SNAKEHEAD:
            return Color.yellow;
         default:
         case EMPTY:
            return Color.blue;
      }
   }

}
