/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

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
   GameSpaceTest.class, LevelTest.class, SnakeTest.class, FoodTest.class, KeyboardListenerTest.class, GameManagerTest.class, GamePanelTest.class, SnakeSegmentTest.class, SnakeHeadTest.class, LevelConstructorTest.class, NibblesTest.class
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
   
}