
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.*;

/**
 Course: SE-3860 Spring 2017 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles all of the snakes processes. It will handle
 checking whether the snake has collided with anything, the snake eating, the
 snake dying, growing the snake, respawning the snake, and changing the
 direction of the snake.

 @author Nick Sosinski
 @author Charlie Laabs
 @author Noah Moss
 @author Jake Ira
 @author Ed VanDerJagt
 */
public class Snake
{

   private static final int MAX_SNAKE_LENGTH = 1000;
   private static final int GROW_FACTOR = 4;
   private static final Color PLAYER_1_COLORCOLOR = new Color(255, 255, 85);
   private static final Color PLAYER_1_MONOCOLOR = new Color(255, 255, 255);
   private static final Color PLAYER_2_COLORCOLOR = new Color(255, 85, 255);
   private static final Color PLAYER_2_MONOCOLOR = new Color(170, 170, 170);
   private final List<SnakeSegment> body = new ArrayList();
   private int lives = 5;
   private int score = 0;
   private int newSegments;
   private final List<Direction> directions = new ArrayList<>();
   private final AudioEffectPlayer audio = new AudioEffectPlayer();
   private Point2D.Double initialSpawn;
   private Direction initialDirection;
   private final Color color;
   private final Color monoColor;

   public enum Direction
   {
      RIGHT, UP, LEFT, DOWN
   };

   /**
    This constructor will create a new snake with an initial spawn point and
    an initial direction it will be facing.

    @param spawnPoint Initial spawn point of the snake.
    @param dir        Initial direction the snake will be facing.
    @param playerNum  The player number used to determine color when drawing (starts at 1).
    */
   public Snake(Point2D.Double spawnPoint, Direction dir, int playerNum)
   {
      initialDirection = dir;
      initialSpawn = spawnPoint;
      if (playerNum == 1)
      {
         color = PLAYER_1_COLORCOLOR;
         monoColor = PLAYER_1_MONOCOLOR;
      }
      else
      {
         color = PLAYER_2_COLORCOLOR;
         monoColor = PLAYER_2_MONOCOLOR;
      }
      respawn();
   }

   /**
    This method will move the spawn point of the snake to a new spawn point.
    Also, it will change the direction that the snake will be facing.

    @param newSpawn New spawn point for the snake.
    @param newDir   New direction that the snake will be facing.
    */
   public void moveSpawn(Point2D.Double newSpawn, Direction newDir)
   {
      initialDirection = newDir;
      initialSpawn = newSpawn;
   }

   public Color getColorColor()
   {
      return color;
   }

   public Color getMonoColor()
   {
      return monoColor;
   }

   /**
    This method will respawn the snake at the initial spawn points with the
    initial spawn direction.
    */
   public final void respawn()
   {
      newSegments = 0;
      body.clear();
      body.add(new SnakeHead(initialSpawn, initialDirection, this));
      Point2D.Double firstSegmentSpawnPoint = body.get(0).getPosition();
      Direction firstSegmentDirection = initialDirection;
      switch (initialDirection)
      {
         case UP:
            firstSegmentSpawnPoint = new Point2D.Double(firstSegmentSpawnPoint.x, firstSegmentSpawnPoint.y + 1);
            break;
         case DOWN:
            firstSegmentSpawnPoint = new Point2D.Double(firstSegmentSpawnPoint.x, firstSegmentSpawnPoint.y - 1);
            break;
         case LEFT:
            firstSegmentSpawnPoint = new Point2D.Double(firstSegmentSpawnPoint.x + 1, firstSegmentSpawnPoint.y);
            break;
         case RIGHT:
            firstSegmentSpawnPoint = new Point2D.Double(firstSegmentSpawnPoint.x - 1, firstSegmentSpawnPoint.y);
            break;
      }
      body.add(new SnakeBody(firstSegmentSpawnPoint, firstSegmentDirection, this));
   }

   /**
    This method will add a segment to the end of the body of the snake.
    */
   private void addSegment()
   {
      body.add(new SnakeBody(body.get(body.size() - 1), this));
      newSegments++;
   }

   public Color getColor()
   {
      if (GameManager.monochrome)
         return monoColor;
      else
         return color;
   }

   /**
    This method will draw the snake including all of its segments; namely, the
    entire snake.

    @param g       Graphics to be drawn upon.
    @param xOffset Offset in the x plane.
    @param yOffset Offset in the y plane.
    */
   public void draw(Graphics2D g, int xOffset, int yOffset)
   {
      for (int i = 0; i < body.size(); i++)
         body.get(i).draw(g, xOffset, yOffset);

   }

   /**
    This method will check to see if the snake head has collided with any
    snake segments of the opposing snake.

    @param snake The opposing snake.

    @return True if the snake head has collided with any snake segments of the
            opposing snake, false otherwise.
    */
   public boolean collidedWithOtherSnake(Snake snake)
   {
      java.util.List segments = snake.getSnakeSegments();
      for (int k = 0; k < segments.size(); k++)
         if (checkCollison((Collidable) segments.get(k)))
            return true;
      return false;
   }

