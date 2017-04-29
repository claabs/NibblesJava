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
public class FoodTest
{

   private Food instance;

   public FoodTest()
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
      instance = new Food(1, new Point2D.Double(10, 20));
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of getValue method, of class Food.
    */
   @Test
   public void testGetValue()
   {
      System.out.println("getValue");
      assertTrue(instance.getValue() == 1);
   }

   /**
    Test of getPosition method, of class Food.
    */
   @Test
   public void testGetPosition()
   {
      System.out.println("getPosition");
      assertTrue(instance.getPosition().equals(new Point2D.Double(10, 20)));
   }

   /**
    Test of setValue method, of class Food.
    */
   @Test
   public void testSetValue()
   {
      System.out.println("setValue");
      assertTrue(instance.getValue() == 1);
      for (int i = 0; i < 500; i++)
      {
         instance.setValue(i);
         assertTrue(instance.getValue() == i);
      }
   }

   /**
    Test of setPosition method, of class Food.
    */
   @Test
   public void testSetPosition()
   {
      System.out.println("setPosition");
      assertTrue(instance.getPosition().equals(new Point2D.Double(10, 20)));
      instance.setPosition(new Point2D.Double(5, 10));
      assertTrue(instance.getPosition().equals(new Point2D.Double(5, 10)));
   }

   /**
    Test of equals method, of class Food.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      assertTrue(instance.equals(new Food(1, new Point2D.Double(10, 20))));
      assertFalse(instance.equals(new Food(1, new Point2D.Double(20, 20))));
      assertFalse(instance.equals(new Food(2, new Point2D.Double(10, 20))));
      assertFalse(instance.equals(null));
   }
}
