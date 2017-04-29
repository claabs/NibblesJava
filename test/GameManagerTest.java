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

 @author Noah Moss
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
      instance.pause();
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
      instance.unpause();
      Thread.sleep(2500);
   }

   /**
    Test of isPaused method, of class GameManager.
    */
   @Test
   public void testIsPaused() throws InterruptedException
   {
      System.out.println("isPaused");
      instance.pause();
      Thread.sleep(2500);
      assertTrue(instance.isPaused());
      instance.unpause();
      Thread.sleep(2500);
      assertFalse(instance.isPaused());
   }

   /**
    Test of setPlayerDirection method, of class GameManager.
    */
   @Test
   public void testSetPlayerDirection()
   {
      System.out.println("setSnakeDirection");
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.RIGHT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.LEFT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.DOWN);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.DOWN);

      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.RIGHT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.LEFT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.DOWN);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.DOWN);
   }

   /**
    Test of getSnakeDirection method, of class GameManager.
    */
   @Test
   public void testGetSnakeDirection()
   {
      System.out.println("getSnakeDirection");
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.RIGHT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.LEFT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.DOWN);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.DOWN);

      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.RIGHT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.LEFT);
      instance.setPlayerDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.DOWN);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.DOWN);
   }

   /**
    Test of getSnakes method, of class GameManager.
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
      assertTrue(new Snake(new Point2D.Double(20, 20), Snake.Direction.UP).equals(result[0]));
   }

   /**
    Test of getFood method, of class GameManager.
    */
   @Test
   public void testGetFood()
   {
      System.out.println("getFood");
      assertTrue(instance.getFood().equals(new Food(1, new Point2D.Double(30, 30))));
   }

   /**
    Test of getNumberOfPlayers method, of class GameManager.
    */
   @Test
   public void testGetNumberOfPlayers()
   {
      System.out.println("getNumberOfPlayers");
      assertTrue(instance.getNumberOfPlayers() == 1);
   }

   /**
    Test of getPlayerLives method, of class GameManager.
    */
   @Test
   public void testGetPlayerLives()
   {
      System.out.println("getPlayerLives");
      assertTrue(instance.getPlayerLives(GameManager.playerEnum.PLAYER_ONE) == 5);
   }

   /**
    Test of getPlayerScore method, of class GameManager.
    */
   @Test
   public void testGetPlayerScore()
   {
      System.out.println("getPlayerScore");
      assertTrue(instance.getPlayerScore(GameManager.playerEnum.PLAYER_ONE) == 0);
   }

   /**
    Test of getLevel method, of class GameManager.
    */
   @Test
   public void testGetLevel()
   {
      System.out.println("getLevel");
      assertTrue(instance.getLevel() == null);
   }

}