   /**
    This method will check to see if a collidable object (such as food) is
    colliding with this snake.

    @param coll And object that may be colliding with the snake.

    @return True if the the collidable object has collided with any snake 
            segments of this snake, false otherwise.
    */
   public boolean collidedWithCollidable(Collidable coll)
   {
      for (int k = 0; k < body.size(); k++)
         if (coll.collided(body.get(k)))
             return true;
      return false;
   }
   
   /**
    This method will grow the body of the snake by the specified grow value.

    @param growValue Value to which the snake will grow by.
    */
   private void growSnake(int growValue)
   {
      if (body.size() < MAX_SNAKE_LENGTH - 30)
         for (int i = 0; i < growValue * GROW_FACTOR; i++)
            addSegment();
   }

   /**
    This method returns the other direction of the passed direction.

    @param inDirection The passed direction.

    @return The other direction of the passed direction.
    */
   private Direction otherDirection(Direction inDirection)
   {
      switch (inDirection)
      {
         case DOWN:
            return Direction.UP;
         case LEFT:
            return Direction.RIGHT;
         case RIGHT:
            return Direction.LEFT;
         case UP:
         default:
            return Direction.DOWN;
      }
   }

   /**
    This method moves the snake forward with the first valid direction change
    from the directed user input.
    */
   public void iterateForward()
   {
      SnakeHead head = (SnakeHead) body.get(0);
      Direction currentDirection = head.getDirection();
      Direction newDirection = currentDirection;
      if (directions.size() > 0)
      {
         newDirection = directions.remove(0);
         while (newDirection == otherDirection(currentDirection) && !directions.isEmpty())
            newDirection = directions.remove(0);
      }
      if (newDirection != otherDirection(currentDirection))
         head.setDirection(newDirection);
      for (int i = 0; i < body.size() - newSegments; i++)
         body.get(i).moveForward();
      for (int i = body.size() - newSegments - 1; i > 1; i--)
         body.get(i).setDirection(body.get(i - 1).getDirection());
      body.get(1).setDirection(body.get(0).getDirection());
      if (newSegments > 0)
         newSegments--;
   }

   /**
    This method will return the location of the snake head.

    @return The location of the snake head.
    */
   public Point2D.Double getHeadLocation()
   {
      return body.get(0).getPosition();
   }

   /**
    This method will return the segments of the snake that are not the head.

    @return The segments of the snake that are not the head.
    */
   public List<SnakeSegment> getSnakeSegments()
   {
      return body.subList(1, body.size());
   }

   /**
    This method checks to see whether there has been a collision with the body
    of the snake and any other component.

    @param c Component collided with.

    @return True if the body of the snake has collided with a component, false
            otherwise.
    */
   public boolean checkCollison(Collidable c)
   {
      return c.collided(body.get(0));
   }

   /**
    This method checks to see whether the game is over.

    @return True if the game is over, false otherwise.
    */
   public boolean gameOver()
   {
      return lives == 0;
   }

   /**
    This method will process a direction from user input. The direction will
    be added if it is legitimate, otherwise it will not.

    @param inDir Direction to be processed from the user.
    */
   public void setDirection(Direction inDir)
   {
      if (!directions.isEmpty())
      {
         if (directions.get(directions.size() - 1) != inDir)
            directions.add(inDir);
      }
      else
         directions.add(inDir);

      //body.get(0).setDirection(inDir);
   }

   /**
    This method will trigger what will occur when the snake dies during
    gameplay.
    */
   public void die()
   {
      lives--;
      score -= 1000;
      audio.playSound("crash.wav");
   }

   /**
    This method will trigger what will occur when the snake eats food during
    gameplay.

    @param food Food the snake will eat.
    */
   public void eat(Food food)
   {
      int foodValue = food.getValue();
      growSnake(foodValue);
      score += 100 * foodValue;
      audio.playSound("get-food-2.wav");
   }

   /**
    This method returns the score of the game.

    @return The score of the game.
    */
   public int getScore()
   {
      return score;
   }

   /**
    This method returns the lives the snake has remaining.

    @return The lives the snake has remaining.
    */
   public int getLives()
   {
      return lives;
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
      if (o.getClass() != Snake.class)
         return false;
      Snake snake = (Snake) o;
      if (snake.body.size() != body.size())
         return false;
      for (int i = 0; i < body.size() - 1; i++)
         if (!body.get(i).getPosition().equals(snake.body.get(i).getPosition())
               || body.get(i).getDirection() != snake.body.get(i).getDirection())
            return false;
      return newSegments == snake.newSegments
            && score == snake.score
            && lives == snake.lives;
   }

   /**
    This method generates a random hash code for this object and returns it.

    @return Random hash code for the object.
    */
   @Override
   public int hashCode()
   {
      int hash = 3;
      hash = 53 * hash + Objects.hashCode(this.body);
      hash = 53 * hash + this.lives;
      hash = 53 * hash + this.score;
      hash = 53 * hash + this.newSegments;
      hash = 53 * hash + Objects.hashCode(this.initialSpawn);
      hash = 53 * hash + Objects.hashCode(this.initialDirection);
      return hash;
   }
}
