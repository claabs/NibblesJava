
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class SnakeSegment extends Collidable
{

   private Snake.Direction direction;

   SnakeSegment(Point2D.Double spawnPoint, Snake.Direction inDir)
   {
      super(spawnPoint, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH, Color.yellow, Color.white);
      direction = inDir;
   }

   public void moveForward()
   {
      //Left/Right math is reversed when dealing with drawing graphics
      switch (direction)
      {
         case RIGHT:
            position = new Point2D.Double(position.x + 1, position.y);
            break;
         case UP:
            position = new Point2D.Double(position.x, position.y - 1);
            break;
         case LEFT:
            position = new Point2D.Double(position.x - 1, position.y);
            break;
         case DOWN:
            position = new Point2D.Double(position.x, position.y + 1);
            break;
         default:
      }
   }

   public Point2D.Double getPosition()
   {
      return position;
   }

   public Snake.Direction getDirection()
   {
      return direction;
   }

   public void setDirection(Snake.Direction inDir)
   {
      direction = inDir;
   }

   @Override
   public boolean equals(Object o)
   {
      if (o == null)
         return false;
      if (o.getClass() != SnakeSegment.class)
         return false;
      SnakeSegment segment = (SnakeSegment) o;
      return direction == segment.direction
            && position.equals(segment.position);
   }

   @Override
   public void draw(Graphics2D g, int xPos, int yPos)
   {
      if (GameManager.monochrome)
         g.setColor(monoColor);
      else
         g.setColor(color);
      int xPos2 = xPos + (int) position.x * GameManager.CHAR_WIDTH;
      int yPos2 = yPos + (int) position.y * GameManager.CHAR_WIDTH;
      g.fillRect(xPos2, yPos2, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH);
   }
}
