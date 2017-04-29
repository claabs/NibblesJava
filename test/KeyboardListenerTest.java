/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.junit.*;
import static org.junit.Assert.*;

/**

 @author Noah Moss
 */
public class KeyboardListenerTest
{

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
      manager = new GameManager(window);
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
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.RIGHT);
      robot.keyRelease(KeyEvent.VK_RIGHT);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_UP);
      robot.delay(500);
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      robot.keyRelease(KeyEvent.VK_UP);
      
      robot.delay(500);
      robot.keyPress(KeyEvent.VK_LEFT);
      robot.delay(500);
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.LEFT);
      robot.keyRelease(KeyEvent.VK_LEFT);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_DOWN);
      robot.delay(500);
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.DOWN);
      robot.keyRelease(KeyEvent.VK_DOWN);
      
      robot.delay(500);
      robot.keyPress(KeyEvent.VK_D);
      robot.delay(500);
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.RIGHT);
      robot.keyRelease(KeyEvent.VK_D);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_W);
      robot.delay(500);
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      robot.keyRelease(KeyEvent.VK_W);
      
      robot.delay(500);
      robot.keyPress(KeyEvent.VK_A);
      robot.delay(500);
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.LEFT);
      robot.keyRelease(KeyEvent.VK_A);

      robot.delay(500);
      robot.keyPress(KeyEvent.VK_S);
      robot.delay(500);
      assertTrue(manager.getDirectionLastMoved(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.DOWN);
      robot.keyRelease(KeyEvent.VK_S);
   }

}
