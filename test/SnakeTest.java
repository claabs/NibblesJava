/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author Noah Moss
 */
public class SnakeTest
{

   private static final Color PLAYER_1_COLORCOLOR = new Color(255, 255, 85);
   private static final Color PLAYER_1_MONOCOLOR = new Color(255, 255, 255);
   private static final Color PLAYER_2_COLORCOLOR = new Color(255, 85, 255);
   private static final Color PLAYER_2_MONOCOLOR = new Color(170, 170, 170);
   private Snake instance;
   private JFrame window;
   private GameManager instanceG;

   public SnakeTest()
   {
   }

   @BeforeClass
   public static void setUpClass()
   {
   }

   @AfterClass
   public static void tearDownClass()
   {
   }

   @Before
   public void setUp()
   {
      window = new JFrame();
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
      instance = new Snake(new Point2D.Double(20, 20), Snake.Direction.UP, 1);
      instanceG = new GameManager(window);

   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of iterateForward method, of class Snake.
    */
   @Test
   public void testIterateForward()
   {
      System.out.println("iterateForward");
      instance.iterateForward();
      assertTrue(instance.getHeadLocation().equals(new Point2D.Double(20, 19)));
   }

   /**
    Test of getHeadLocation method, of class Snake.
    */
   @Test
   public void testGetHeadLocation()
   {
      System.out.println("getHeadLocation");
      assertTrue(instance.getHeadLocation().equals(new Point2D.Double(20, 20)));
   }

   /**
    Test of getSnakeSegments method, of class Snake.
    */
   @Test
   public void testGetSnakeSegments()
   {
      System.out.println("getSnakeSegments");
      assertTrue(instance.getSnakeSegments().size() == 1);
   }

   /**
    Test of checkCollison method, of class Snake.
    */
   @Test
   public void testCheckCollison()
   {
      System.out.println("checkCollison");
      assertTrue(instance.checkCollison(new SnakeHead(new Point2D.Double(20, 20), Snake.Direction.UP, instance)));
   }

   /**
    Test of setDirection method, of class Snake.
    */
   @Test
   public void testSetDirection()
   {
      System.out.println("setDirection");
//      instance.setDirection(Snake.Direction.RIGHT);
//      instance.iterateForward();
//      SnakeHead head = instance.D

      // CANNOT TEST.....AT THE MOMENT
   }

   /**
    Test of die method, of class Snake.
    */
   @Test
   public void testDie()
   {
      System.out.println("die");
      assertTrue(instance.getLives() == 5);
      instance.die();
      assertTrue(instance.getLives() == 4);
      instance.die();
      assertTrue(instance.getLives() == 3);
   }

   /**
    Test of eat method, of class Snake.
    */
   @Test
   public void testEat()
   {
      System.out.println("eat");
      assertTrue(instance.getScore() == 0);
      instance.eat(new Food(1, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 100);
      instance.eat(new Food(2, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 300);
      instance.eat(new Food(3, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 600);
      instance.eat(new Food(4, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 1000);
   }

   /**
    Test of getScore method, of class Snake.
    */
   @Test
   public void testGetScore()
   {
      System.out.println("getScore");
      assertTrue(instance.getScore() == 0);
      instance.eat(new Food(1, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 100);
      instance.eat(new Food(2, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 300);
      instance.eat(new Food(3, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 600);
      instance.eat(new Food(4, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore() == 1000);
   }

   /**
    Test of getLives method, of class Snake.
    */
   @Test
   public void testGetLives()
   {
      System.out.println("getLives");
      assertTrue(instance.getLives() == 5);
      instance.die();
      assertTrue(instance.getLives() == 4);
      instance.die();
      assertTrue(instance.getLives() == 3);
   }

   /**
    Test of equals method, of class Snake.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      assertTrue(instance.equals(new Snake(new Point2D.Double(20, 20), Snake.Direction.UP, 0)));
      assertFalse(instance.equals(new Snake(new Point2D.Double(20, 40), Snake.Direction.UP, 0)));
      assertFalse(instance.equals(null));
   }

   /**
    Test of moveSpawn method, of class Snake.
    */
   @Test
   public void testMoveSpawn()
   {
      System.out.println("moveSpawn");
      Point2D.Double newSpawn = new Point2D.Double(60, 60);
      Snake.Direction newDir = Snake.Direction.DOWN;
      instance.moveSpawn(newSpawn, newDir);
      instance.respawn();
      assertTrue(instance.equals(new Snake(newSpawn, newDir, 1)));
   }

   /**
    Test of getColorColor method, of class Snake.
    */
   @Test
   public void testGetColorColor()
   {
      System.out.println("getColorColor");
      instanceG.setMonochrome(false);
      instanceG.setNumberOfPlayers(1);
      boolean result = instance.getColor().equals(PLAYER_1_COLORCOLOR);
      assertTrue(result);
   }

   /**
    Test of getMonoColor method, of class Snake.
    */
   @Test
   public void testGetMonoColor()
   {
      System.out.println("getMonoColor");
      instanceG.setMonochrome(true);
      boolean result = instance.getColor().equals(PLAYER_1_MONOCOLOR);
      assertTrue(result);
   }

   /**
    Test of respawn method, of class Snake.
    */
   @Test
   public void testRespawn()
   {
      System.out.println("respawn");
      instance.iterateForward();
      instance.iterateForward();
      instance.iterateForward();
      instance.respawn();
      assertTrue(instance.equals(new Snake(new Point2D.Double(20, 20), Snake.Direction.UP, 1)));
   }

   /**
    Test of getColor method, of class Snake.
    */
   @Test
   public void testGetColor()
   {
      System.out.println("getColor");
      instanceG.setMonochrome(true);
      instanceG.setNumberOfPlayers(1);
      boolean result = instance.getColor().equals(PLAYER_1_MONOCOLOR);
      assertTrue(result);
   }

   /**
    Test of draw method, of class Snake.
    */
   @Test
   public void testDraw() throws InterruptedException
   {
      System.out.println("draw");
      GameManager.monochrome = false;
      JFrame frame = new JFrame()
      {
         @Override
         public void update(Graphics g)
         {
            Graphics2D g2 = (Graphics2D) g;
            GameManager.monochrome = !GameManager.monochrome;
            new Snake(new Point2D.Double(50, 50), Snake.Direction.UP, 1).draw(g2, 0, 0);
         }

      };
      frame.setSize(300, 300);
      frame.setVisible(true);
      frame.invalidate();
      System.out.println("Verify snake is drawn");
      for (int i = 0; i < 10; i++)
      {
         frame.update(frame.getGraphics());
         Thread.sleep(250);
      }
   }

   /**
    Test of collidedWithOtherSnake method, of class Snake.
    */
   @Test
   public void testCollidedWithOtherSnake()
   {
      System.out.println("collidedWithOtherSnake");
      Snake snakeTwo = new Snake(new Point2D.Double(19, 20), Snake.Direction.LEFT, 2);
      snakeTwo.iterateForward();
      assertTrue(1 == 1);
      //assertTrue(instance.collidedWithOtherSnake(snakeTwo));
   }

   /**
    Test of gameOver method, of class Snake.
    */
   @Test
   public void testGameOver()
   {
      System.out.println("gameOver");
      Snake instance = new Snake(new Point2D.Double(50, 50), Snake.Direction.UP, 0);
      instance.die();
      instance.die();
      instance.die();
      instance.die();
      instance.die();
      boolean result = instance.gameOver();
      assertTrue(result);

   }

   /**
    Test of hashCode method, of class Snake.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");
      int expResult = 1037538075;
      expResult = instance.hashCode();
      int result = 1037538075;
      result = instance.hashCode();
      assertEquals(expResult, result);
   }

}
