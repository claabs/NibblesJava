
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Objects;

/**
 Course: SE-3860 Spring 2017 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class is an abstract class that manages the segment of a snake.
 The snake segment handles the drawing, moving, and setting a direction of a
 snake segment.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public abstract class SnakeSegment extends Collidable
{

   private Snake.Direction direction;

   /**
    This constructor creates a new snake segment at a specific spawn point and
    facing a specific direction. Also, the color of the snake segment is
    determined; namely, the snake segment is yellow if the game is in color
    and the snake segment is white if the game is in monochrome.

    @param spawnPoint   Specific spawn point.
    @param inDir        Specific spawn direction.
    */
   public SnakeSegment(Point2D.Double spawnPoint, Snake.Direction inDir, Snake parent)
   {
      super(spawnPoint, GameManager.CHAR_WIDTH, GameManager.CHAR_WIDTH, parent.getColorColor(), parent.getMonoColor());
      direction = inDir;
   }

   /**
    This method will move the snake segment forward in the direction of the
    segments direction.
    */
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

   /**
    This method gets the position of the snake segment.

    @return The position of the snake segment.
    */
   protected Point2D.Double getPosition()
   {
      return position;
   }

   /**
    This method gets the direction that the snake segment is facing.

    @return The direction that the snake segment is facing.
    */
   protected Snake.Direction getDirection()
   {
      return direction;
   }

   /**
    This method will set the direction for the snake segment to face.

    @param inDir The direction for the snake segment to face.
    */
   protected void setDirection(Snake.Direction inDir)
   {
      direction = inDir;
   }

   /**
    This method returns true if two objects are the same data-wise.

    @param o The other object.

    @return True if the two objects are the same data-wise.
    */
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

   /**
    This method generates a random hash code for this object and returns it.

    @return Random hash code for the object.
    */
   @Override
   public int hashCode()
   {
      int hash = 7;
      hash = 13 * hash + Objects.hashCode(this.direction);
      return hash;
   }

   /**
    This method will draw the SnakeSegment on the Graphics2D provided at the
    location provided.

    @param g    The graphics on which to draw.
    @param xPos The x-coordinate at which to draw the object.
    @param yPos The y-coordinate at which to draw the object.
    */
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
