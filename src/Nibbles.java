
import java.awt.event.*;
import javax.swing.*;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class Nibbles
{

   private static final int CELL_SIZE = 10;
   private static final int WIDTH = 80;
   private static final int HEIGHT = 50;
   private static final int MARGIN_SPACING = 20;
   private static final int TITLE_BAR_HEIGHT = 25;

   private boolean monochrome;
   private int spritePalette;

   private static GameManager gameManager;

   public static void main(String args[])
   {
      JFrame window = new JFrame();
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setVisible(true);
      window.setSize(CELL_SIZE * WIDTH + 2 * CELL_SIZE + MARGIN_SPACING,
            CELL_SIZE * HEIGHT + 2 * CELL_SIZE + MARGIN_SPACING + TITLE_BAR_HEIGHT);
      gameManager = new GameManager(window, WIDTH, HEIGHT, CELL_SIZE);

   }
};
