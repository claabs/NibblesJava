
import javax.swing.*;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class serves only one purpose and that is to create a new
          game frame and create a new Game Manager window. 

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class Nibbles
{
   
   /**
   This method serves as the Main for the Nibbles program.
   
   @param args Command line arguments
   */
   public static void main(String args[])
   {
      JFrame window = new JFrame();
      window.setTitle("Nibbles - .min.jHawks V2");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      new GameManager(window);
   }
};
