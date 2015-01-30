import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class GameApp extends Applet{
	private Game game;
	
	public void init(){
		game = new Game();
		// Set the size of the canvas (game field). 
		// Shouldn't be bigger than applet size
		game.setPreferredSize(new Dimension(600, 625));
		// make the window visible.
		game.setVisible(true);
		// make the window on focus
		game.setFocusable(true);
		this.add(game);
		this.setVisible(true);
		
	}
	
	public void paint(Graphics g){
		// set the size of the applet (game window)
		this.setSize(new Dimension(800, 650));
	}
}
