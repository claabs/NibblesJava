/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**

 @author Noah Moss
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
      {
         NibblesTest.class,
         FoodTest.class,
         GameManagerTest.class,
         SnakeTest.class, 
         SnakeBodyTest.class, 
         KeyboardListenerTest.class,
         SnakeHeadTest.class,
         LevelConstructorTest.class, 
         WallTest.class, 
         LevelTest.class, 
         GamePanelTest.class,
         AudioEffectPlayerTest.class,
         CollidableTest.class,
         EmptyCellTest.class         
      })
public class RootSuite
{

   @BeforeClass
   public static void setUpClass() throws Exception
   {
   }

   @AfterClass
   public static void tearDownClass() throws Exception
   {
   }

   @Before
   public void setUp() throws Exception
   {
   }

   @After
   public void tearDown() throws Exception
   {
   }

   public static void startGame(int numPlayers, int skillLevel, boolean increaseSpeed, boolean color)
   {
      try
      {

         Robot robot = new Robot();
         int delay = 250;
         robot.delay(100);
         robot.keyPress(KeyEvent.VK_SPACE);
         robot.delay(delay);
         robot.keyRelease(KeyEvent.VK_SPACE);
         robot.delay(delay);
         int keyToPress;
         if (numPlayers == 1)
            keyToPress = KeyEvent.VK_1;
         else
            keyToPress = KeyEvent.VK_2;
         robot.keyPress(keyToPress);
         robot.delay(delay);
         robot.keyRelease(keyToPress);
         robot.delay(delay);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.delay(delay);
         robot.keyRelease(KeyEvent.VK_ENTER);
         robot.delay(delay);
         //SetSkillHere
         robot.keyPress(KeyEvent.VK_1);
         robot.delay(delay);
         robot.keyRelease(KeyEvent.VK_1);
         robot.delay(delay);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.delay(delay);
         robot.keyRelease(KeyEvent.VK_ENTER);
         robot.delay(delay);
         if (increaseSpeed)
            keyToPress = KeyEvent.VK_Y;
         else
            keyToPress = KeyEvent.VK_N;
         robot.keyPress(keyToPress);
         robot.delay(delay);
         robot.keyRelease(keyToPress);
         robot.delay(delay);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.delay(delay);
         robot.keyRelease(KeyEvent.VK_ENTER);
         robot.delay(delay);
         if (color)
            keyToPress = KeyEvent.VK_C;
         else
            keyToPress = KeyEvent.VK_M;
         robot.keyPress(keyToPress);
         robot.delay(delay);
         robot.keyRelease(keyToPress);
         robot.delay(delay);
         robot.keyPress(KeyEvent.VK_ENTER);
         robot.delay(delay);
         robot.keyRelease(KeyEvent.VK_ENTER);
         robot.delay(200);
         robot.keyPress(KeyEvent.VK_SPACE);
         robot.delay(delay);
         robot.keyRelease(KeyEvent.VK_SPACE);
      }
      catch (Exception e)
      {
      }
   }

}
