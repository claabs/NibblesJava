
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

    Subtract 2 from old NIBBLES row due to scoreboard.

    Board is 80 wide by 48 tall including red border wall
    */
   LevelConstructor()
   {
      levelList[0] = createLevel0();
      levelList[1] = createLevel1();
      levelList[2] = createLevel2();
      levelList[3] = createLevel3();
   }

   public Level getLevel(int levelIndex)
   {
      return levelList[levelIndex];
   }

   private void createBorderWalls(GamePanel.CellContents[][] grid)
   {
      //Create 4 walls
      for (int row = 0; row < 48; row++)
         grid[0][row] = GamePanel.CellContents.WALL;
      for (int row = 0; row < 48; row++)
         grid[79][row] = GamePanel.CellContents.WALL;
      for (int col = 0; col < 80; col++)
         grid[col][0] = GamePanel.CellContents.WALL;
      for (int col = 0; col < 80; col++)
         grid[col][47] = GamePanel.CellContents.WALL;
      //Fill inside with empty
      for (int col = 1; col < 79; col++)
         for (int row = 1; row < 47; row++)
            tempGrid[col][row] = GamePanel.CellContents.EMPTY;
   }

   private Level createLevel0()
   {
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.RIGHT;
      spawnDirections[1] = Snake.Direction.LEFT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      return new Level(tempGrid, spawnDirections, tempSpawns);
   }
   
   private Level createLevel1()
   {
      
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.LEFT;
      spawnDirections[1] = Snake.Direction.RIGHT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(60, 5);
      tempSpawns[1] = new Point2D.Double(20, 41);

      for (int col = 20; col <= 60; col++)
         tempGrid[col][23] = GamePanel.CellContents.WALL;
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }
   
   private Level createLevel2()
   {
      
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.UP;
      spawnDirections[1] = Snake.Direction.DOWN;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int row = 8; row <= 38; row++)
      {
         tempGrid[20][row] = GamePanel.CellContents.WALL;
         tempGrid[60][row] = GamePanel.CellContents.WALL;
      }
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }
   
   private Level createLevel3()
   {
      
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.LEFT;
      spawnDirections[1] = Snake.Direction.RIGHT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(60, 5);
      tempSpawns[1] = new Point2D.Double(20, 41);

      for (int row = 1; row <= 28; row++)
      {
         tempGrid[20][row] = GamePanel.CellContents.WALL;
         tempGrid[60][48-row] = GamePanel.CellContents.WALL;
      }
      for (int col = 1; col <= 40; col++)
      {
         tempGrid[col][36] = GamePanel.CellContents.WALL;
         tempGrid[80-col][13] = GamePanel.CellContents.WALL;
      }
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }
}

