import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;


public class Bricks {

	public static LinkedList<Brick> body;
	
	public Bricks(){
		body = new LinkedList<>();
		//WIDTH = 600, 600/12=50 for each brick.
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
	
	@SuppressWarnings("static-access")
	public void drawBricks(Graphics g){
		for (Brick brick : body) {			
			//Draw each brick [initial color was BLUE]
			g.setColor(new Color(150,25,14));
			g.fillRect(brick.x * brick.BRICK_SIZE, brick.y * brick.BRICK_SIZE, 
					brick.BRICK_SIZE, brick.BRICK_SIZE);
			
			//Draw the border of each brick [initial color was BLACK]
			g.setColor(new Color(174,137,118));
			g.drawRect(brick.x * brick.BRICK_SIZE, brick.y * brick.BRICK_SIZE, 
					brick.BRICK_SIZE, brick.BRICK_SIZE);
		}
	}	
}