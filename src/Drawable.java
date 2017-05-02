
import java.awt.*;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class 

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public abstract class Drawable
{

   protected Color color;
   protected Color monoColor;
   protected int width;
   protected int height;

   /**
    This is the constructor for a drawable object.

    @param drawWidth   Width of this object.
    @param drawHeight  Height of this object.
    @param inColor     Color of this object when its drawn on a color monitor.
    @param inMonoColor Color of this object when its drawn on a monochrome
                       monitor.
    */
   Drawable(int drawWidth, int drawHeight, Color inColor, Color inMonoColor)
   {
      width = drawWidth;
      height = drawHeight;
      color = inColor;
      monoColor = inMonoColor;
   }

   /**
    This method will draw the drawable on the Graphics2D provided at the
    location provided. This method is abstract and must be created per child
    class.

    @param g    The graphics on which to draw.
    @param xPos The x-coordinate at which to draw the object.
    @param yPos The y-coordinate at which to draw the object.
    */
   public abstract void draw(Graphics2D g, int xPos, int yPos);

}
