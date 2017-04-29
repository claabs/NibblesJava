
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class GameManager
{

   private static final int MARGIN_SPACING = 20;
   private static final int TITLE_BAR_HEIGHT = 25;
   //Nick and Noah Area
   private boolean accelerate;
   private int currentLevel;
   private int difficulty;
   private GamePanel gameBoard;
   private Level levels;
   private Snake players[];
   private int speed;
   private static boolean paused;
   public Timer timer;
   private int updateInterval = 100;  // ms
   private JFrame window;
   private Food food;

   public enum playerEnum
   {
      PLAYER_ONE, PLAYER_TWO
   }

   private int getIntFromPlayerEnum(playerEnum player)
   {
      if (player == playerEnum.PLAYER_ONE)
         return 0;
      else if (player == playerEnum.PLAYER_TWO)
         return 1;
      return -1;
   }

   //public static SnakeDirection[] directionSnake = new SnakeDirection[2];
   public void setSnakeDirection(playerEnum player, Snake.Direction direction)
   {
      players[getIntFromPlayerEnum(player)].setDirection(direction);
   }

   public Snake.Direction getSnakeDirection(playerEnum player)
   {
      try
      {
         return players[getIntFromPlayerEnum(player)].getDirection();
      }
      catch (Exception e)
      {
         System.err.println("Player 2 Snake not initalized");
      }
      return Snake.Direction.UP;
   }

   public GameManager(JFrame inWindow, int inWidth, int inHeight, int cellSize)
   {
      window = inWindow;
      players = new Snake[2];
      players[0] = new Snake(new Point2D.Double(20, 20), Snake.Direction.UP);
      players[1] = new Snake(new Point2D.Double(40, 40), Snake.Direction.UP);
      food = new Food(2, new Point2D.Double(30, 30));
      gameBoard = new GamePanel(inWidth, inHeight, cellSize, this);
      ActionListener taskPerformer = (ActionEvent evt)
            -> 
            {
               run();
      };
      timer = new Timer(updateInterval, taskPerformer);
      timer.start();
      
      window.getContentPane().add(gameBoard);
      window.pack();
      //panel.add(gameBoard);
      window.addKeyListener((KeyListener) new KeyboardListener(this));
      window.setVisible(true);

   }

   private void loadLevel(int level)
   {

   }

   /**
    This method will be called by the timer only if the game is not paused.
    */
   private void updateGame()
   {
      for (int i = 0; i < players.length; i++)
      {
         players[i].iterateForward();
         for (int j = 0; j < players.length; j++)
         {
            Snake otherPlayer = players[j];
            java.util.List segments = otherPlayer.getSnakeSegments();
            for (int k = 0; k < segments.size(); k++)
               if (players[i].checkCollison((Collidable) segments.get(k)))
                  players[i].die();
         }
         if (players[i].checkCollison(food))
            players[i].eat(food);
      }
   }

   public Snake[] getSnakes()
   {
      return players;
   }

   public static void pause()
   {
      paused = true;
   }

   public static void unpause()
   {
      paused = false;
   }

   public void run()
   {
      gameBoard.showPause(paused);
      if (!paused)
         updateGame();
      //panel.invalidate();
      window.repaint();
      //window.repaint();
   }

   public Food getFood()
   {
      return food;
   }

   public static boolean isPaused()
   {
      return paused;
   }
}
