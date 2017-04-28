
import java.awt.geom.Point2D;

/**
   NOTE: Food is 2 cells tall, 1 cell wide.
   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class Food 
{
   private int value;
   private Point2D.Double location; //The point at the top cell of the Food
   
   Food(int foodValue, Point2D.Double location)
   {
      value = foodValue;
      this.location = location;
   }
   
   public int getValue()
   {
      return value;
   }
   
   public Point2D getLocation()
   {
      return location;
   }
   
   public void setValue(int foodValue)
   {
      value = foodValue;
   }
   
   public void setLocation( Point2D.Double location )
   {
      this.location = location;
   }
}
