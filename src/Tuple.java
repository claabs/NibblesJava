/**

   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class Tuple
{

   public int x;
   public int y;
   public int xf;
   public int yf;

   public Tuple(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   public void ChangeData(int x, int y)
   {
      this.x = x;
      this.y = y;
   }

   public int getX()
   {
      return x;
   }

   public int getY()
   {
      return y;
   }

   public int getXf()
   {
      return xf;
   }

   public int getYf()
   {
      return yf;
   }

}
