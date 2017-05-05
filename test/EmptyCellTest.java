/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
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

 @author User
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
      window  = new JFrame();
      instanceC = new EmptyCell(new Point2D.Double(10, 20));
      instanceS = new Snake(new Point2D.Double(10, 20), Snake.Direction.UP, 1);
      instanceG = new GameManager(window);
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of collided method, of class EmptyCell.
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
    Test of getDrawColor method, of class EmptyCell.
    */
   @Test
   public void testGetDrawColor()
   {
      System.out.println("getDrawColor");
      Color expResult = COLOR_COLOR;
      instanceG.monochrome = false;
      Color result = EmptyCell.getDrawColor();
      assertTrue(expResult.equals(result));
      expResult = MONO_COLOR;
      instanceG.monochrome = true;
      result = EmptyCell.getDrawColor();
      assertTrue(expResult.equals(result));
   }

   /**
    Test of draw method, of class EmptyCell.
    */
   @Test
   public void testDraw() throws InterruptedException
   {
      System.out.println("draw");
      StackTraceElement element = new Exception().getStackTrace()[0];
      System.out.println(element);
      GameManager.monochrome = false;
      JFrame frame = new JFrame()
      {
         @Override
         public void update(Graphics g)
         {
            Graphics2D g2 = (Graphics2D) g;
            int xPos = 16;
            int yPos = 16;
            GameManager.monochrome = !GameManager.monochrome;
            for (int i = 0; i < 10; i++)
               new EmptyCell(new Point2D.Double(50 + xPos * i, 50 + yPos * i)).draw(g2, 50 + xPos * i, 50 + yPos * i);
         }

      };
      frame.setSize(300, 300);
      frame.setVisible(true);
      frame.invalidate();
      System.out.println("Verify empty cell is drawn");
      for (int i = 0; i < 10; i++)
      {
         frame.update(frame.getGraphics());
         Thread.sleep(250);
      }
   }

}
