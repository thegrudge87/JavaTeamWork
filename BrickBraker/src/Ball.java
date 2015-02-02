import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	public static BoxBall ball;
	//public static Game.board board;
	private int xDirection, yDirection;
	private int ballSpeed;
	public Ball(){
		//here is where we set the ball starting point
		ball = new BoxBall(570,350);
		ballSpeed = 2;// The ball speed
		xDirection = -ballSpeed;
		yDirection = -ballSpeed;
		
	}
	
	public void drawBall(Graphics g){
		BoxBall box = ball;
		g.setColor(Color.black);
		g.fillOval(box.x, box.y, 20,20);
	}
	
	public void tick(Bricks bricks_h){
		//while(Game.gameRunning){
		int boardx = Game.board.getBoardX();
		
		//The ball hits the board
		if(ball.x>=boardx && ball.x<=boardx+100&&ball.y>Game.HEIGHT-40){
			yDirection = -ballSpeed;
		}
		
		//The ball hits to the right 
		else if(ball.x == Game.WIDTH-20){
			xDirection = -ballSpeed;// The ball speed is 1
		}
		//The ball hits to the right 
		else if(ball.x == 0){
			xDirection = ballSpeed;
			
		}
		//The ball hits to bottom 
		else if(ball.y == Game.HEIGHT-20){
			//yDirection = -1;
			Game.gameRunning = false;
		}
		//The ball hits to the top
		//if(ball.y == bricks_h.body.getFirst().BRICK_SIZE){
		else if(ball.y == 50){ // 50 is the size of the brick
			for (Brick brick : bricks_h.body) {
				if (brick.x == (ball.x/50)) {
					yDirection = ballSpeed;
					bricks_h.body.remove(brick);
					Game.score += 10; // add score on each hit with a brick
					break;					
				}
			}
		} else if(ball.y == 0) {
			yDirection = ballSpeed;
		}
		
		//Second way. We could use it if randomize the ball start.
//		else if(ball.y <=50){ // 50 is the size of the brick
//			boolean foundBrick = false;
//			for (Brick brick : bricks_h.body) {
//				if (brick.x == (ball.x/50)) {
//					foundBrick = true;
//					bricks_h.body.remove(brick);
//					break;					
//				}			
//			}
//			if(foundBrick){//break the brick
//				yDirection = ballSpeed;
//			} else if(ball.y == 0) {
//				yDirection = ballSpeed;
//			}						
//		}
		//Board v = Game.board;
		
		BoxBall nextPos = new BoxBall(ball.x+xDirection, ball.y+yDirection);
		ball = nextPos;
		
		
		//}
		
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
