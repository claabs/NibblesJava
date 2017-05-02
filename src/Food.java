
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles the snake's food. It will handle the construction
          of the food and where the food should be positioned on a level.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class Food extends Collidable
{

   private final int value;
   private final int foodID;

   /**
    This is the constructor for a Food.

    @param foodValue The value of the food.
    @param location  The location of the food.
    @param id        The ID of the food.
    */
   Food(int foodValue, Point2D.Double location, int id)
   {
      super(location, GameManager.CHAR_WIDTH, GameManager.CHAR_HEIGHT, Color.white, Color.white);
      value = foodValue;
      foodID = id;
   }

   /**
    This method returns the value of the food.

    @return The foods value.
    */
   public int getValue()
   {
      return value;
   }

   /**
    This method returns the position of the food.

    @return The position of the food.
    */
   public Point2D.Double getPosition()
   {
      return position;
   }

   /**
    This method returns true if two objects are the same data-wise.

    @param o The other object.

    @return True if the two objects are the same data-wise.
    */
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

   /**
   This method 
   
   @return 
   */
   @Override
   public int hashCode()
   {
      int hash = 7;
      hash = 43 * hash + this.value;
      hash = 43 * hash + this.foodID;
      return hash;
   }
   
   /**
    This method will draw the Food on the Graphics2D provided at the
    location provided.

    @param g    The graphics on which to draw.
    @param xPos The x-coordinate at which to draw the object.
    @param yPos The y-coordinate at which to draw the object.
   */
   @Override
   public void draw(Graphics2D g, int xPos, int yPos)
   {
      g.setColor(EmptyCell.getDrawColor());
      g.fillRect(xPos, yPos, width, height);
      if (GameManager.monochrome)
         g.setColor(monoColor);
      else
         g.setColor(color);
      if (foodID == 0)
         g.drawString(Integer.toString(value), xPos, yPos + 4);
   }
}
