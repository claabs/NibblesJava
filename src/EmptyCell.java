
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class is a child class of Collidable. It will handle when to
          draw an empty cell, what color that empty cell will be, where to
          draw the empty cell, and makes sure that the empty cell is not
          collidable.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class EmptyCell extends Collidable
{

   /**
    This is the constructor for an EmptyCell, and all it needs is the position
    of the EmptyCell.

    @param inPos The position of the EmptyCell.
    */
   public EmptyCell(Point2D.Double inPos)
   {
      super(inPos, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH, Color.decode("#0000AA"), Color.black);
   }

   /**
    This method will always return false since this is an empty cell and
    should not collide with anything.

    @param c The other collidable.

    @return False.
    */
   @Override
   public boolean collided(Collidable c)
   {
      return false;
   }

   /**
    This method returns the color of which to draw the EmptyCell.

    @return The color which the collidable will be drawn.
    */
   public static Color getDrawColor()
   {
      if (GameManager.monochrome)
         return Color.black;
      else
         return Color.blue;
   }

   /**
    This method will draw an EmptyCell on the Graphics2D provided at the
    location provided.

    @param g    The graphics on which to draw.
    @param xPos The x-coordinate at which to draw the object.
    @param yPos The y-coordinate at which to draw the object.
    */
   @Override
   public void draw(Graphics2D g, int xPos, int yPos)
   {
      g.setColor(getDrawColor());
      g.fillRect(xPos, yPos, width, height);
   }

}
