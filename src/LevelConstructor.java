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
   
   LevelConstructor()
   {
   //LEVEL 0
      levelList[0].snakeOrientations[0] = SnakeHead.Orientation.LEFT;
      levelList[0].snakeOrientations[1] = SnakeHead.Orientation.RIGHT;
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
