import java.awt.Color;
import java.awt.Graphics;


public class gameMessages {
	public static void drawNewGame(Graphics g){
		g.setColor(Color.green);
		g.drawString("Start a new game", Game.WIDTH, Game.HEIGHT); 
	}
}
