/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.*;
import org.junit.*;
import static org.junit.Assert.*;

/**

 @author Noah Moss
 */
public class KeyboardListenerTest
{

   private JFrame window;
   private Lock sequential = new ReentrantLock();

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
      sequential.lock();
      window = new JFrame();
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      manager = new GameManager(window);
      robot = new Robot();
   }

   @After
   public void tearDown()
   {
      sequential.unlock();
   }

   private void startGame(int numPlayers, int skillLevel, boolean increaseSpeed, boolean color)
   {
      robot.delay(1000);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(100);
      robot.keyRelease(KeyEvent.VK_SPACE);
      robot.delay(100);
      int keyToPress;
      if (numPlayers == 1)
         keyToPress = KeyEvent.VK_1;
      else
         keyToPress = KeyEvent.VK_2;
      robot.keyPress(keyToPress);
      robot.delay(100);
      robot.keyRelease(keyToPress);
      robot.delay(100);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(100);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(100);
      //SetSkillHere
      robot.keyPress(KeyEvent.VK_1);
      robot.delay(100);
      robot.keyRelease(KeyEvent.VK_1);
      robot.delay(100);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(100);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(100);
      if (increaseSpeed)
         keyToPress = KeyEvent.VK_Y;
      else
         keyToPress = KeyEvent.VK_N;
      robot.keyPress(keyToPress);
      robot.delay(100);
      robot.keyRelease(keyToPress);
      robot.delay(100);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(100);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(100);
      if (color)
         keyToPress = KeyEvent.VK_C;
      else
         keyToPress = KeyEvent.VK_M;
      robot.keyPress(keyToPress);
      robot.delay(100);
      robot.keyRelease(keyToPress);
      robot.delay(100);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(100);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(100);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(100);
      robot.keyRelease(KeyEvent.VK_SPACE);
   }

   /**
    Test of keyPressed method, of class KeyboardListener.
    */
   @Test
   public void testKeyPressed()
   {
      System.out.println("keyPressed");
      startGame(2, 1, false, true);
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_P);
      robot.delay(250);
      System.out.println("Verify game is paused.");
      robot.keyRelease(KeyEvent.VK_P);

      robot.delay(250);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(250);
      System.out.println("Verify game is not paused.");
      robot.keyRelease(KeyEvent.VK_SPACE);

      robot.delay(250);
      robot.keyPress(KeyEvent.VK_UP);
      robot.delay(250);
      //Test P1 up
      robot.keyRelease(KeyEvent.VK_UP);
      
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_S);
      robot.delay(250);
      //Test P2 down
      robot.keyRelease(KeyEvent.VK_S);
      
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_LEFT);
      robot.delay(250);
      //Test P1 left
      robot.keyRelease(KeyEvent.VK_LEFT);
      
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_D);
      robot.delay(250);
      //Test P2 right
      robot.keyRelease(KeyEvent.VK_D);
      
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_DOWN);
      robot.delay(250);
      //Test P1 down
      robot.keyRelease(KeyEvent.VK_DOWN);
      
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_W);
      robot.delay(250);
      //Test P2 up
      robot.keyRelease(KeyEvent.VK_W);
      
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_RIGHT);
      robot.delay(250);
      //Test P1 right
      robot.keyRelease(KeyEvent.VK_RIGHT);

      robot.delay(250);
      robot.keyPress(KeyEvent.VK_A);
      robot.delay(250);
      //Test P2 left
      robot.keyRelease(KeyEvent.VK_A);

   }

}
