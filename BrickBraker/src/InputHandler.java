
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener { 
		
	public InputHandler(Game game)	{
		game.addKeyListener(this);
	}
	
		@Override
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				Game.board.setNextMove (-1);//The board speed is 1
			}
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				Game.board.setNextMove (1);
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			Game.board.setNextMove (0);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
	
}
