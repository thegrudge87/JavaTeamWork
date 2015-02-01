import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


@SuppressWarnings("serial")
public class GameApp extends Applet{
	private Game game;
	InputHandler keyReader;
	
	public void init(){
		game = new Game();
		// Set the size of the canvas (game field). 
		// Shouldn't be bigger than applet size
		//WIDTH+100 for the scoreboard
		game.setPreferredSize(new Dimension(Game.WIDTH+100, Game.HEIGHT));
		game.setBackground(Color.getHSBColor(0.56f, 0.3f, 0.8f));
		
		// make the window visible
		game.setVisible(true);
		// make the window on focus
		game.setFocusable(true);
		this.add(game);
		this.setVisible(true);
		keyReader= new InputHandler(game);
		
	}
	
	public void paint(Graphics g){
		// set the size of the applet (game window)
		this.setSize(new Dimension(800, 650));
	}
}
