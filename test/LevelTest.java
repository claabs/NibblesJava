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
      System.out.println("Level:getLevelGrid");
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

      Collidable[][] instanceGrid = instance.getLevelGrid();
      boolean result = true;
      for (int i = 0; i < newGrid.length; i++)
         for (int j = 0; j < newGrid[i].length; j++)
            if (instanceGrid[i][j].getClass() != newGrid[i][j].getClass())
               result = false;
      assertTrue(result);

   }

   /**
    Test of equals method, of class Level.
    */
   @Test
   public void testEquals()
   {
      System.out.println("Level:equals");
      assertTrue(instance.equals(new LevelConstructor().getLevel(0)));
      assertFalse(instance.equals(new Level()));
      assertFalse(instance.equals(null));
   }

   /**
    Test of getStartingDirections method, of class Level.
    */
   @Test
   public void testGetStartingDirections()
   {
      System.out.println("Level:getStartingDirections");
      assertTrue(instance.getStartingDirections().equals(spawnDirections));
   }

   /**
    Test of getSpawnPoints method, of class Level.
    */
   @Test
   public void testGetSpawnPoints()
   {
      System.out.println("Level:getSpawnPoints");
      assertTrue(instance.getSpawnPoints().equals(tempSpawns));
   }

   /**
    Test of getLevelNumber method, of class Level.
    */
   @Test
   public void testGetLevelNumber()
   {
      System.out.println("Level:getLevelNumber");
      LevelConstructor lc = new LevelConstructor();
      for (int i = 0; i < 10; i++)
         assertTrue(i + 1 == lc.getLevel(i).getLevelNumber());
   }

   /**
    Test of hashCode method, of class Level.
    */
   @Test
   public void testHashCode()
   {
      System.out.println("Level:hashCode");
      LevelConstructor lc = new LevelConstructor();
      for (int i = 0; i < 10; i++)
         assertTrue(lc.getLevel(i).hashCode() != 0);
   }

}
