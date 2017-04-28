/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.geom.Point2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author Noah Moss
 */
public class LevelTest
{
   
   public LevelTest()
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
   }
   
   @After
   public void tearDown()
   {
   }

   /**
    * Test of setLevelGrid method, of class Level.
    */
   @Test
   public void testSetLevelGrid()
   {
      System.out.println("setLevelGrid");
      GameSpace.SpaceType[][] levelGrid = null;
      Level instance = new Level();
      instance.setLevelGrid(levelGrid);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getLevelGrid method, of class Level.
    */
   @Test
   public void testGetLevelGrid()
   {
      System.out.println("getLevelGrid");
      Level instance = new Level();
      GameSpace.SpaceType[][] expResult = null;
      GameSpace.SpaceType[][] result = instance.getLevelGrid();
      assertArrayEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of setSnakeOrientations method, of class Level.
    */
   @Test
   public void testSetSnakeOrientations()
   {
      System.out.println("setSnakeOrientations");
      SnakeHead.Orientation[] snakeOrientations = null;
      Level instance = new Level();
      instance.setSnakeOrientations(snakeOrientations);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getSnakeOrientations method, of class Level.
    */
   @Test
   public void testGetSnakeOrientations()
   {
      System.out.println("getSnakeOrientations");
      Level instance = new Level();
      SnakeHead.Orientation[] expResult = null;
      SnakeHead.Orientation[] result = instance.getSnakeOrientations();
      assertArrayEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of setSnakeSpawns method, of class Level.
    */
   @Test
   public void testSetSnakeSpawns()
   {
      System.out.println("setSnakeSpawns");
      Point2D[] snakeSpawns = null;
      Level instance = new Level();
      instance.setSnakeSpawns(snakeSpawns);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getSnakeSpawns method, of class Level.
    */
   @Test
   public void testGetSnakeSpawns()
   {
      System.out.println("getSnakeSpawns");
      Level instance = new Level();
      Point2D[] expResult = null;
      Point2D[] result = instance.getSnakeSpawns();
      assertArrayEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }
   
}
