/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Random;
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
      instance = new Food(1, new Point2D.Double(10, 20), 0);
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
    Test of equals method, of class Food.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      assertTrue(instance.equals(new Food(1, new Point2D.Double(10, 20),0)));
      assertFalse(instance.equals(new Food(1, new Point2D.Double(20, 20),0)));
      assertFalse(instance.equals(new Food(2, new Point2D.Double(10, 20),0)));
      assertFalse(instance.equals(null));
   }

   /**
    * Test of hashCode method, of class Food.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");
      Random random = new Random();
      Food[] foods = new Food[500];
      for (int i=0;i<foods.length;i++)
         foods[i]=new Food(random.nextInt(), new Point2D.Double(random.nextDouble(), random.nextDouble()), random.nextInt(2));
      for (int i=0;i<foods.length;i++)
         for (int j=i+1;j<foods.length;j++)
      assertFalse(foods[i].hashCode()==foods[j].hashCode());
   }

   /**
    * Test of draw method, of class Food.
    */
   @Test
   public void testDraw()
   {
      System.out.println("draw");
      Graphics2D g = null;
      int xPos = 1;
      int yPos = 1;
      instance.draw(g, xPos, yPos);
       System.out.println("Verify \"Food\" is displayed in upper left.");
    }
}
