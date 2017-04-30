
import java.awt.geom.Point2D;

/**
 NOTE: Food is 2 cells tall, 1 cell wide.

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class Food extends Collidable
{

   private int value;
   private final Point2D.Double otherPosition;

   Food(int foodValue, Point2D.Double location)
   {
      super(location);
      otherPosition = new Point2D.Double(location.x, location.y + 1);
      value = foodValue;
   }

   public int getValue()
   {
      return value;
   }

   public Point2D.Double getPosition()
   {
      return position;
   }

   public void setValue(int foodValue)
   {
      value = foodValue;
   }

   public void setPosition(Point2D.Double location)
   {
      position = location;
   }

   @Override
   public boolean collided(Collidable c)
   {
      if (super.collided(c))
         return true;
      else
      {
         Food food = (Food) c;
         return food.otherPosition.equals(otherPosition);
      }
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == null)
         return false;
      if (o.getClass() != Food.class)
         return false;
      Food food = (Food) o;
      return position.equals(food.position)
            && value == food.value;
   }
}
