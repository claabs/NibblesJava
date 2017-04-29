
import java.awt.BorderLayout;
import java.awt.Dimension;
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

   private static final int CHAR_WIDTH = 8;
   private static final int WIDTH = 80;
   private static final int HEIGHT = 48;

   private boolean monochrome;
   private int spritePalette;

   private static GameManager gameManager;

   public static void main(String args[])
   {
      JFrame window = new JFrame();
      //JPanel panel = new JPanel();
      /*panel.setPreferredSize(new Dimension(CELL_SIZE * WIDTH,
            CELL_SIZE * HEIGHT));*/
      /*window.getContentPane().setSize(CELL_SIZE * WIDTH,
            CELL_SIZE * HEIGHT);*/
 /*window.setSize(CELL_SIZE * WIDTH + CELL_SIZE,
            CELL_SIZE * HEIGHT + CELL_SIZE);*/
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameManager = new GameManager(window, WIDTH, HEIGHT, CHAR_WIDTH);
      //window.setVisible(true);
      /*window.getContentPane().setSize(CELL_SIZE * WIDTH + 2 * CELL_SIZE,
            CELL_SIZE * HEIGHT + 2 * CELL_SIZE);*/
   }
};
