
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**

 @author Nick
 */
public class Wall extends Collidable
{

   public Wall(Point2D.Double inPosition)
   {
      super(inPosition, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH, Color.red, Color.gray);
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
