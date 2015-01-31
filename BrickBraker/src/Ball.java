import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	public static BoxBall ball;
	public Ball(){
		ball = new BoxBall(570,600);
	};
	
	public void drawBall(Graphics g){
		BoxBall box = ball;
		g.setColor(Color.black);
		g.fillOval(box.x, box.y, 20,20);
	}
	
	public void tick(){
		BoxBall nextPos = new BoxBall(ball.x-1, ball.y-1);
		ball = nextPos;
		
	}
}

