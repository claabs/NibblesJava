/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

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

   @Test
   public void someTestMethod()
   {

   }

   /**
    * Test of equals method, of class SnakeHead.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      Object o = null;
      SnakeHead instance = null;
      boolean expResult = false;
      boolean result = instance.equals(o);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of hashCode method, of class SnakeHead.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");
      SnakeHead instance = null;
      int expResult = 0;
      int result = instance.hashCode();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
}
