import java.awt.Color;
import javax.swing.JPanel;

/**

   @author Jake Ira
   @author Charlie Laabs
   @author Noah Moss
   @author Nick Sosinski
   @author Ed VanDerJagt
 */
public class SquarePanel extends JPanel
{

   public SquarePanel(Color d)
   {
      this.setBackground(d);
   }

   public void ChangeColor(Color d)
   {
      this.setBackground(d);
      this.repaint();
   }

}
