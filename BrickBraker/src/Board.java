
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Board {
	int x = 0;
	int xm = 1;
	int size = 80;
	
	private Game game;
	
	
	public Board (Game game){
		this.game = game;
	}
	
	public void move(){
		if ((x+xm)>1&&(x+xm)<game.getWidth()-181){
			x=x+xm;
		}
	}
	
	public void drawBoard (Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(x, 580, size, 15);
		
	}
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			xm = -1;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			xm = 1;
		}
	}
	public void keyReleased(KeyEvent e) {
			xm = 0;
	}
	
}


