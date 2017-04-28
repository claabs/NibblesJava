/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

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
public class GameManagerTest
{

   private static final int CELL_SIZE = 15;
   private static final int WIDTH = 80;
   private static final int HEIGHT = 50;
   private static final int MARGIN_SPACING = 20;
   private static final int TITLE_BAR_HEIGHT = 25;
   private JFrame window;

   private GameManager instance;
   
   public GameManagerTest()
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
      window.setSize(CELL_SIZE * WIDTH + MARGIN_SPACING,
            CELL_SIZE * HEIGHT + MARGIN_SPACING + TITLE_BAR_HEIGHT);
      instance = new GameManager(window, HEIGHT, WIDTH, CELL_SIZE);
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of run method, of class GameManager.
    */
   @Test
   public void testRun() throws InterruptedException
   {
      System.out.println("run");
      System.out.println("Verify running.");
      Thread.sleep(2500);
   }

   /**
    Test of pause method, of class GameManager.
    */
   @Test
   public void testPause() throws InterruptedException
   {
      System.out.println("pause");
      System.out.println("Verify \"Pause\" screen is showing.");
      GameManager.pause();
      Thread.sleep(2500);
   }

   /**
    Test of unpause method, of class GameManager.
    */
   @Test
   public void testUnpause() throws InterruptedException
   {
      System.out.println("unpause");
      System.out.println("Verify \"Pause\" screen is no longer showing.");
      GameManager.unpause();
      Thread.sleep(2500);
   }

   /**
    * Test of isPaused method, of class GameManager.
    */
   @Test
   public void testIsPaused() throws InterruptedException
   {
      System.out.println("isPaused");
      GameManager.pause();
      Thread.sleep(2500);
      assertTrue(GameManager.isPaused());
      GameManager.unpause();
      Thread.sleep(2500);
      assertFalse(GameManager.isPaused());
   }

}
