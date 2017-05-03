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
public class GameTest
{

   private JFrame window;
   private Lock sequential = new ReentrantLock();
   private long startTime;
   private GameManager manager;
   private Robot robot;

   public GameTest()
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
      startTime = System.nanoTime();
      sequential.lock();
      window = new JFrame();
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      manager = new GameManager(window, 5);
      robot = new Robot();
   }

   @After
   public void tearDown()
   {
      sequential.unlock();
   }

   private void startGame(int numPlayers, int skillLevel, boolean increaseSpeed, boolean color)
   {
      int delay = 50;
      robot.delay(100);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(delay);
      robot.keyRelease(KeyEvent.VK_SPACE);
      robot.delay(delay);
      int keyToPress;
      if (numPlayers == 1)
         keyToPress = KeyEvent.VK_1;
      else
         keyToPress = KeyEvent.VK_2;
      robot.keyPress(keyToPress);
      robot.delay(delay);
      robot.keyRelease(keyToPress);
      robot.delay(delay);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(delay);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(delay);
      //SetSkillHere
      robot.keyPress(KeyEvent.VK_1);
      robot.delay(delay);
      robot.keyRelease(KeyEvent.VK_1);
      robot.delay(delay);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(delay);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(delay);
      if (increaseSpeed)
         keyToPress = KeyEvent.VK_Y;
      else
         keyToPress = KeyEvent.VK_N;
      robot.keyPress(keyToPress);
      robot.delay(delay);
      robot.keyRelease(keyToPress);
      robot.delay(delay);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(delay);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(delay);
      if (color)
         keyToPress = KeyEvent.VK_C;
      else
         keyToPress = KeyEvent.VK_M;
      robot.keyPress(keyToPress);
      robot.delay(delay);
      robot.keyRelease(keyToPress);
      robot.delay(delay);
      robot.keyPress(KeyEvent.VK_ENTER);
      robot.delay(delay);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(200);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(delay);
      robot.keyRelease(KeyEvent.VK_SPACE);
   }

   private void pressKey(int k)
   {
      robot.keyPress(k);
      robot.keyRelease(k);
   }

   int P1L = KeyEvent.VK_LEFT;
   int P1R = KeyEvent.VK_RIGHT;
   int P1U = KeyEvent.VK_UP;
   int P1D = KeyEvent.VK_DOWN;
   int P2L = KeyEvent.VK_A;
   int P2R = KeyEvent.VK_D;
   int P2U = KeyEvent.VK_W;
   int P2D = KeyEvent.VK_S;

   /**
    Test of keyPressed method, of class KeyboardListener.
    */
   @Test
   public void testGame()
   {
      int gameRate = 55;
      System.out.println("keyPressed");
      startGame(2, 1, false, true);
      while (manager.getCurrentState() != GameManager.eventEnum.gameplayScreen);
      pressKey(P1U);
      pressKey(P2U);
      pressKey(P2R);
      robot.delay(gameRate * 19);
      pressKey(P1R);
      robot.delay(gameRate * 9);
      pressKey(P1D);
      pressKey(P1L);
      pressKey(P2D);
      pressKey(P2L);
      robot.delay(gameRate * 22);
      pressKey(P2D);
      robot.delay(gameRate * 2);
      pressKey(P1D);
      robot.delay(gameRate * 12);
      pressKey(P2L);
      robot.delay(gameRate * 5);
      pressKey(P1L);
      pressKey(P1D);
      robot.delay(gameRate * 9);
      pressKey(P1L);

      robot.delay(gameRate * 5);
      pressKey(P2D);
      robot.delay(gameRate*7);
      pressKey(P1U);
      pressKey(P2R);
            
      robot.delay(gameRate*18);
      pressKey(P1R);
      
      robot.delay(gameRate*15);
      pressKey(P2U);
      
      robot.delay(6000);
      pressKey(KeyEvent.VK_P);
      /*robot.delay(250);
      robot.keyPress(KeyEvent.VK_LEFT);
      robot.delay(250);
      //Test P1 left
      robot.keyRelease(KeyEvent.VK_LEFT);*/
 /*
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

      for (int i = 0; i < 5; i++)
      {
         robot.delay(2000);
         System.out.println("pressing space");
         robot.keyPress(KeyEvent.VK_SPACE);
         robot.delay(250);
         robot.keyRelease(KeyEvent.VK_SPACE);
      }

      robot.delay(250);
      robot.keyPress(KeyEvent.VK_Y);
      robot.delay(250);
      robot.keyRelease(KeyEvent.VK_Y);
      System.out.println("Verify Game restarted");
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(250);
      robot.keyRelease(KeyEvent.VK_SPACE);

      for (int i = 0; i < 5; i++)
      {
         robot.delay(2000);
         System.out.println("pressing space");
         robot.keyPress(KeyEvent.VK_SPACE);
         robot.delay(250);
         robot.keyRelease(KeyEvent.VK_SPACE);
      }
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_SPACE);
      robot.delay(250);
      robot.keyRelease(KeyEvent.VK_SPACE);
      System.out.println("Verify Game closes");
      robot.delay(250);
      robot.keyPress(KeyEvent.VK_N);
      robot.delay(250);
      robot.keyRelease(KeyEvent.VK_N);
      assertTrue(true);//If it got here it passed
       */
   }

}
