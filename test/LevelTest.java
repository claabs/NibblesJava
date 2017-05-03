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
    Test of setLevelGrid method, of class Level.
    */
   @Test
   public void testSetLevelGrid()
   {
      System.out.println("setLevelGrid");

      Point2D[] tempSpawns = new Point2D[2];
      GamePanel.CellContents[][] tempGrid = new GamePanel.CellContents[80][48];
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;
      ;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int i = 0; i < tempGrid.length; i++)
         for (int j = 0; j < tempGrid[i].length; j++)
            tempGrid[i][j] = GamePanel.CellContents.EMPTY;

      /*Level instance = new Level();
      assertTrue(instance.equals(new Level()));
      instance.setLevelGrid(tempGrid);
      Level newLevel = new Level(tempGrid, new Snake.Direction[]
      {
         Snake.Direction.RIGHT, Snake.Direction.RIGHT
      }, new Point2D.Double[]
      {
         new Point2D.Double(0, 0), new Point2D.Double(0, 0)
      });
      assertTrue(newLevel.equals(instance));*/
      fail("not done");
   }

   /**
    Test of getLevelGrid method, of class Level.
    */
   @Test
   public void testGetLevelGrid()
   {
      System.out.println("getLevelGrid");

      /*Point2D[] tempSpawns = new Point2D[2];
      GameSpace.SpaceType[][] tempGrid = new GameSpace.SpaceType[80][48];
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;
      ;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int i = 0; i < tempGrid.length; i++)
         for (int j = 0; j < tempGrid[i].length; j++)
            tempGrid[i][j] = GameSpace.SpaceType.EMPTY;

      Level instance = new Level();
      assertTrue(instance.equals(new Level()));
      instance.setLevelGrid(tempGrid);
      Level newLevel = new Level(tempGrid, new Snake.Direction[]
      {
         Snake.Direction.RIGHT,Snake.Direction.RIGHT
      }, new Point2D.Double[]
      {
         new Point2D.Double(0, 0), new Point2D.Double(0, 0)
      });
      assertTrue(newLevel.getLevelGrid().equals(tempGrid));*/
      fail("not done");

   }

   /**
    Test of setSnakeOrientations method, of class Level.
    */
   @Test
   public void testSetSnakeOrientations()
   {
      System.out.println("setSnakeOrientations");

      /*Point2D[] tempSpawns = new Point2D[2];
      GameSpace.SpaceType[][] tempGrid = new GameSpace.SpaceType[80][48];
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;
      ;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int i = 0; i < tempGrid.length; i++)
         for (int j = 0; j < tempGrid[i].length; j++)
            tempGrid[i][j] = GameSpace.SpaceType.EMPTY;

      Level instance = new Level();
      assertTrue(instance.equals(new Level()));
      instance.setSnakeOrientations(tempOrientations);
      Level newLevel = new Level(tempGrid, tempOrientations, new Point2D.Double[]
      {
         new Point2D.Double(0, 0), new Point2D.Double(0, 0)
      });
      assertTrue(newLevel.equals(instance));*/
      fail("not done");
   }

   /**
    Test of getSnakeOrientations method, of class Level.
    */
   @Test
   public void testGetSnakeOrientations()
   {
      System.out.println("getSnakeOrientations");

      /*Point2D[] tempSpawns = new Point2D[2];
      GameSpace.SpaceType[][] tempGrid = new GameSpace.SpaceType[80][48];
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;
      ;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int i = 0; i < tempGrid.length; i++)
         for (int j = 0; j < tempGrid[i].length; j++)
            tempGrid[i][j] = GameSpace.SpaceType.EMPTY;

      Level instance = new Level();
      assertTrue(instance.equals(new Level()));
      instance.setSnakeOrientations(tempOrientations);

      assertTrue(instance.getSnakeOrientations().equals(tempOrientations));*/
      fail("not done");
   }

   /**
    Test of setSnakeSpawns method, of class Level.
    */
   @Test
   public void testSetSnakeSpawns()
   {
      System.out.println("setSnakeSpawns");

      /*Point2D.Double[] tempSpawns = new Point2D.Double[2];
      GameSpace.SpaceType[][] tempGrid = new GameSpace.SpaceType[80][48];
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;
      ;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int i = 0; i < tempGrid.length; i++)
         for (int j = 0; j < tempGrid[i].length; j++)
            tempGrid[i][j] = GameSpace.SpaceType.EMPTY;

      Level instance = new Level();
      assertTrue(instance.equals(new Level()));
      instance.setSnakeSpawns(tempSpawns);
      Level newLevel = new Level(tempGrid, new Snake.Direction[]
      {
         Snake.Direction.RIGHT,Snake.Direction.RIGHT
      }, tempSpawns);
      assertTrue(newLevel.equals(instance));*/
      fail("not done");

   }

   /**
    Test of getSnakeSpawns method, of class Level.
    */
   @Test
   public void testGetSnakeSpawns()
   {
      System.out.println("getSnakeSpawns");

      /*Point2D.Double[] tempSpawns = new Point2D.Double[2];
      GameSpace.SpaceType[][] tempGrid = new GameSpace.SpaceType[80][48];
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;
      ;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int i = 0; i < tempGrid.length; i++)
         for (int j = 0; j < tempGrid[i].length; j++)
            tempGrid[i][j] = GameSpace.SpaceType.EMPTY;

      Level instance = new Level();
      assertTrue(instance.equals(new Level()));
      instance.setSnakeSpawns(tempSpawns);
      assertTrue(instance.getSnakeSpawns().equals(tempSpawns));
      Level newLevel = new Level(tempGrid, new Snake.Direction[]
      {
         Snake.Direction.RIGHT, Snake.Direction.RIGHT
      }, tempSpawns
      );
      assertTrue(newLevel.equals(instance));*/
      fail("not done");

   }

   /**
    Test of equals method, of class Level.
    */
   @Test
   public void testEquals()
   {
      System.out.println("equals");
      /*Object o = null;

      Point2D[] tempSpawns = new Point2D[2];
      GameSpace.SpaceType[][] tempGrid = new GameSpace.SpaceType[80][48];
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;
      ;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int i = 0; i < tempGrid.length; i++)
         for (int j = 0; j < tempGrid[i].length; j++)
            tempGrid[i][j] = GameSpace.SpaceType.EMPTY;

      Level instance = new Level();
      assertTrue(instance.equals(new Level()));
      instance.setSnakeOrientations(tempOrientations);
      Level newLevel = new Level(tempGrid, tempOrientations, new Point2D.Double[]
      {
         new Point2D.Double(0, 0), new Point2D.Double(0, 0)
      });
      assertFalse(instance.equals(o));
      assertTrue(newLevel.equals(instance));
      assertFalse(newLevel.equals(new Level()));*/
      fail("not done");
   }

   /**
    * Test of getStartingDirections method, of class Level.
    */
   @Test
   public void testGetStartingDirections()
   {
      System.out.println("getStartingDirections");
      Level instance = null;
      Snake.Direction[] expResult = null;
      Snake.Direction[] result = instance.getStartingDirections();
      assertArrayEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getSpawnPoints method, of class Level.
    */
   @Test
   public void testGetSpawnPoints()
   {
      System.out.println("getSpawnPoints");
      Level instance = null;
      Point2D.Double[] expResult = null;
      Point2D.Double[] result = instance.getSpawnPoints();
      assertArrayEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of getLevelNumber method, of class Level.
    */
   @Test
   public void testGetLevelNumber()
   {
      System.out.println("getLevelNumber");
      Level instance = null;
      int expResult = 0;
      int result = instance.getLevelNumber();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

   /**
    * Test of hashCode method, of class Level.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("hashCode");
      Level instance = null;
      int expResult = 0;
      int result = instance.hashCode();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      fail("The test case is a prototype.");
   }

}
