
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles drawing the walls for the game.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class Wall extends Collidable
{

   /**
   This constructor creates a new wall for the game with a specified width
   and height.
   Also, the color of the wall is to be determined; namely, the wall will be
   painted red if the game is in color or the wall will be painted gray if
   the game is in monochrome.
   
   @param inPosition 
   */
   public Wall(Point2D.Double inPosition)
   {
      super(inPosition, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH, Color.decode("#FF5555"), Color.gray);
   }

   /**
    This method will draw the Wall on the Graphics2D provided at the location
    provided.

    @param g    The graphics on which to draw.
    @param xPos The x-coordinate at which to draw the object.
    @param yPos The y-coordinate at which to draw the object.
    */
   @Override
   public void draw(Graphics2D g, int xPos, int yPos)
   {
      if (GameManager.monochrome)
         g.setColor(monoColor);
      else
         g.setColor(color);
      g.fillRect(xPos, yPos, width, height);
   }
}
