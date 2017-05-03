
import java.awt.geom.Point2D;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles the actual creation of each level.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class LevelConstructor
{

   public static final int HEIGHT = 48;
   public static final int WIDTH = 80;
   private static final int NUM_LEVELS = 10;
   private final Level[] levelList = new Level[NUM_LEVELS];

   private Snake.Direction[] spawnDirections = new Snake.Direction[2];
   private Point2D.Double[] tempSpawns = new Point2D.Double[2];
   private Collidable[][] tempGrid = new Collidable[WIDTH][HEIGHT];

   /**
    NOTE: On old NIBBLES code: 1 = UP, 2 = DOWN, 3 = LEFT, 4 = RIGHT

    Subtract 3 from old NIBBLES row due to scoreboard. Subtract 1 from old
    NIBBLES column due to walls.

    Board is 80 wide by 48 tall including red border wall
    */
   
   /**
   This constructor constructs an array of new levels; namely, levels 1-10.
   */
   public LevelConstructor()
   {
      levelList[0] = createLevel1();
      levelList[1] = createLevel2();
      levelList[2] = createLevel3();
      levelList[3] = createLevel4();
      levelList[4] = createLevel5();
      levelList[5] = createLevel6();
      levelList[6] = createLevel7();
      levelList[7] = createLevel8();
      levelList[8] = createLevel9();
      levelList[9] = createLevel10();
   }

   /**
   This method returns the level from the level list array specified by the 
   level index.
   
   @param levelIndex Index of the level list array.
   
   @return Level from the level list array specified by the level index.
   */
   public Level getLevel(int levelIndex)
   {
      return levelList[levelIndex];
   }

   /**
   This method will create a blank level with the accompanying bordering walls.
   */
   private Collidable[][] createBlankLevelWithWalls()
   {
       Collidable[][] newGrid = new Collidable[WIDTH][HEIGHT];
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
            tempGrid[col][row] = new EmptyCell(new Point2D.Double(col, row));
      return newGrid;
   }

   /**
   This method will create level 1 for Nibbles.
   
   @return Newly created level; namely, level 1.
   */
   private Level createLevel1()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.RIGHT;
      spawnDirections[1] = Snake.Direction.LEFT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(49, 22);
      tempSpawns[1] = new Point2D.Double(29, 22);

      return new Level(tempGrid, spawnDirections, tempSpawns, 1);
   }

   /**
   This method will create level 2 for Nibbles.
   
   @return Newly created level; namely, level 2.
   */
   private Level createLevel2()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.LEFT;
      spawnDirections[1] = Snake.Direction.RIGHT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(59, 4);
      tempSpawns[1] = new Point2D.Double(19, 40);

      for (int col = 19; col <= 59; col++)
         tempGrid[col][22] = new Wall(new Point2D.Double(col, 22));
      return new Level(tempGrid, spawnDirections, tempSpawns, 2);
   }

   /**
   This method will create level 3 for Nibbles.
   
   @return Newly created level; namely, level 3.
   */
   private Level createLevel3()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.UP;
      spawnDirections[1] = Snake.Direction.DOWN;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(51, 22);
      tempSpawns[1] = new Point2D.Double(31, 22);

      for (int row = 7; row <= 37; row++)
      {
         tempGrid[19][row] = new Wall(new Point2D.Double(19, row));
         tempGrid[59][row] = new Wall(new Point2D.Double(59, row));
      }
      return new Level(tempGrid, spawnDirections, tempSpawns,3);
   }

   /**
   This method will create level 4 for Nibbles.
   
   @return Newly created level; namely, level 4.
   */
   private Level createLevel4()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.LEFT;
      spawnDirections[1] = Snake.Direction.RIGHT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(59, 4);
      tempSpawns[1] = new Point2D.Double(19, 40);

      for (int row = 1; row <= 27; row++)
      {
         tempGrid[19][row] = new Wall(new Point2D.Double(19, row));
         tempGrid[59][47 - row] = new Wall(new Point2D.Double(59, 47 - row));
      }
      for (int col = 1; col <= 39; col++)
      {
         tempGrid[col][35] = new Wall(new Point2D.Double(col, 35));
         tempGrid[80 - col][12] = new Wall(new Point2D.Double(80 - col, 12));
      }
      return new Level(tempGrid, spawnDirections, tempSpawns,4);
   }

   /**
   This method will create level 5 for Nibbles.
   
   @return Newly created level; namely, level 5.
   */
   private Level createLevel5()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.UP;
      spawnDirections[1] = Snake.Direction.DOWN;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(49, 22);
      tempSpawns[1] = new Point2D.Double(29, 22);

      for (int row = 10; row <= 36; row++)
      {
         tempGrid[20][row] = new Wall(new Point2D.Double(20, row));
         tempGrid[58][row] = new Wall(new Point2D.Double(58, row));
      }
      for (int col = 22; col <= 56; col++)
      {
         tempGrid[col][8] = new Wall(new Point2D.Double(col, 8));
         tempGrid[col][38] = new Wall(new Point2D.Double(col, 38));
      }
      return new Level(tempGrid, spawnDirections, tempSpawns,5);
   }

   /**
   This method will create level 6 for Nibbles.
   
   @return Newly created level; namely, level 6.
   */
   private Level createLevel6()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.DOWN;
      spawnDirections[1] = Snake.Direction.UP;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(65, 5);
      tempSpawns[1] = new Point2D.Double(15, 41);

      for (int row = 1; row <= 46; row++)
         if (row > 27 || row < 20)
         {
            tempGrid[9][row] = new Wall(new Point2D.Double(9, row));
            tempGrid[19][row] = new Wall(new Point2D.Double(19, row));
            tempGrid[29][row] = new Wall(new Point2D.Double(29, row));
            tempGrid[39][row] = new Wall(new Point2D.Double(39, row));
            tempGrid[49][row] = new Wall(new Point2D.Double(49, row));
            tempGrid[59][row] = new Wall(new Point2D.Double(59, row));
            tempGrid[69][row] = new Wall(new Point2D.Double(69, row));
         }
      return new Level(tempGrid, spawnDirections, tempSpawns,6);
   }

   /**
   This method will create level 7 for Nibbles.
   
   @return Newly created level; namely, level 7.
   */
   private Level createLevel7()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.DOWN;
      spawnDirections[1] = Snake.Direction.UP;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(64, 4);
      tempSpawns[1] = new Point2D.Double(14, 40);

      for (int row = 1; row <= 46; row += 2)
         tempGrid[39][row] = new Wall(new Point2D.Double(39, row));
      return new Level(tempGrid, spawnDirections, tempSpawns,7);
   }

   /**
   This method will create level 8 for Nibbles.
   
   @return Newly created level; namely, level 8.
   */
   private Level createLevel8()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.DOWN;
      spawnDirections[1] = Snake.Direction.UP;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(64, 4);
      tempSpawns[1] = new Point2D.Double(14, 40);

      for (int row = 1; row <= 37; row++)
      {
         tempGrid[9][row] = new Wall(new Point2D.Double(9, row));
         tempGrid[19][47 - row] = new Wall(new Point2D.Double(19, 47 - row));
         tempGrid[29][row] = new Wall(new Point2D.Double(29, 22));
         tempGrid[39][47 - row] = new Wall(new Point2D.Double(39, 47 - row));
         tempGrid[49][row] = new Wall(new Point2D.Double(49, 22));
         tempGrid[59][47 - row] = new Wall(new Point2D.Double(59, 47 - row));
         tempGrid[69][row] = new Wall(new Point2D.Double(69, 22));
      }
      return new Level(tempGrid, spawnDirections, tempSpawns,8);
   }

   /**
   This method will create level 9 for Nibbles.
   
   @return Newly created level; namely, level 9.
   */
   private Level createLevel9()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.UP;
      spawnDirections[1] = Snake.Direction.DOWN;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(74, 37);
      tempSpawns[1] = new Point2D.Double(4, 12);

      for (int row = 3; row <= 44; row++)
      {
         tempGrid[row + 2][row] = new Wall(new Point2D.Double(row + 2, row));
         tempGrid[row + 29][row] = new Wall(new Point2D.Double(row + 29, row));
      }
      return new Level(tempGrid, spawnDirections, tempSpawns,9);
   }

   /**
   This method will create level 10 for Nibbles.
   
   @return Newly created level; namely, level 10.
   */
   private Level createLevel10()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = createBlankLevelWithWalls();

      spawnDirections[0] = Snake.Direction.DOWN;
      spawnDirections[1] = Snake.Direction.UP;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(64, 4);
      tempSpawns[1] = new Point2D.Double(14, 40);

      for (int row = 1; row <= 46; row += 2)
      {
         tempGrid[9][row] = new Wall(new Point2D.Double(9, row));
         tempGrid[19][row + 1] = new Wall(new Point2D.Double(19, row + 1));
         tempGrid[29][row] = new Wall(new Point2D.Double(29, row));
         tempGrid[39][row + 1] = new Wall(new Point2D.Double(39, row + 1));
         tempGrid[49][row] = new Wall(new Point2D.Double(49, row));
         tempGrid[59][row + 1] = new Wall(new Point2D.Double(59, row + 1));
         tempGrid[69][row] = new Wall(new Point2D.Double(69, row));
      }
      return new Level(tempGrid, spawnDirections, tempSpawns,10);
   }
}
