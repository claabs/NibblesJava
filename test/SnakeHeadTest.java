/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**

 @author Noah Moss
 */
public class SnakeHeadTest
{

   public SnakeHeadTest()
   {
   }
   private Snake papa;
   private SnakeHead instance;

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
      papa = new Snake(new Point2D.Double(20, 20), Snake.Direction.UP, 1);
      instance = new SnakeHead(new Point2D.Double(50, 50), Snake.Direction.UP, papa);
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of equals method, of class SnakeHead.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      Object o = null;
      boolean expResult = false;
      boolean result = instance.equals(o);
      assertTrue(expResult == result);
      expResult = true;
      o = new SnakeHead(new Point2D.Double(50, 50), Snake.Direction.UP, papa);
      result = instance.equals(o);
      assertTrue(expResult == result);
   }

   /**
    Test of hashCode method, of class SnakeHead.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");

      int expResult = 796533938;
      int result = instance.hashCode();
      assertEquals(expResult, result);
   }
}
