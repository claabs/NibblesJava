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
      instance = new Food(20, new Point2D.Double(10, 20));
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
      int expResult = 20;
      int result = instance.getValue();
      assertEquals(expResult, result);

   }

   /**
    Test of getPosition method, of class Food.
    */
   @Test
   public void testGetPosition()
   {
      System.out.println("getPosition");
      Point2D expResult = new Point2D.Double(10, 20);
      Point2D result = instance.getPosition();
      assertEquals(expResult, result);
   }

   /**
    Test of setValue method, of class Food.
    */
   @Test
   public void testSetValue()
   {
      System.out.println("setValue");
      int newFoodValue = 8;
      assertTrue(instance.getValue() == 20);
      instance.setValue(newFoodValue);
      assertTrue(newFoodValue == instance.getValue());
   }

   /**
    Test of setPosition method, of class Food.
    */
   @Test
   public void testSetPosition()
   {
      System.out.println("setPosition");
      Point2D.Double newLocation = new Point2D.Double(5, 10);
      assertTrue(instance.getPosition().equals(new Point2D.Double(10, 20)));
      instance.setPosition(newLocation);
      assertTrue(instance.getPosition().equals(newLocation));
   }
}
