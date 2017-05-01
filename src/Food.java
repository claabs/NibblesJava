
import java.awt.Color;
import java.awt.Graphics2D;
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
   int foodID;
   
   
   Food(int foodValue, Point2D.Double location, int id)
   {
      super(location, GameManager.CHAR_WIDTH, GameManager.CHAR_HEIGHT, Color.white, Color.white);
      value = foodValue;
      foodID = id;
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
   
   //@Override
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
   
   //@Override
   public void draw(Graphics2D g, int xPos, int yPos)
   {
      g.setColor(EmptyCell.getDrawColor());
      g.fillRect(xPos, yPos, width, height);
      if (GameManager.monochrome())
         g.setColor(monoColor);
      else
         g.setColor(color);
      if (foodID == 0)
         g.drawString(Integer.toString(value), xPos, yPos+4);
   }
}
