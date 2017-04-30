
import java.awt.Color;
import java.awt.geom.Point2D;

/**
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates and open the template
 in the editor.
 */
/**

 @author Nick
 */
public class SnakeBody extends SnakeSegment
{

   public SnakeBody(SnakeSegment oldEndOfSnake)
   {
      super(oldEndOfSnake.getPosition(), oldEndOfSnake.getDirection());

   }

   public SnakeBody(Point2D.Double spawnLocation, Snake.Direction spawnDirection)
   {
      super(spawnLocation, spawnDirection);
   }

}
