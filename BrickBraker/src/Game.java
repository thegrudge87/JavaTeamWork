import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class Game extends Canvas implements Runnable{
	public static final int ROWS = 30;
	public static final int COLS = 30;
	public static final int SIZE = 20;
	public static final int WIDTH = COLS*SIZE;
	public static final int HEIGHT = ROWS*SIZE;
	
	private Ball ball;
	public static Board board;
	public static int threadSpeed;
	public static int score;
	
	//add bricks
	public static Bricks bricks;
	
	private Thread runThread;
	public static Graphics globalGraphics;
	
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
		score = 0;
		bricks = new Bricks();
		threadSpeed = 10;
	}
	
	public void run(){
		while (gameRunning){
			ball.tick();
			board.move();
			render(globalGraphics);
			try {
				Thread.sleep(threadSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.drawDeath(globalGraphics);// the text when you dead
	}
	public static void changeSpeed(){
		if(score % 60 == 0 && threadSpeed > 3 ){
			threadSpeed -= 1;
			
		}
	}
	
	public void render(Graphics g){
		g.clearRect(0, 0, WIDTH, HEIGHT);
		ball.drawBall(g);
		board.drawBoard(g);
		
		bricks.drawBricks(g);
		this.drawScore(g);
	}
	
	public void drawScore(Graphics g){
		// set the score board background color
		g.drawString("score = " + score, 15, 590);
		g.setColor(Color.black);
		g.setColor(Color.gray);
		g.fillRect(Game.WIDTH, 0, 100, Game.HEIGHT);
		g.setColor(Color.darkGray);
		g.drawRect(Game.WIDTH, 0, 100, Game.HEIGHT);
	}
	private static void drawDeath(Graphics g){
		g.setColor(Color.red);
		g.drawString("YOU DIED", Game.WIDTH/2, Game.HEIGHT/2);
		// drawing death 
	}
	
	
	
	
	
	
	
	
	
}
