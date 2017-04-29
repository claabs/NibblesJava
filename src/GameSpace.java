
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class GameSpace
{

   public enum SpaceType
   {
      WALL, OPEN;
   }

   private SpaceType type;

   GameSpace(SpaceType type)
   {
      this.type = type;
   }

   public SpaceType getType()
   {
      return type;
   }

   public void setType(SpaceType type)
   {
      this.type = type;
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.add(new JPanel()
      {
         public void paintComponent(Graphics g)
         {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;

            Line2D line = new Line2D.Double(10, 10, 40, 40);
            g2.setColor(Color.blue);
            g2.setStroke(new BasicStroke(10));
            g2.draw(line);
         }
      });
      frame.setVisible(true);
   }

}
