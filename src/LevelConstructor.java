
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

   /**
    NOTE: On old NIBBLES code: 1 = UP 2 = DOWN 3 = LEFT 4 = RIGHT

    Subtract 2 from old NIBBLES row due to scoreboard.

    Board is 80 wide by 48 tall including red border wall
    */
   LevelConstructor()
   {
      //LEVEL 0
      levelList[0] = createLevelOne();
      //SET ORIENTATIONS

      //LEVEL 1
      //LEVEL 2
      //LEVEL 3
      //LEVEL 4
      //LEVEL 5
      //LEVEL 6
      //LEVEL 7
      //LEVEL 8
   }

   public Level getLevel(int levelIndex)
   {
      return levelList[levelIndex];
   }

   private void createBorderWalls(GamePanel.CellContents[][] grid)
   {
      for (int row = 0; row < 48; row++)
         grid[0][row] = GamePanel.CellContents.WALL;
      for (int row = 0; row < 48; row++)
         grid[79][row] = GamePanel.CellContents.WALL;
      for (int col = 0; col < 80; col++)
         grid[col][0] = GamePanel.CellContents.WALL;
      for (int col = 0; col < 80; col++)
         grid[col][47] = GamePanel.CellContents.WALL;
   }

   private Level createLevelOne()
   {
      Snake.Direction[] spawnDirections = new Snake.Direction[2];
      Point2D.Double[] tempSpawns = new Point2D.Double[2];
      GamePanel.CellContents[][] tempGrid = new GamePanel.CellContents[WIDTH][HEIGHT];
      createBorderWalls(tempGrid);

      spawnDirections[0] = Snake.Direction.RIGHT;
      spawnDirections[1] = Snake.Direction.LEFT;

      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);

      for (int col = 1; col < 79; col++)
         for (int row = 1; row < 47; row++)
            tempGrid[col][row] = GamePanel.CellContents.EMPTY;
      return new Level(tempGrid, spawnDirections, tempSpawns);
   }
}
