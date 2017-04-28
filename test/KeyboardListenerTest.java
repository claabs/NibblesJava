/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComponent;
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
public class KeyboardListenerTest
{

   private static final int CELL_SIZE = 15;
   private static final int WIDTH = 80;
   private static final int HEIGHT = 50;
   private static final int MARGIN_SPACING = 20;
   private static final int TITLE_BAR_HEIGHT = 25;
   private JFrame window;

   private GameManager manager;
   private Robot robot;

   public KeyboardListenerTest()
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
   public void setUp() throws AWTException
   {

      window = new JFrame();
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
      window.setSize(CELL_SIZE * WIDTH + MARGIN_SPACING,
            CELL_SIZE * HEIGHT + MARGIN_SPACING + TITLE_BAR_HEIGHT);
      manager = new GameManager(window, HEIGHT, WIDTH, CELL_SIZE);
      robot = new Robot();
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of keyPressed method, of class KeyboardListener.
    */
   @Test
   public void testKeyPressed()
   {
      System.out.println("keyPressed");
      robot.delay(500);
      robot.keyPress(KeyEvent.VK_P);
      robot.delay(500);
      assertTrue(manager.isPaused());
      robot.keyRelease(KeyEvent.VK_P);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(500);
      assertFalse(manager.isPaused());
      robot.keyRelease(KeyEvent.VK_SPACE);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_RIGHT);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[0] == GameManager.SnakeDirection.RIGHT);
      robot.keyRelease(KeyEvent.VK_RIGHT);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_UP);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[0] == GameManager.SnakeDirection.UP);
      robot.keyRelease(KeyEvent.VK_UP);
      
      robot.delay(500);
      robot.keyPress(KeyEvent.VK_LEFT);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[0] == GameManager.SnakeDirection.LEFT);
      robot.keyRelease(KeyEvent.VK_LEFT);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_DOWN);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[0] == GameManager.SnakeDirection.DOWN);
      robot.keyRelease(KeyEvent.VK_DOWN);
      
      robot.delay(500);
      robot.keyPress(KeyEvent.VK_D);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[1] == GameManager.SnakeDirection.RIGHT);
      robot.keyRelease(KeyEvent.VK_D);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_W);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[1] == GameManager.SnakeDirection.UP);
      robot.keyRelease(KeyEvent.VK_W);
      
      robot.delay(500);
      robot.keyPress(KeyEvent.VK_A);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[1] == GameManager.SnakeDirection.LEFT);
      robot.keyRelease(KeyEvent.VK_A);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_S);
      robot.delay(500);
      assertTrue(GameManager.directionSnake[1] == GameManager.SnakeDirection.DOWN);
      robot.keyRelease(KeyEvent.VK_S);
      
      
      
   }

}
