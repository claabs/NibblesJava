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
public class LevelConstructorTest
{

   public LevelConstructorTest()
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
    Test of getLevel method, of class LevelConstructor.
    */
   @Test
   public void testGetLevel()
   {
      System.out.println("getLevel");
      LevelConstructor instance = new LevelConstructor();
      Snake.Direction[] tempOrientations = new Snake.Direction[2];
      Point2D.Double[] tempSpawns = new Point2D.Double[2];
      Collidable[][] tempGrid = new Collidable[LevelConstructor.WIDTH][LevelConstructor.HEIGHT];
      
      tempOrientations[0] = Snake.Direction.RIGHT;
      tempOrientations[1] = Snake.Direction.LEFT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(49, 22);
      tempSpawns[1] = new Point2D.Double(29, 22);

       
      //Create 4 walls
      for (int row = 0; row < 48; row++)
         tempGrid[0][row] = new Wall(new Point2D.Double(0, row));
      for (int row = 0; row < 48; row++)
         tempGrid[79][row] = new Wall(new Point2D.Double(79, row));
      for (int col = 0; col < 80; col++)
         tempGrid[col][0] = new Wall(new Point2D.Double(col, 0));
      for (int col = 0; col < 80; col++)
         tempGrid[col][47] = new Wall(new Point2D.Double(col, 47));
      //Fill inside with empty
      for (int col = 1; col < 79; col++)
         for (int row = 1; row < 47; row++)
            tempGrid[col][row] = new EmptyCell(new Point2D.Double(col, row));

      Level level = new Level(tempGrid, tempOrientations, tempSpawns, 1);
      assertTrue(level.equals(instance.getLevel(0)));
   }

}
