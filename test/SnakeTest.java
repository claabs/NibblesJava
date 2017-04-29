/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.geom.Point2D;
import java.util.List;
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

   private Snake instance;

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
      instance = new Snake(new Point2D.Double(20, 20), Snake.Direction.UP);
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
      assertTrue(instance.checkCollison(new SnakeHead(new Point2D.Double(20, 20), Snake.Direction.UP)));
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
      instance.eat(new Food(1, new Point2D.Double(20, 20)));
      assertTrue(instance.getScore()== 100);
      instance.eat(new Food(2, new Point2D.Double(20, 20)));
      assertTrue(instance.getScore()== 300);
      instance.eat(new Food(3, new Point2D.Double(20, 20)));
      assertTrue(instance.getScore()== 600);
      instance.eat(new Food(4, new Point2D.Double(20, 20)));
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
      instance.eat(new Food(1, new Point2D.Double(20, 20)));
      assertTrue(instance.getScore()== 100);
      instance.eat(new Food(2, new Point2D.Double(20, 20)));
      assertTrue(instance.getScore()== 300);
      instance.eat(new Food(3, new Point2D.Double(20, 20)));
      assertTrue(instance.getScore()== 600);
      instance.eat(new Food(4, new Point2D.Double(20, 20)));
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
      assertTrue(instance.equals(new Snake(new Point2D.Double(20, 20), Snake.Direction.UP)));
      assertFalse(instance.equals(new Snake(new Point2D.Double(20, 40), Snake.Direction.UP)));
      assertFalse(instance.equals(null));
   }

}
