/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.geom.Point2D;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Noah Moss
 */
public class GameManagerTest
{

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
      instance = new GameManager(window);
   }

   @After
   public void tearDown()
   {
   }

   /**
    * Test of run method, of class GameManager.
    */
   @Test
   public void testRun() throws InterruptedException
   {
      System.out.println("run");
      System.out.println("Verify running.");
      Thread.sleep(2500);
   }

   /**
    * Test of pause method, of class GameManager.
    */
   @Test
   public void testPause() throws InterruptedException
   {
      System.out.println("pause");
      System.out.println("Verify \"Pause\" screen is showing.");
      instance.pause();
      Thread.sleep(2500);
   }

   /**
    * Test of unpause method, of class GameManager.
    */
   @Test
   public void testUnpause() throws InterruptedException
   {
      System.out.println("unpause");
      System.out.println("Verify \"Pause\" screen is no longer showing.");
      instance.unpause();
      Thread.sleep(2500);
   }

   /**
    * Test of getSnakes method, of class GameManager.
    */
   @Test
   public void testGetSnakes()
   {
      System.out.println("getSnakes");
      /*
      Snake[] expectedSnakes = new Snake[]
      {
         new Snake(new Point2D.Double(20, 20), Snake.Direction.UP),
         new Snake(new Point2D.Double(40, 40), Snake.Direction.UP)
      };
      Snake[] result = instance.getSnakes();
      assertTrue(expectedSnakes.length == result.length);
      for (int i = 0; i < expectedSnakes.length; i++)
         assertTrue(expectedSnakes[i].equals(result[i]));
       */
      Snake[] result = instance.getSnakes();
      assertTrue(new Snake(new Point2D.Double(20, 20), Snake.Direction.UP, 0).equals(result[0]));
   }

   /**
    * Test of getFood method, of class GameManager.
    */
   @Test
   public void testGetFood()
   {
      System.out.println("getFood");
      assertTrue(instance.getFood().equals(new Food(1, new Point2D.Double(30, 30), 0)));
   }

   /**
    * Test of getNumberOfPlayers method, of class GameManager.
    */
   @Test
   public void testGetNumberOfPlayers()
   {
      System.out.println("getNumberOfPlayers");
      instance.setNumberOfPlayers(1);
      assertTrue(instance.getNumberOfPlayers() == 1);
   }

   /**
    * Test of getLevel method, of class GameManager.
    */
   @Test
   public void testGetLevel()
   {
      System.out.println("getLevel");
      assertTrue(instance.getLevel() == null);
   }

   /**
    * Test of setNumberOfPlayers method, of class GameManager.
    */
   @Test
   public void testSetNumberOfPlayers()
   {
      System.out.println("setNumberOfPlayers");
      int inNumberOfPlayers = 1;
      instance.setNumberOfPlayers(inNumberOfPlayers);
      boolean result = inNumberOfPlayers == instance.getNumberOfPlayers();
      assertTrue(result);
   }

   /**
    * Test of getSkill method, of class GameManager.
    */
   @Test
   public void testGetSkill()
   {
      System.out.println("getSkill");
      instance.setSkill(1);
      int expResult = 1;
      int result = instance.getSkill();
      assertEquals(expResult, result);
   }

   /**
    * Test of setSkill method, of class GameManager.
    */
   @Test
   public void testSetSkill()
   {
      System.out.println("setSkill");
      int inSkill = 0;
      GameManager instance = null;
      instance.setSkill(inSkill);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getCurrentState method, of class GameManager.
    */
   @Test
   public void testGetCurrentState()
   {
      System.out.println("getCurrentState");
      boolean expResult = true;
      boolean result = instance.getCurrentState()
         == GameManager.eventEnum.introScreen;
      assertEquals(expResult, result);
   }

   /**
    * Test of getIncreaseSpeed method, of class GameManager.
    */
   @Test
   public void testGetIncreaseSpeed()
   {
      System.out.println("getIncreaseSpeed");
      GameManager instance = null;
      boolean expResult = false;
      boolean result = instance.getIncreaseSpeed();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of setIncreaseSpeed method, of class GameManager.
    */
   @Test
   public void testSetIncreaseSpeed()
   {
      System.out.println("setIncreaseSpeed");
      boolean inIncreaseSpeed = false;
      GameManager instance = null;
      instance.setIncreaseSpeed(inIncreaseSpeed);
      boolean result = instance.getIncreaseSpeed() == inIncreaseSpeed;
      assertTrue(result); 
   }

   /**
    * Test of getMonochrome method, of class GameManager.
    */
   @Test
   public void testGetMonochrome()
   {
      System.out.println("getMonochrome");
      instance.setMonochrome(true);
      boolean result = instance.getMonochrome();
      assertTrue(result);
   }

   /**
    * Test of setMonochrome method, of class GameManager.
    */
   @Test
   public void testSetMonochrome()
   {
      System.out.println("setMonochrome");
      instance.setMonochrome(true);
      boolean result = instance.getMonochrome();
      assertTrue(result);
   }

   /**
    * Test of restart method, of class GameManager.
    */
   @Test
   public void testRestart()
   {
      System.out.println("restart");
      
      instance.restart();
      boolean result = instance.getCurrentState() == GameManager.eventEnum.startOfLevel;
    assertTrue(result);
   }

   /**
    * Test of progressState method, of class GameManager.
    */
   @Test
   public void testProgressState()
   {
      System.out.println("progressState");
      instance.getCurrentState();
      // Game Manager starts with currentState = eventEnum.introScreen
      instance.progressState();
      // this will change the current state to numberOfPlayersScreen

      boolean expResult = true;
      boolean result = instance.getCurrentState()
         == GameManager.eventEnum.numberOfPlayersScreen;
      assertEquals(expResult, result);
   }

   /**
    * Test of getLastDeath method, of class GameManager.
    */
   @Test
   public void testGetLastDeath()
   {
      System.out.println("getLastDeath");
      instance.getLastDeath();
      int expResult = 0;
      boolean result = instance.getLastDeath() == expResult;
      assertFalse(result);
   }

}
