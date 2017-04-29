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

   private static final int CELL_SIZE = 15;
   private static final int WIDTH = 80;
   private static final int HEIGHT = 50;
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
      instance = new GameManager(window, WIDTH, HEIGHT, CELL_SIZE);
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
    Test of isPaused method, of class GameManager.
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

   /**
    Test of setSnakeDirection method, of class GameManager.
    */
   @Test
   public void testSetSnakeDirection()
   {
      System.out.println("setSnakeDirection");
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.RIGHT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.LEFT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.DOWN);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.DOWN);

      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.RIGHT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.LEFT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.DOWN);
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
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.RIGHT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.UP);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.LEFT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_ONE, Snake.Direction.DOWN);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_ONE) == Snake.Direction.DOWN);

      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.RIGHT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.RIGHT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.UP);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.UP);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.LEFT);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.LEFT);
      instance.setSnakeDirection(GameManager.playerEnum.PLAYER_TWO, Snake.Direction.DOWN);
      assertTrue(instance.getSnakeDirection(GameManager.playerEnum.PLAYER_TWO) == Snake.Direction.DOWN);
   }

   /**
    Test of getSnakes method, of class GameManager.
    */
   @Test
   public void testGetSnakes()
   {
      System.out.println("getSnakes");
      Snake[] expectedSnakes = new Snake[]
      {
         new Snake(new Point2D.Double(20, 20), Snake.Direction.UP),
         new Snake(new Point2D.Double(40, 40), Snake.Direction.UP)
      };
      Snake[] result = instance.getSnakes();
      assertTrue(expectedSnakes.length == result.length);
      for (int i = 0; i < expectedSnakes.length; i++)
         assertTrue(expectedSnakes[i].equals(result[i]));
   }

   /**
    Test of getFood method, of class GameManager.
    */
   @Test
   public void testGetFood()
   {
      System.out.println("getFood");
      assertTrue(instance.getFood().equals(new Food(2, new Point2D.Double(30, 30))));
   }

}
