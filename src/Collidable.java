
import java.awt.*;
import java.awt.geom.*;
import java.util.Objects;

/**
 Course:  SE-3860 Spring 2017
 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class is an abstract class used to determine collision between 
          objects.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public abstract class Collidable extends Drawable
{

   protected Point2D.Double position;

   /**
    This is the constructor for a collidable object.

    @param inPos       Position at which this object exists.
    @param inWidth     Width of this object.
    @param inHeight    Height of this object.
    @param inColor     Color of this object when its drawn on a color monitor.
    @param inMonoColor Color of this object when its drawn on a monochrome
                       monitor.
    */
   public Collidable(Point2D.Double inPos, int inWidth, int inHeight, Color inColor, Color inMonoColor)
   {
      super(inWidth, inHeight, inColor, inMonoColor);
      position = inPos;
   }

   /**
    This method will return true if two collidables have collided.

    @param c The other collidable.

    @return True if the two collidables have collided, false otherwise.
    */
   public boolean collided(Collidable c)
   {
      if (c == null)
         return false;
      if (this == c)
         return false;
      return position.equals(c.position);
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
      if (o.getClass() != Collidable.class)
         return false;
      Collidable collidable = (Collidable) o;
      return position.equals(collidable.position);
   }

   /**
   This method generates a random hash code for this object and returns it.
   
   @return Random hash code for the object.
   */
   @Override
   public int hashCode()
   {
      int hash = 7;
      hash = 83 * hash + Objects.hashCode(this.position);
      return hash;
   }
}
