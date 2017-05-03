/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.geom.Point2D;
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
public class GamePanelTest
{

   private static final int CELL_SIZE = 8;
   private static final int WIDTH = 80;
   private static final int HEIGHT = 49;
   private static final int MARGIN_SPACING = 20;
   private static final int TITLE_BAR_HEIGHT = 25;
   private JFrame window;

   private GamePanel instance;

   public GamePanelTest()
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
      window = new JFrame();
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
      instance = new GamePanel(WIDTH, HEIGHT, new GameManager(new JFrame()));
      window.add(instance);
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of getContents method, of class GamePanel.
    */
   @Test
   public void testGetContents()
   {
      System.out.println("getContents");
      fail("The test case is a prototype");
   }

   /**
    Test of setContents method, of class GamePanel.
    */
   @Test
   public void testSetContents() throws InterruptedException
   {
      System.out.println("setContents");
      fail("The test case is a prototype");
   }

   /**
    Test of slowTimerDown method, of class GamePanel.
    */
   @Test
   public void testSlowTimerDown()
   {
      System.out.println("slowTimerDown");
      GamePanel instance = null;
      instance.slowTimerDown();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    Test of speedUpTimer method, of class GamePanel.
    */
   @Test
   public void testSpeedUpTimer()
   {
      System.out.println("speedUpTimer");
      GamePanel instance = null;
      instance.speedUpTimer();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    Test of paintComponent method, of class GamePanel.
    */
   @Test
   public void testPaintComponent()
   {
      System.out.println("paintComponent");
      Graphics g = null;
      GamePanel instance = null;
      instance.paintComponent(g);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    Test of stopTimer method, of class GamePanel.
    */
   @Test
   public void testStopTimer()
   {
      System.out.println("stopTimer");
      GamePanel instance = null;
      instance.stopTimer();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    Test of startTimer method, of class GamePanel.
    */
   @Test
   public void testStartTimer()
   {
      System.out.println("startTimer");
      GamePanel instance = null;
      instance.startTimer();
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

}
