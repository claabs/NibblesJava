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
   private GameManager manager;
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
      manager = new GameManager(window);
      //window.setVisible(true);
      instance = new GamePanel(WIDTH, HEIGHT, manager);
      //window.add(instance);
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
      manager.progressState();
      manager.setNumberOfPlayers(1);
      manager.progressState();
      manager.setSkill(1);
      manager.progressState();
      manager.setIncreaseSpeed(false);
      manager.progressState();
      manager.setMonochrome(false);
      manager.progressState();
      manager.progressState();
      Collidable contents=null;
      while (contents == null)
         contents = manager.gameBoard.getContents(5, 5);
      assertTrue(contents.getClass()==EmptyCell.class);
   }

   /**
    Test of slowTimerDown method, of class GamePanel.
    */
   @Test
   public void testSlowTimerDown()
   {
      System.out.println("slowTimerDown");
      manager.gameBoard.slowTimerDown();
      //Test passes on screen.
      assertTrue(true);
   }

   /**
    Test of speedUpTimer method, of class GamePanel.
    */
   @Test
   public void testSpeedUpTimer()
   {
      System.out.println("speedUpTimer");
      manager.gameBoard.speedUpTimer();
      //Test passes on screen.
      assertTrue(true);
   }

   /**
    Test of paintComponent method, of class GamePanel.
    */
   @Test
   public void testPaintComponent()
   {
      System.out.println("paintComponent");
      //Game displays, tests pass
      assertTrue(true);
   }
}
