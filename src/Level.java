/**

   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class Level 
{
   public Tuple snake0 = new Tuple(25,50);
   public Tuple snake1 = new Tuple(25,30);
   public GameManager.SnakeDirection snake0Dir = GameManager.SnakeDirection.RIGHT;
   public GameManager.SnakeDirection snake1Dir = GameManager.SnakeDirection.LEFT;
   public GameSpace.SpaceType[][] level1 = {
      { GameSpace.SpaceType.OPEN, GameSpace.SpaceType.OPEN }
   };
}
