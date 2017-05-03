
import java.io.File;
import java.io.IOException;
import java.util.Queue;
import javax.sound.sampled.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class is a used to play audio files from the various classes
          throughout the system. A static queuing system implemented in this 
          class makes sure that only one sound clip is played at a time, even
          when triggered from different instances of the AudioEffectPlayer
          class.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class AudioEffectPlayer implements LineListener
{  
   private static Clip audioClip = null;
   private static boolean isPlaying = false;
   private static Queue<String> playlist = new LinkedBlockingQueue<String>();
   
   AudioEffectPlayer()
   {
      try
      {
         audioClip = AudioSystem.getClip();
      }
      catch (LineUnavailableException e)
      {
         System.err.println("Error loading sound effect: " + e);
      }
      audioClip.addLineListener(this);
   }

   /**
    Queues or immediately plays the sound clip depending on whether or not
    a clip is already being played.

    @param soundFile The name of the sound file to be played.
    */
   public void playSound(String soundFile)
   {
      playlist.add(soundFile);
      if ( !isPlaying )
         playNextClip(playlist.remove());
   }
   
   /**
    Plays the sound clip given to it.

    @param soundFile The name of the sound file to be played.
    */
   private void playNextClip(String soundFile)
   {
      try
      {
         audioClip.open(AudioSystem.getAudioInputStream(new File(getClass().getClassLoader().getResource(soundFile).getFile())));
         audioClip.start();
      }
      catch (UnsupportedAudioFileException | LineUnavailableException | IOException e )
      {
         System.err.println("Error loading sound effect'" + soundFile + "': " + e);
      }
   }
   
   /**
    This method is run when the static audioClip is updated. This helps make
    sure that only one audio clip is played at a time.

    @param event The event that was triggered
    */
   @Override
   public void update(LineEvent event)
   {
      if (event.getType().equals(LineEvent.Type.START))
      {
         isPlaying = true;
      }
      if (event.getType().equals(LineEvent.Type.STOP))
      {
         audioClip.close();
         if (playlist.isEmpty())
            isPlaying = false;
         else
            playNextClip(playlist.remove());
      }
   }
}
