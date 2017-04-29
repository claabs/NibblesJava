/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**

 @author Noah Moss
 */
public class GameSpaceTest
{
   
   
   public GameSpaceTest()
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
    * Test of getType method, of class GameSpace.
    */
   @Test
   public void testGetType()
   {
      System.out.println("getType");
      GameSpace instance = new GameSpace (GameSpace.SpaceType.WALL);
      GameSpace.SpaceType expResult = GameSpace.SpaceType.WALL;
      GameSpace.SpaceType result = instance.getType();
      assertEquals(expResult, result);
   }

   /**
    * Test of setType method, of class GameSpace.
    */
   @Test
   public void testSetType()
   {
      System.out.println("setType");
      GameSpace.SpaceType type = GameSpace.SpaceType.EMPTY;
      GameSpace instance = new GameSpace (GameSpace.SpaceType.WALL);
      instance.setType(type);
      assertEquals(instance.getType(), type);
   }   
}
