/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.sound.sampled.LineEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class AudioEffectPlayerTest
{

   public AudioEffectPlayerTest()
   {
   }

   @BeforeClass
   public static void setUpClass()
   {
   }

   @AfterClass
   public static void tearDownClass()
   {
   }

   @Before
   public void setUp()
   {
   }

   @After
   public void tearDown()
   {
   }

   /**
    * Test of playSound method, of class AudioEffectPlayer.
    */
   @Test
   public void testPlaySound()
   {
      System.out.println("playSound");
      String soundFile = "";
      AudioEffectPlayer instance = new AudioEffectPlayer();
      instance.playSound(soundFile);
      System.out.println("Verify \"Sound\" is playing.");

   }

   /**
    * Test of update method, of class AudioEffectPlayer.
    */
   @Test
   public void testUpdate()
   {
      System.out.println("update");
      LineEvent event = null;
      AudioEffectPlayer instance = new AudioEffectPlayer();
      instance.update(event);
      System.out.println("Verify only one audio is playing.");
   }

}
