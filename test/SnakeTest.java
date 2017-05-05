/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.List;
import java.util.Random;
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
   private Snake[] instance = new Snake[2];
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
      instance[0] = new Snake(new Point2D.Double(20, 20), Snake.Direction.UP, 1);
      instance[1] = new Snake(new Point2D.Double(10, 10), Snake.Direction.UP, 2);

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
      System.out.println("Snake:iterateForward");
      instance[0].iterateForward();
      assertTrue(instance[0].getHeadLocation().equals(new Point2D.Double(20, 19)));
   }

   /**
    Test of getHeadLocation method, of class Snake.
    */
   @Test
   public void testGetHeadLocation()
   {
      System.out.println("Snake:getHeadLocation");
      assertTrue(instance[0].getHeadLocation().equals(new Point2D.Double(20, 20)));
   }

   /**
    Test of getSnakeSegments method, of class Snake.
    */
   @Test
   public void testGetSnakeSegments()
   {
      System.out.println("Snake:getSnakeSegments");
      assertTrue(instance[0].getSnakeSegments().size() == 1);
   }

   /**
    Test of checkCollison method, of class Snake.
    */
   @Test
   public void testCheckCollison()
   {
      System.out.println("Snake:checkCollison");
      assertTrue(instance[0].checkCollison(new SnakeHead(new Point2D.Double(20, 20), Snake.Direction.UP, instance[0])));
   }

   /**
    Test of setDirection method, of class Snake.
    */
   @Test
   public void testSetDirection()
   {
      System.out.println("Snake:setDirection");
      instance[0].setDirection(Snake.Direction.RIGHT);
      boolean result = instance[0].getDirection() == Snake.Direction.RIGHT;
      assertTrue(result);
   }

   /**
    Test of die method, of class Snake.
    */
   @Test
   public void testDie()
   {
      System.out.println("Snake:die");
      assertTrue(instance[0].getLives() == 5);
      instance[0].die();
      assertTrue(instance[0].getLives() == 4);
      instance[0].die();
      assertTrue(instance[0].getLives() == 3);
   }

   /**
    Test of eat method, of class Snake.
    */
   @Test
   public void testEat()
   {
      System.out.println("Snake:eat");
      assertTrue(instance[0].getScore() == 0);
      instance[0].eat(new Food(1, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 100);
      instance[0].eat(new Food(2, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 300);
      instance[0].eat(new Food(3, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 600);
      instance[0].eat(new Food(4, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 1000);
   }

   /**
    Test of getScore method, of class Snake.
    */
   @Test
   public void testGetScore()
   {
      System.out.println("Snake:getScore");
      assertTrue(instance[0].getScore() == 0);
      instance[0].eat(new Food(1, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 100);
      instance[0].eat(new Food(2, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 300);
      instance[0].eat(new Food(3, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 600);
      instance[0].eat(new Food(4, new Point2D.Double(20, 20), 0));
      assertTrue(instance[0].getScore() == 1000);
   }

   /**
    Test of getLives method, of class Snake.
    */
   @Test
   public void testGetLives()
   {
      System.out.println("Snake:getLives");
      assertTrue(instance[0].getLives() == 5);
      instance[0].die();
      assertTrue(instance[0].getLives() == 4);
      instance[0].die();
      assertTrue(instance[0].getLives() == 3);
   }

   /**
    Test of equals method, of class Snake.
    */
   @Test
   public void testEquals()
   {
      System.out.println("Snake:equals");
      assertTrue(instance[0].equals(new Snake(new Point2D.Double(20, 20), Snake.Direction.UP, 0)));
      assertFalse(instance[0].equals(new Snake(new Point2D.Double(20, 40), Snake.Direction.UP, 0)));
      assertFalse(instance[0].equals(null));
   }

   /**
    Test of moveSpawn method, of class Snake.
    */
   @Test
   public void testMoveSpawn()
   {
      System.out.println("Snake:moveSpawn");
      Point2D.Double p1 = new Point2D.Double(5, 5);
      instance[0].moveSpawn(p1, Snake.Direction.LEFT);
      Point2D.Double p2 = instance[0].getHeadLocation();
      boolean result = p2.equals(p1);
      assertFalse(result);
   }

   /**
    Test of getColorColor method, of class Snake.
    */
   @Test
   public void testGetColorColor()
   {
      System.out.println("Snake:getColorColor");
      instanceG.setMonochrome(false);
      instanceG.setNumberOfPlayers(1);
      Color a = instance[0].getColor();
      Color b = new Color(255, 255, 85);
      boolean result = (a.equals(b));

      assertTrue(result);
   }

   /**
    Test of getMonoColor method, of class Snake.
    */
   @Test
   public void testGetMonoColor()
   {
      System.out.println("Snake:getMonoColor");
      instanceG.setMonochrome(true);
      instanceG.setNumberOfPlayers(1);
      Color a = instance[0].getColor();
      Color b = new Color(255, 255, 255);
      boolean result = (a.equals(b));
      assertTrue(result);
   }

   /**
    Test of getColor method, of class Snake.
    */
   @Test
   public void testGetColor()
   {
      System.out.println("Snake:getColor");
      instanceG.setMonochrome(true);
      instanceG.setNumberOfPlayers(1);
      Color a = instance[0].getColor();
      Color b = new Color(255, 255, 255);
      boolean result = (a.equals(b));
      assertTrue(result);
   }

   /**
    Test of respawn method, of class Snake.
    */
   @Test
   public void testRespawn()
   {
      System.out.println("Snake:respawn");
      instance[0].respawn();
      assertFalse(instance[0].getSnakeSegments().isEmpty());
   }

   /**
    Test of draw method, of class Snake.
    */
   @Test
   public void testDraw() throws InterruptedException
   {
      System.out.println("Snake:draw");
      GameManager.monochrome = false;
      JFrame frame = new JFrame()
      {
         @Override
         public void update(Graphics g)
         {
            Graphics2D g2 = (Graphics2D) g;
            int xPos = 50;
            int yPos = 50;
            GameManager.monochrome = !GameManager.monochrome;
            for (int i = 0; i < instance.length; i++)
               instance[i].draw(g2, 50 + i * xPos, 50 + i * yPos);
         }

      };
      frame.setSize(300, 300);
      frame.setVisible(true);
      frame.invalidate();
      StackTraceElement element = new Exception().getStackTrace()[0];
      System.out.println(element);
      System.out.println("Verify both snakes are drawn");
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
      System.out.println("Snake:collidedWithOtherSnake");
      boolean result = instance[0].collidedWithOtherSnake(instance[1]);
      boolean expResult = false;
      assertEquals(expResult, result);
   }

   /**
    Test of gameOver method, of class Snake.
    */
   @Test
   public void testGameOver()
   {
      System.out.println("Snake:gameOver");
      boolean expResult = false;
      boolean result = instance[0].gameOver();
      assertEquals(expResult, result);
   }

   /**
    Test of hashCode method, of class Snake.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("Snake:hashCode");
      for (int i = 0; i < instance.length; i++)
         assertTrue(instance[i].hashCode() != 0);
   }

}
