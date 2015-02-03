import java.awt.Color;
import java.awt.Graphics;


public class GameMessages {
	public static void string (Graphics g, String str, String color){
		switch (color) {
		case "green":
			g.setColor(Color.green);
			break;
		case "red":
			g.setColor(Color.red);
			break;

		default:
			break;
		}
		g.drawString(str, Game.WIDTH/2, Game.HEIGHT/2); 
	}
}
