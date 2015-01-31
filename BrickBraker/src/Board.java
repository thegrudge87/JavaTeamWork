import java.awt.Color;
import java.awt.Graphics;


public class Board {
	private int x = 300;
	private int xm = 1;
	private int boardSize = 100;
	
		public Board (){
		//this.game = game;
	}
	
	public void move(){
		if ((x+xm)>1&&(x+xm)< 600-boardSize){
			x=x+xm;
		}
	}
	
	public void drawBoard (Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(x, 580, boardSize, 15);
		
	}
	
	public void setNextMove (int xm){
			this.xm=xm;
	}
	
	public void setSize (int size){
		this.boardSize=size;
}
	
}
