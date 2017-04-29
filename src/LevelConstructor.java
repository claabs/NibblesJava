
import java.awt.geom.Point2D;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class LevelConstructor
{

   public static final int HEIGHT = 48;
   public static final int WIDTH = 80;
   private static final int NUM_LEVELS = 9;
   private Level[] levelList = new Level[NUM_LEVELS];

   Snake.Direction[] spawnDirections = new Snake.Direction[2];
   Point2D.Double[] tempSpawns = new Point2D.Double[2];
   GamePanel.CellContents[][] tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];

   /**
    NOTE: On old NIBBLES code: 1 = UP, 2 = DOWN, 3 = LEFT, 4 = RIGHT

    Subtract 3 from old NIBBLES row due to scoreboard.
    Subtract 1 from old NIBBLES column due to walls.
   
    Board is 80 wide by 48 tall including red border wall
    */
   LevelConstructor()
   {
      levelList[0] = createLevel0();
      levelList[1] = createLevel1();
      levelList[2] = createLevel2();
      levelList[3] = createLevel3();
      levelList[4] = createLevel4();
      levelList[5] = createLevel5();
   }

   public Level getLevel(int levelIndex)
   {
      return levelList[levelIndex];
   }

   private void createBorderWalls(GamePanel.CellContents[][] grid)
   {
      //Create 4 walls
      for (int row = 0; row < 48; row++)
      {
         grid[0][row] = GamePanel.CellContents.WALL;
      }
      for (int row = 0; row < 48; row++)
      {
         grid[79][row] = GamePanel.CellContents.WALL;
      }
      for (int col = 0; col < 80; col++)
      {
         grid[col][0] = GamePanel.CellContents.WALL;
      }
      for (int col = 0; col < 80; col++)
      {
         grid[col][47] = GamePanel.CellContents.WALL;
      }
      //Fill inside with empty
      for (int col = 1; col < 79; col++)
      {
         for (int row = 1; row < 47; row++)
         {
            tempGrid[col][row] = GamePanel.CellContents.EMPTY;
         }
      }
   }

   private Level createLevel0()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.RIGHT;
      spawnDirections[1] = Snake.Direction.LEFT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(49, 22);
      tempSpawns[1] = new Point2D.Double(49, 22);

      return new Level(tempGrid, spawnDirections, tempSpawns);
   }

   private Level createLevel1()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.LEFT;
      spawnDirections[1] = Snake.Direction.RIGHT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(59, 4);
      tempSpawns[1] = new Point2D.Double(19, 40);

      for (int col = 19; col <= 59; col++)
      {
         tempGrid[col][22] = GamePanel.CellContents.WALL;
      }
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }

   private Level createLevel2()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.UP;
      spawnDirections[1] = Snake.Direction.DOWN;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(51, 22);
      tempSpawns[1] = new Point2D.Double(31, 22);

      for (int row = 7; row <= 37; row++)
      {
         tempGrid[19][row] = GamePanel.CellContents.WALL;
         tempGrid[59][row] = GamePanel.CellContents.WALL;
      }
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }

   private Level createLevel3()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.LEFT;
      spawnDirections[1] = Snake.Direction.RIGHT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(59, 4);
      tempSpawns[1] = new Point2D.Double(19, 40);

      for (int row = 1; row <= 27; row++)
      {
         tempGrid[19][row] = GamePanel.CellContents.WALL;
         tempGrid[59][47 - row] = GamePanel.CellContents.WALL;
      }
      for (int col = 1; col <= 39; col++)
      {
         tempGrid[col][35] = GamePanel.CellContents.WALL;
         tempGrid[80 - col][12] = GamePanel.CellContents.WALL;
      }
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }

   private Level createLevel4()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.UP;
      spawnDirections[1] = Snake.Direction.DOWN;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(49, 22);
      tempSpawns[1] = new Point2D.Double(29, 22);

      for (int row = 10; row <= 36; row++)
      {
         tempGrid[20][row] = GamePanel.CellContents.WALL;
         tempGrid[58][row] = GamePanel.CellContents.WALL;
      }
      for (int col = 22; col <= 56; col++)
      {
         tempGrid[col][8] = GamePanel.CellContents.WALL;
         tempGrid[col][38] = GamePanel.CellContents.WALL;
      }
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }
   
   private Level createLevel5()
   {
      spawnDirections = new Snake.Direction[2];
      tempSpawns = new Point2D.Double[2];
      tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.DOWN;
      spawnDirections[1] = Snake.Direction.UP;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(65, 5);
      tempSpawns[1] = new Point2D.Double(15, 41);

      for (int row = 1; row <= 46; row++)
      {
         if ( row > 27 || row < 20 )
         {
            tempGrid[9][row] = GamePanel.CellContents.WALL;
            tempGrid[19][row] = GamePanel.CellContents.WALL;
            tempGrid[29][row] = GamePanel.CellContents.WALL;
            tempGrid[39][row] = GamePanel.CellContents.WALL;
            tempGrid[49][row] = GamePanel.CellContents.WALL;
            tempGrid[59][row] = GamePanel.CellContents.WALL;
            tempGrid[69][row] = GamePanel.CellContents.WALL;
         }   
      }
      
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }
}
