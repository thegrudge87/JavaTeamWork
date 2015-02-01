import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;


public class Bricks {

	public static LinkedList<Brick> body;
	
	public Bricks(){
		body = new LinkedList<>();
		Collections.addAll(body, 
				new Brick(0, 0),
				new Brick(1, 0),
				new Brick(2, 0),
				new Brick(3, 0),		
				new Brick(4, 0),
				new Brick(5, 0),
				new Brick(6, 0),
				new Brick(7, 0),	
				new Brick(8, 0),
				new Brick(9, 0),	
				new Brick(10, 0),
				new Brick(11, 0)
				);
	}
	
	public void drawBricks(Graphics g){
		for (Brick brick : body) {			
			//Draw each brick
			g.setColor(Color.BLUE);
			g.fillRect(brick.x * brick.BRICK_SIZE, brick.y * brick.BRICK_SIZE, 
					brick.BRICK_SIZE, brick.BRICK_SIZE);
			
			//Draw the border of each brick
			g.setColor(Color.black);
			g.drawRect(brick.x * brick.BRICK_SIZE, brick.y * brick.BRICK_SIZE, 
					brick.BRICK_SIZE, brick.BRICK_SIZE);
		}
	}
	
}
