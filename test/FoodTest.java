/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
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
      assertTrue(instance.equals(new Food(1, new Point2D.Double(10, 20), 0)));
      assertFalse(instance.equals(new Food(1, new Point2D.Double(20, 20), 0)));
      assertFalse(instance.equals(new Food(2, new Point2D.Double(10, 20), 0)));
      assertFalse(instance.equals(null));
   }

   /**
    Test of hashCode method, of class Food.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");
      Random random = new Random();
      Food[] foods = new Food[500];
      for (int i = 0; i < foods.length; i++)
         foods[i] = new Food(random.nextInt(), new Point2D.Double(random.nextDouble(), random.nextDouble()), random.nextInt(2));
      for (int i = 0; i < foods.length; i++)
         for (int j = i + 1; j < foods.length; j++)
            if (foods[i].equals(foods[j]))
               assertTrue(foods[i].hashCode() == foods[j].hashCode());
            else
               assertTrue(foods[i].hashCode() != foods[j].hashCode());
   }

   /**
    Test of draw method, of class Food.
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
            try
            {
               File fontFile = new File(getClass().getClassLoader().getResource("LessPerfectDOSVGA.ttf").getFile());
               Font displayFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
               displayFont = displayFont.deriveFont(16f);
               g2.setFont(displayFont);
            }
            catch (FontFormatException | IOException ex)
            {
               System.out.println("Error: Font not found.");
            }
            int xPos = 16;
            int yPos = 16;
            GameManager.monochrome = !GameManager.monochrome;
            g2.setColor(Color.red);
            g2.fillRect(0, 0, getWidth(), getHeight());
            for (int i = 0; i < 10; i++)
            {
               new Food(1, new Point2D.Double(50 + xPos * i, 50 + yPos * i), 1).draw(g2, 50 + xPos * i, 50 + yPos * i);
               new Food(1, new Point2D.Double(50 + xPos * i, 50 + yPos * (i + 1)), 0).draw(g2, 50 + xPos * i, 50 + yPos * (i + 1));
            }
         }

      };
      frame.setSize(300, 300);
      frame.setVisible(true);
      frame.invalidate();
      System.out.println("Verify food is drawn");
      for (int i = 0; i < 10; i++)
      {
         frame.update(frame.getGraphics());
         Thread.sleep(250);
      }
   }
}
