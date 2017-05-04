/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
      System.out.println("collided");
      Collidable c = null;
      Collidable instance = null;
      boolean expResult = false;
      boolean result = instance.collided(c);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of equals method, of class Collidable.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      Object o = null;
      Collidable instance = null;
      boolean expResult = false;
      boolean result = instance.equals(o);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of hashCode method, of class Collidable.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");
      Collidable instance = null;
      int expResult = 0;
      int result = instance.hashCode();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   public class CollidableImpl extends Collidable
   {

      public CollidableImpl()
      {
         super(null, 0, 0, null, null);
      }
   }
   
}
