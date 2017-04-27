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
   
   /**NOTE: On old NIBBLES code:
   1 = UP
   2 = DOWN
   3 = LEFT
   4 = RIGHT
   
   Subtract 2 from old NIBBLES row due to scoreboard.
   
   
   */
   LevelConstructor()
   {
   //LEVEL 0
      levelList[0].snakeOrientations[0] = SnakeHead.Orientation.RIGHT;
      levelList[0].snakeOrientations[1] = SnakeHead.Orientation.LEFT;
      //                                              COL ROW
      levelList[0].snakeSpawn[0] = new Point2D.Double(50, 23);
      levelList[0].snakeSpawn[1] = new Point2D.Double(30, 23);
      levelList[0].levelGrid = { 
      { 0 }
      };
   }
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
}
