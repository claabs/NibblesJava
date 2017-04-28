
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;
import sun.swing.DefaultLayoutStyle;

/**

 @author Jake Ira
 @author Charlie Laabs
 @author Noah Moss
 @author Nick Sosinski
 @author Ed VanDerJagt
 */
public class GameManager
{

   //Nick and Noah Area
   private boolean accelerate;
   private int currentLevel;
   private int difficulty;
   private GamePanel gameBoard;
   private Level levels;
   private Snake players[];
   private int speed;
   private static boolean paused;
   public Timer timer;
   private int updateInterval = 16;  // ms
   private JFrame frame;

   enum SnakeDirection
   {
      RIGHT, UP, LEFT, DOWN
   };
   public static SnakeDirection[] directionSnake = new SnakeDirection[2];

   public GameManager(JFrame window, int height, int width, int cellSize)
   {
      frame = window;
      gameBoard = new GamePanel(height, width, cellSize);
      ActionListener taskPerformer = (ActionEvent evt) ->
      {
         run();
      };
      timer = new Timer(updateInterval, taskPerformer);
      timer.start();
      window.add(gameBoard);
      window.addKeyListener((KeyListener) new KeyboardListener());

   }

   private void loadLevel(int level)
   {

   }

   private void updateGame()
   {

   }

   public static void pause()
   {
      paused = true;
   }

   public static void unpause()
   {
      paused = false;
   }

   public void run()
   {
      gameBoard.showPause(paused);
      if (!paused)
         updateGame();
      frame.repaint();
   }

   public static boolean isPaused()
   {
      return paused;
   }

   //End Nick and Noah Area
   /*
    private static final int FRAMERATE = 60;
    private static final int MAX_SNAKE_LENGTH = 1000;

    enum SnakeDirection
    {
    RIGHT, UP, LEFT, DOWN;
    }
    ArrayList<ArrayList<GameSpace>> Squares = new
    ArrayList<ArrayList<GameSpace>>();
    Tuple headSnakePos;
    int sizeSnake = 3;
    long speed = (1 / FRAMERATE) * 1000; //ms
    public static SnakeDirection[] directionSnake = new SnakeDirection[2];

    ArrayList<Tuple> positions = new ArrayList<Tuple>();
    Tuple foodPosition;
    int playerOneScore, playerTwoScore;

    //Constructor of ControlleurThread
    GameManager(Tuple positionDepart)
    {
    //Get all the threads
    Squares = GamePanel.Grid;

    headSnakePos = new Tuple(positionDepart.x, positionDepart.y);
    directionSnake[0] = SnakeDirection.RIGHT;
    directionSnake[1] = SnakeDirection.RIGHT;
    //!!! Pointer !!!!
    Tuple headPos = new Tuple(headSnakePos.getX(), headSnakePos.getY());
    positions.add(headPos);

    foodPosition = new Tuple(GameGridFrame.height - 1, GameGridFrame.width
    - 1);
    spawnFood(foodPosition);

    }

    //Important part :
    public void run()
    {
    long startTime;
    while (true)
    {
    startTime = System.nanoTime();
    moveInterne(directionSnake);
    checkCollision();
    moveExterne();
    deleteTail();
    pauser(startTime);
    }
    }

    //delay between each move of the snake
    private void pauser(long frameStart)
    {
    long workTime = (System.nanoTime() - frameStart) / 1000;
    try
    {
    sleep(speed - workTime);
    }
    catch (InterruptedException e)
    {
    e.printStackTrace();
    }
    }

    //Checking if the snake bites itself or is eating
    private void checkCollision()
    {
    Tuple posCritique = positions.get(positions.size() - 1);
    for (int i = 0; i <= positions.size() - 2; i++)
    {
    boolean biteItself = posCritique.getX() == positions.get(i).getX() &&
    posCritique.getY() == positions.get(i).getY();
    if (biteItself)
    {
    stopTheGame();
    }
    }

    boolean eatingFood = posCritique.getX() == foodPosition.y &&
    posCritique.getY() == foodPosition.x;
    if (eatingFood)
    {
    System.out.println("Yummy!");
    sizeSnake = sizeSnake + 1;
    foodPosition = getValAleaNotInSnake();
    updateScore(5); // Nibble's "food"
    Value--------------------------------------------------------------------------------------------------------------
    spawnFood(foodPosition);
    }
    }

    //Stops The Game
    private void stopTheGame()
    {
    System.out.println("COLISION! \n");
    while (true)
    {
    pauser(System.nanoTime());
    }
    }

    //Put food in a position and displays it
    private void spawnFood(Tuple foodPositionIn)
    {
    Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightMeUp(1);
    }

    //return a position not occupied by the snake
    private Tuple getValAleaNotInSnake()
    {
    Tuple p;
    int ranX = 0 + (int) (Math.random() * 19);
    int ranY = 0 + (int) (Math.random() * 19);
    p = new Tuple(ranX, ranY);
    for (int i = 0; i <= positions.size() - 1; i++)
    {
    if (p.getY() == positions.get(i).getX() && p.getX() ==
    positions.get(i).getY())
    {
    ranX = 0 + (int) (Math.random() * 19);
    ranY = 0 + (int) (Math.random() * 19);
    p = new Tuple(ranX, ranY);
    i = 0;
    }
    }
    return p;
    }

    //Moves the head of the snake and refreshes the positions in the
    arraylist
    //1:right 2:left 3:top 4:bottom 0:nothing
    private void moveInterne(int dir)
    {
    switch (dir)
    {
    case 4:
    headSnakePos.ChangeData(headSnakePos.x, (headSnakePos.y + 1) % 20);
    positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
    break;
    case 3:
    if (headSnakePos.y - 1 < 0)
    {
    headSnakePos.ChangeData(headSnakePos.x, 19);
    }
    else
    {
    headSnakePos.ChangeData(headSnakePos.x, Math.abs(headSnakePos.y - 1) %
    20);
    }
    positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
    break;
    case 2:
    if (headSnakePos.x - 1 < 0)
    {
    headSnakePos.ChangeData(19, headSnakePos.y);
    }
    else
    {
    headSnakePos.ChangeData(Math.abs(headSnakePos.x - 1) % 20,
    headSnakePos.y);
    }
    positions.add(new Tuple(headSnakePos.x, headSnakePos.y));

    break;
    case 1:
    headSnakePos.ChangeData(Math.abs(headSnakePos.x + 1) % 20,
    headSnakePos.y);
    positions.add(new Tuple(headSnakePos.x, headSnakePos.y));
    break;
    }
    }

    //Refresh the squares that needs to be
    private void moveExterne()
    {
    for (Tuple t : positions)
    {
    int y = t.getX();
    int x = t.getY();
    Squares.get(x).get(y).lightMeUp(0);

    }
    }

    //Refreshes the tail of the snake, by removing the superfluous data in
    positions arraylist
    //and refreshing the display of the things that is removed
    private void deleteTail()
    {
    int cmpt = sizeSnake;
    for (int i = positions.size() - 1; i >= 0; i--)
    {
    if (cmpt == 0)
    {
    Tuple t = positions.get(i);
    Squares.get(t.y).get(t.x).lightMeUp(2);
    }
    else
    {
    cmpt--;
    }
    }
    cmpt = sizeSnake;
    for (int i = positions.size() - 1; i >= 0; i--)
    {
    if (cmpt == 0)
    {
    positions.remove(i);
    }
    else
    {
    cmpt--;
    }
    }
    }

    private void updateScore(int nibbleValue) // Implement 2 players later
    {
    playerOneScore += nibbleValue;
    }
    */
}
