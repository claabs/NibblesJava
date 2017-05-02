
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 Course: SE-3860 Spring 2017 Project: Reengineering Project (Part 2) | Nibbles
 Purpose: This class handles all of the snakes processes. It will handle
          checking whether the snake has collided with anything, the snake
          eating, the snake dying, growing the snake, respawning the snake, 
          and changing the direction of the snake.

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
   private final List<SnakeSegment> body = new ArrayList();
   private int lives = 5;
   private int score = 0;
   private int numTimesEaten = 0;
   private int newSegments;
   private List<Direction> directions = new ArrayList<Direction>();

   private Point2D.Double initialSpawn;
   private Direction initialDirection;
   private Direction directionLastMoved;

   public enum Direction
   {
      RIGHT, UP, LEFT, DOWN
   };

   /**
    This constructor

    @param spawnPoint
    @param dir
    */
   public Snake(Point2D.Double spawnPoint, Direction dir)
   {
      initialDirection = dir;
      initialSpawn = spawnPoint;
      respawn();
   }

   /**
    This method

    @param newSpawn
    @param newDir
    */
   public void moveSpawn(Point2D.Double newSpawn, Direction newDir)
   {
      initialDirection = newDir;
      initialSpawn = newSpawn;
      respawn();
   }

   /**
    This method
    */
   public void respawn()
   {
      newSegments = 0;
      body.clear();
      body.add(new SnakeHead(initialSpawn, initialDirection));
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
      body.add(new SnakeBody(firstSegmentSpawnPoint, firstSegmentDirection));
   }

   /**
    This method
    */
   private void addSegment()
   {
      body.add(new SnakeBody(body.get(body.size() - 1)));
      newSegments++;
   }

   /**
    This method

    @param g
    @param xOffset
    @param yOffset
    */
   public void draw(Graphics2D g, int xOffset, int yOffset)
   {
      for (int i = 0; i < body.size(); i++)
         body.get(i).draw(g, xOffset, yOffset);

   }

   /**
    This method

    @param snake

    @return
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
    This method

    @param growValue
    */
   private void growSnake(int growValue)
   {
      if (body.size() < MAX_SNAKE_LENGTH - 30)
         for (int i = 0; i < growValue * GROW_FACTOR; i++)
            addSegment();
   }

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
    This method
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
    This method

    @return
    */
   public Point2D.Double getHeadLocation()
   {
      return body.get(0).getPosition();
   }

   /**
    This method

    @return
    */
   public List<SnakeSegment> getSnakeSegments()
   {
      return body.subList(1, body.size());
   }

   /**
    This method

    @param c

    @return
    */
   public boolean checkCollison(Collidable c)
   {
      return c.collided(body.get(0));
   }

   /**
    This method

    @return
    */
   public boolean gameOver()
   {
      return lives == 0;
   }

   /**
    This method

    @param inDir
    */
   public void setDirection(Direction inDir)
   {
      if (!directions.isEmpty())
      {
         if (directions.get(directions.size() - 1) != body.get(0).getDirection())
            directions.add(inDir);
      }
      else
         directions.add(inDir);

      //body.get(0).setDirection(inDir);
   }

   /**
    This method

    @return
    */
   public Direction getDirectionLastMoved()
   {
      return directionLastMoved;
   }

   /**
    This method
    */
   public void die()
   {
      lives--;
      numTimesEaten = 0;
      score -= 1000;
      try
      {
         InputStream inputStream = new FileInputStream("./resources/crash.wav");
         AudioStream audioStream = new AudioStream(inputStream);
         AudioPlayer.player.start(audioStream);
      }
      catch (IOException e)
      {
         System.err.println("File not found.");
      }
   }

   /**
    This method

    @param food
    */
   public void eat(Food food)
   {
      int foodValue = food.getValue();
      growSnake(foodValue);
      score += 100 * foodValue;
      try
      {
         InputStream inputStream = new FileInputStream("./resources/get-food-2.wav");
         AudioStream audioStream = new AudioStream(inputStream);
         AudioPlayer.player.start(audioStream);
      }
      catch (IOException e)
      {
         System.err.println("File not found.");
      }
      numTimesEaten++;
   }

   /**
    This method

    @return
    */
   public int getScore()
   {
      return score;
   }

   /**
    This method

    @return
    */
   public int getLives()
   {
      return lives;
   }

   /**
    This method

    @return
    */
   public int getNumTimesEaten()
   {
      return numTimesEaten;
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
    This method

    @return
    */
   @Override
   public int hashCode()
   {
      int hash = 3;
      hash = 53 * hash + Objects.hashCode(this.body);
      hash = 53 * hash + this.lives;
      hash = 53 * hash + this.score;
      hash = 53 * hash + this.numTimesEaten;
      hash = 53 * hash + this.newSegments;
      hash = 53 * hash + Objects.hashCode(this.initialSpawn);
      hash = 53 * hash + Objects.hashCode(this.initialDirection);
      hash = 53 * hash + Objects.hashCode(this.directionLastMoved);
      return hash;
   }
}
