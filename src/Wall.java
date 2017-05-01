
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
public class Wall extends Collidable
{
   
   public Wall(Point2D.Double inPosition)
   {
      super(inPosition, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH, Color.red, Color.gray);
   }
   
   @Override
   public void draw(Graphics2D g, int xPos, int yPos)
   {
      if (GameManager.monochrome())
         g.setColor(monoColor);
      else
         g.setColor(color);
      g.fillRect(xPos, yPos, width, height);
   }
}
