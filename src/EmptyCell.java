
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template
 in the editor.
 */
/**

 @author Nick
 */
public class EmptyCell extends Collidable
{

   public EmptyCell(Point2D.Double inPos)
   {
      super(inPos, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH, Color.blue, Color.black);
   }

   @Override
   public boolean collided(Collidable c)
   {
      return false;
   }

   public static Color getDrawColor()
   {
      if (GameManager.monochrome())
         return Color.black;
      else
         return Color.blue;
   }

   @Override
   public void draw(Graphics2D g, int xPos, int yPos)
   {
      g.setColor(getDrawColor());
      g.fillRect(xPos, yPos, width, height);
   }

}
