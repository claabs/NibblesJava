
import java.awt.Color;
import java.awt.Graphics2D;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public abstract class Drawable
{

   protected Color color;
   protected Color monoColor;
   protected int width;
   protected int height;

   Drawable(int drawWidth, int drawHeight)
   {
      width = drawWidth;
      height = drawHeight;
   }

   Drawable(int drawWidth, int drawHeight, Color inColor, Color inMonoColor)
   {
      width = drawWidth;
      height = drawHeight;
      color = inColor;
      monoColor = inMonoColor;
   }

   public abstract void draw(Graphics2D g, int xPos, int yPos);

}
