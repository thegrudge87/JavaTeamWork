import java.awt.Canvas;
import java.awt.Graphics;


public class Game extends Canvas implements Runnable{
	private Ball ball;
	
	private Thread runThread;
	private Graphics globalGraphics;
	static boolean gameRunning = false;
	
	public void paint(Graphics g){
		globalGraphics = g.create();
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
			//ball.tick();
			render(globalGraphics);
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void render(Graphics g){
		ball.drawBall(g);
	}
}
