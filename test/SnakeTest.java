/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.List;
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
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.UP);
      instance.setDirection(Snake.Direction.LEFT);
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.LEFT);
      instance.setDirection(Snake.Direction.DOWN);
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.DOWN);
      instance.setDirection(Snake.Direction.RIGHT);
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.RIGHT);
   }

   /**
    Test of getDirectionLastMoved method, of class Snake.
    */
   @Test
   public void testGetDirection()
   {
      System.out.println("getDirection");
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.UP);
      instance.setDirection(Snake.Direction.LEFT);
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.LEFT);
      instance.setDirection(Snake.Direction.DOWN);
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.DOWN);
      instance.setDirection(Snake.Direction.RIGHT);
      assertTrue(instance.getDirectionLastMoved() == Snake.Direction.RIGHT);
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
      assertTrue(instance.getScore()== 100);
      instance.eat(new Food(2, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore()== 300);
      instance.eat(new Food(3, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore()== 600);
      instance.eat(new Food(4, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore()== 1000);
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
      assertTrue(instance.getScore()== 100);
      instance.eat(new Food(2, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore()== 300);
      instance.eat(new Food(3, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore()== 600);
      instance.eat(new Food(4, new Point2D.Double(20, 20), 0));
      assertTrue(instance.getScore()== 1000);
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
    * Test of equals method, of class Snake.
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
    * Test of moveSpawn method, of class Snake.
    */
   @Test
   public void testMoveSpawn()
   {
      System.out.println("moveSpawn");
      Point2D.Double newSpawn = null;
      Snake.Direction newDir = null;
      Snake instance = null;
      instance.moveSpawn(newSpawn, newDir);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getColorColor method, of class Snake.
    */
   @Test
   public void testGetColorColor()
   {
      System.out.println("getColorColor");
      instanceG.setMonochrome(false);
      
      instanceG.setNumberOfPlayers(1);
      boolean result;
      result = (instance.getColorColor()== PLAYER_1_COLORCOLOR) || (instance.getColorColor() == PLAYER_2_COLORCOLOR) || (instance.getColor() == PLAYER_1_MONOCOLOR) || (instance.getColor() == PLAYER_2_MONOCOLOR);
      assertTrue(result);       
   }

   /**
    * Test of getMonoColor method, of class Snake.
    */
   @Test
   public void testGetMonoColor()
   {
      System.out.println("getMonoColor");
       instanceG.setMonochrome(true);
      instanceG.setNumberOfPlayers(1);
      boolean result = (instance.getColor() == PLAYER_1_MONOCOLOR) || (instance.getColor() == PLAYER_2_MONOCOLOR);
      assertTrue(result);    
   }

   /**
    * Test of respawn method, of class Snake.
    */
   @Test
   public void testRespawn()
   {
      System.out.println("respawn");
      Snake instance = null;
      instance.respawn();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getColor method, of class Snake.
    */
   @Test
   public void testGetColor()
   {
      System.out.println("getColor");
      instanceG.setMonochrome(true);
      instanceG.setNumberOfPlayers(1);
      boolean result = instance.getColor() == PLAYER_1_MONOCOLOR;
      assertTrue(result);
   }

   /**
    * Test of draw method, of class Snake.
    */
   @Test
   public void testDraw()
   {
      System.out.println("draw");
      Graphics2D g = null;
      int xOffset = 0;
      int yOffset = 0;
      Snake instance = null;
      instance.draw(g, xOffset, yOffset);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of collidedWithOtherSnake method, of class Snake.
    */
   @Test
   public void testCollidedWithOtherSnake()
   {
      System.out.println("collidedWithOtherSnake");
      Snake snake = null;
      Snake instance = null;
      boolean expResult = false;
      boolean result = instance.collidedWithOtherSnake(snake);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of gameOver method, of class Snake.
    */
   @Test
   public void testGameOver()
   {
      System.out.println("gameOver");
      Snake instance = null;
      boolean expResult = false;
      boolean result = instance.gameOver();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getDirectionLastMoved method, of class Snake.
    */
   @Test
   public void testGetDirectionLastMoved()
   {
      System.out.println("getDirectionLastMoved");
      Snake instance = null;
      Snake.Direction expResult = null;
      Snake.Direction result = instance.getDirectionLastMoved();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of hashCode method, of class Snake.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");
      Snake instance = null;
      int expResult = 0;
      int result = instance.hashCode();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

}
