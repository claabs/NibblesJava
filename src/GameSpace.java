/**

   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class GameSpace 
{
   public enum SpaceType
   {
      WALL, OPEN;
   }
   
   private SpaceType type;
   
   GameSpace(SpaceType type)
   {
      this.type = type;
   }
   
   public SpaceType getType()
   {
      return type;
   }
   
   public void setType(SpaceType type)
   {
      this.type = type;
   }
}
