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

   Level instance;

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

   private Snake.Direction[] spawnDirections;
   private Point2D.Double[] tempSpawns;
   private Collidable[][] tempGrid;

   @Before
   public void setUp()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];

      Collidable[][] newGrid = new Collidable[LevelConstructor.WIDTH][LevelConstructor.HEIGHT];
      //Create 4 walls
      for (int row = 0; row < 48; row++)
         newGrid[0][row] = new Wall(new Point2D.Double(0, row));
      for (int row = 0; row < 48; row++)
         newGrid[79][row] = new Wall(new Point2D.Double(79, row));
      for (int col = 0; col < 80; col++)
         newGrid[col][0] = new Wall(new Point2D.Double(col, 0));
      for (int col = 0; col < 80; col++)
         newGrid[col][47] = new Wall(new Point2D.Double(col, 47));
      //Fill inside with empty
      for (int col = 1; col < 79; col++)
         for (int row = 1; row < 47; row++)
            newGrid[col][row] = new EmptyCell(new Point2D.Double(col, row));
      tempGrid = newGrid;

      spawnDirections[0] = Snake.Direction.RIGHT;
      spawnDirections[1] = Snake.Direction.LEFT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(49, 22);
      tempSpawns[1] = new Point2D.Double(29, 22);
      instance = new Level(tempGrid, spawnDirections, tempSpawns, 1);
   }

   @After
   public void tearDown()
   {
   }

   /**
    Test of getLevelGrid method, of class Level.
    */
   @Test
   public void testGetLevelGrid()
   {
      System.out.println("getLevelGrid");
      LevelConstructor lc = new LevelConstructor();
      Collidable[][] lg = lc.getLevel(0).getLevelGrid();

      //assertTrue(instance.getLevelGrid().equals(lg));
      
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
    Test of getStartingDirections method, of class Level.
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
    Test of getSpawnPoints method, of class Level.
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
    Test of getLevelNumber method, of class Level.
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
    Test of hashCode method, of class Level.
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
