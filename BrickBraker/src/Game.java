import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{
	public static final int ROWS = 30;
	public static final int COLS = 30;
	public static final int SIZE = 20;
	public static final int WIDTH = COLS*SIZE;
	public static final int HEIGHT = ROWS*SIZE;
	
	private Ball ball;
	public static Board board;
	public static int score;
	
	//add bricks
	public static Bricks bricks;
	
	private Thread runThread;
	public static Graphics globalGraphics;
	public static GameMessages msg; // for all messages
	
	static boolean gameRunning = false;
	private BufferStrategy bs;
	
	public void paint(Graphics g){
		globalGraphics = g.create();
		
		// Check is the game is already running
		if(runThread == null){
			runThread = new Thread(this);
			runThread.start();
			gameRunning = true;		
		}
	}
	
	public Game(){
		ball = new Ball();
		board = new Board();
		msg = new GameMessages();
		score = 0;
		bricks = new Bricks();
		board.setSize(score);
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		
		//msg.drawNewGame(globalGraphics);
		
		while (gameRunning){
			render(globalGraphics);
			board.move();
			ball.tick(bricks);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			board.setSize(score);
		}
//		this.drawDeath(globalGraphics);// the text when you dead
	}
		
	public void render(Graphics g){
		
        //Setting the bufferStrategy to be the one used in our canvas
        this.bs = this.getBufferStrategy();
        if (bs == null) {
            //Create 2 buffers
            this.createBufferStrategy(2);
            //returns out of the method to prevent errors
            return;
        }
        //Instantiates the graphics related to the bufferStrategy
        g = bs.getDrawGraphics();
        
        // Start drawing things on the screen
		this.drawScore(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		ball.drawBall(g);
		board.drawBoard(g);
		bricks.drawBricks(g);
		// end of drawing.
		
        //Enables the buffer
        bs.show();
        //Shows everything stored in the Graphics object
        g.dispose();
	}
	
	public void drawScore(Graphics g){
		// set the score board background color and paint it.
		g.setColor(Color.gray);
		g.fillRect(Game.WIDTH, 0, 100, Game.HEIGHT);
		// set the scoreboard borders
		g.setColor(Color.darkGray);
		g.drawRect(Game.WIDTH, 0, 100, Game.HEIGHT);
		// draw the score on the score board.
		g.setColor(Color.black);
		g.drawString("SCORE = " + score, 610, 100);
	}
//	private static void drawDeath(Graphics g){
//		g.setColor(Color.red);
//		g.drawString("YOU DIED", Game.WIDTH/2, Game.HEIGHT/2);
//		// drawing death 
//	}
	
	
	
	
	
	
	
	
	
}
