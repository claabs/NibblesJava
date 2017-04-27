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
   private Level[] levelList = new Level[9];
   private SnakeHead.Orientation[] tempOrientations = new SnakeHead.Orientation[2];
   private Point2D[] tempSpawns = new Point2D[2];
   private GameSpace.SpaceType[][] tempGrid = new GameSpace.SpaceType[80][48];
   
   /**NOTE: On old NIBBLES code:
   1 = UP
   2 = DOWN
   3 = LEFT
   4 = RIGHT
   
   Subtract 2 from old NIBBLES row due to scoreboard.
   
   Board is 80 wide by 48 tall including red border wall
   */
   LevelConstructor()
   {
   //LEVEL 0
      //SET ORIENTATIONS
      tempOrientations[0] = SnakeHead.Orientation.RIGHT;
      tempOrientations[0] = SnakeHead.Orientation.LEFT;
      levelList[0].setSnakeOrientations( tempOrientations);
      
      //SET SPAWNS                       COL ROW
      tempSpawns[0] = new Point2D.Double(50, 23);
      tempSpawns[1] = new Point2D.Double(30, 23);
      levelList[0].setSnakeSpawns(tempSpawns);
      
      createBorderWalls();
      
      for ( int col = 1; col < 79; col++ )
         for ( int row = 1; row < 47; row++ )
            tempGrid[col][row] = GameSpace.SpaceType.OPEN;
      
      levelList[0].setLevelGrid(tempGrid);
      
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

   private void createBorderWalls()
   {
      for ( int row = 0; row < 48; row++ )
         tempGrid[0][row] = GameSpace.SpaceType.WALL;
      for ( int row = 0; row < 48; row++ )
         tempGrid[79][row] = GameSpace.SpaceType.WALL;
      for ( int col = 0; col < 80; col++ )
         tempGrid[col][0] = GameSpace.SpaceType.WALL;
      for ( int col = 0; col < 80; col++ )
         tempGrid[col][47] = GameSpace.SpaceType.WALL;
   }
}
