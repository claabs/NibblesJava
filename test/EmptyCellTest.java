/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
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
public class EmptyCellTest
{

   private Snake instanceS;
   private EmptyCell instanceC;
   private GameManager instanceG;
   private JFrame window;
   private final static Color COLOR_COLOR = new Color(0, 0, 170);
   private final static Color MONO_COLOR = new Color(0, 0, 0);

   public EmptyCellTest()
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
      instanceC = new EmptyCell(new Point2D.Double(10, 20));
      instanceS = new Snake(new Point2D.Double(10, 20), Snake.Direction.UP, 1);
      instanceG = new GameManager(window);
   }

   @After
   public void tearDown()
   {
   }

   /**
    * Test of collided method, of class EmptyCell.
    */
   @Test
   public void testCollided()
   {
      System.out.println("collided");
      boolean expResult = false;
      boolean result = instanceS.collidedWithCollidable(instanceC);
      assertEquals(expResult, result);
   }

   /**
    * Test of getDrawColor method, of class EmptyCell.
    */
   @Test
   public void testGetDrawColor()
   {
      System.out.println("getDrawColor");
      Color expResult = COLOR_COLOR;
      instanceG.setMonochrome(false);
      Color result = EmptyCell.getDrawColor();
      assertEquals(expResult, result);
   }

   /**
    * Test of draw method, of class EmptyCell.
    */
   @Test
   public void testDraw()
   {
      System.out.println("draw");
      Graphics2D g = null;
      int xPos = 0;
      int yPos = 0;
      EmptyCell instance = null;
      instance.draw(g, xPos, yPos);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

}
