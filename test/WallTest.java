/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author Nick
 */
public class WallTest
{

   public WallTest()
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
   public void testSomeMethod()
   {
   }

   /**
    Test of draw method, of class Wall.
    */
   @Test
   public void testDraw() throws InterruptedException
   {
      System.out.println("draw");
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
               new Wall(new Point2D.Double(50 + xPos * i, 50 + yPos * i)).draw(g2, 50 + xPos * i, 50 + yPos * i);
         }

      };
      frame.setSize(300, 300);
      frame.setVisible(true);
      frame.invalidate();
      System.out.println("Verify wall is drawn");
      for (int i = 0; i < 10; i++)
      {
         frame.update(frame.getGraphics());
         Thread.sleep(250);
      }
   }

}
