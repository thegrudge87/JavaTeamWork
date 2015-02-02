import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


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
	public static gameMessages msg; // for all messages
	
	static boolean gameRunning = false;
	
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
		msg = new gameMessages();
		score = 0;
		bricks = new Bricks();
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		
		//msg.drawNewGame(globalGraphics);
		
		while (gameRunning){
			ball.tick(bricks);
			board.move();
			render(globalGraphics);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.drawDeath(globalGraphics);// the text when you dead
	}
		
	public void render(Graphics g){
		this.drawScore(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		ball.drawBall(g);
		board.drawBoard(g);
		bricks.drawBricks(g);
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
	private static void drawDeath(Graphics g){
		g.setColor(Color.red);
		g.drawString("YOU DIED", Game.WIDTH/2, Game.HEIGHT/2);
		// drawing death 
	}
	
	
	
	
	
	
	
	
	
}
