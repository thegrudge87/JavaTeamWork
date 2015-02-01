import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	public static BoxBall ball;
	private int xDirection, yDirection;
	public Ball(){
		ball = new BoxBall(570,350);
		xDirection = -1;
		yDirection = -1;
		
	};
	
	public void drawBall(Graphics g){
		BoxBall box = ball;
		g.setColor(Color.black);
		g.fillOval(box.x, box.y, 20,20);
	}
	
	public void tick(){
		int boardx = Game.board.getBoardX(); 
		for (Brick brick : Bricks.body) {
			//int xBrick = (brick.x+1)*Brick.BRICK_SIZE;
			int yBrick = (brick.y+1)*Brick.BRICK_SIZE;
			if(ball.y==yBrick){
				Game.score += 10;  //add score
				Game.changeSpeed();
				yDirection = 1;
			}
			//if(ball.x==xBrick){
			//}
		}
		
		if(ball.x>=boardx && ball.x<=boardx+100&&ball.y>Game.HEIGHT-40){
			yDirection = -1;
		}
		if(ball.x == Game.WIDTH-20){
			xDirection = -1;
		}
		if(ball.x == 0){
			xDirection = 1;
		}
		if(ball.y == Game.HEIGHT-20){
			//yDirection = -1;
			Game.gameRunning = false;
			
		}
		if(ball.y == 0){
			yDirection = 1;
		}
		
		BoxBall nextPos = new BoxBall(ball.x+xDirection, ball.y+yDirection);
		ball = nextPos;
		
	}

	public int getxDirection() {
		return xDirection;
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
}

