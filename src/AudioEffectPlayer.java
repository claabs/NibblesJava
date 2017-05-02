
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class is a used to play audio files from the various classes
          throughout the system.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class AudioEffectPlayer 
{
   /**
    This method plays sound effects stored in the resources folder.

    @param soundFile The name of the sound file in the resources folder to be
      played.
    */
   public void playSound(String soundFile)
   {
      Clip audioClip = null;
      try
      {
         audioClip = AudioSystem.getClip();
         audioClip.open(AudioSystem.getAudioInputStream(new File(getClass().getClassLoader().getResource(soundFile).getFile())));
         audioClip.start();
      }
      catch (UnsupportedAudioFileException | LineUnavailableException | IOException e )
      {
         System.err.println("Error loading sound effect'" + soundFile + "': " + e);
      }
   }
}
