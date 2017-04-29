/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author Noah Moss
 */
public class SnakeSegmentTest
{
   
   public SnakeSegmentTest()
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
   }
   
   @After
   public void tearDown()
   {
   }

   /**
    * Test of moveForward method, of class SnakeSegment.
    */
   @Test
   public void testMoveForward()
   {
      System.out.println("moveForward");
      SnakeSegment instance = new SnakeSegment(new Point2D.Double(20,20), Snake.Direction.UP);
      instance.moveForward();
      assertTrue(instance.getPosition().equals(new Point2D.Double(20,19)));
   }

   /**
    * Test of getPosition method, of class SnakeSegment.
    */
   @Test
   public void testGetPosition()
   {
      System.out.println("getPosition");
      SnakeSegment instance = new SnakeSegment(new Point2D.Double(20,20), Snake.Direction.UP);
      assertTrue(instance.getPosition().equals(new Point2D.Double(20,20)));
   }

   /**
    * Test of getDirection method, of class SnakeSegment.
    */
   @Test
   public void testGetDirection()
   {
      System.out.println("getDirection");
      SnakeSegment instance = new SnakeSegment(new Point2D.Double(20,20), Snake.Direction.UP);
      assertTrue(instance.getDirection().equals(Snake.Direction.UP));
   }

   /**
    * Test of setDirection method, of class SnakeSegment.
    */
   @Test
   public void testSetDirection()
   {
      System.out.println("setDirection");
      SnakeSegment instance = new SnakeSegment(new Point2D.Double(20,20), Snake.Direction.UP);
      instance.setDirection(Snake.Direction.RIGHT);
      assertTrue(instance.getDirection().equals(Snake.Direction.RIGHT));
   }
   
}
