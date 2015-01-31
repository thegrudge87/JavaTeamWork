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
	
	private Thread runThread;
	public Graphics globalGraphics;
	
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
	}
	
	public void run(){
		while (gameRunning){
			ball.tick();
			render(globalGraphics);
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void render(Graphics g){
		g.clearRect(0, 0, WIDTH, HEIGHT);
		ball.drawBall(g);
		this.drawScore(g);
	}
	
	public void drawScore(Graphics g){
		// set the score board background color
		g.setColor(Color.gray);
		g.fillRect(Game.WIDTH, 0, 100, Game.HEIGHT);
		g.setColor(Color.darkGray);
		g.drawRect(Game.WIDTH, 0, 100, Game.HEIGHT);
	}
	
	
	
	
	
	
	
	
	
}
