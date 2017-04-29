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

 @author Nick
 */
public class CollidableTest
{

   private Collidable instance;

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
      instance = new Collidable(new Point2D.Double(20, 20));
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of collided method, of class Collidable.
    */
   @Test
   public void testCollided()
   {
      System.out.println("collided");
      assertFalse(instance.collided(instance));
      assertTrue(instance.collided(new Collidable(new Point2D.Double(20, 20))));
      assertFalse(instance.collided(null));

   }

   /**
    Test of equals method, of class Collidable.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      assertTrue(instance.equals(new Collidable(new Point2D.Double(20, 20))));
      assertFalse(instance.equals(new Collidable(new Point2D.Double(10, 20))));
      assertFalse(instance.equals(null));
   }

}
