/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CollidableTest
{

   private Food instanceF;
   private Food instanceF2;
   private Snake instanceS;

   public CollidableTest()
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
      instanceF = new Food(1, new Point2D.Double(10, 20), 0);
      instanceF2 = new Food(1, new Point2D.Double(10, 20), 0);
      instanceS = new Snake(new Point2D.Double(10, 20), Snake.Direction.UP, 1);

   }

   @After
   public void tearDown()
   {
   }

   /**
    * Test of collided method, of class Collidable.
    */
   @Test
   public void testCollided()
   {
      System.out.println("Colldiable:collided");
      boolean expResult = true;
      boolean result = instanceS.checkCollison(instanceF);
      assertEquals(expResult, result); 
   }

   /**
    * Test of equals method, of class Collidable.
    */
   @Test
   public void testEquals()
   {
      System.out.println("Colldiable:equals");
       
      boolean expResult = true;
      boolean result = (instanceF.equals(instanceF2));
      assertEquals(expResult, result);
   }

   /**
    * Test of hashCode method, of class Collidable.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("Colldiable:hashCode");
      boolean expResult = true;
      boolean result = (instanceF.hashCode() != 0);
      assertEquals(expResult, result);
    }

 

}
