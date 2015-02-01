import java.awt.Color;
import java.awt.Graphics;


public class Board {
	private static final int WIDTH = 600;
	private int boardX = 300;
	private int nextMove = 0;
	private int boardSize = 100;
	
		public Board (){
		//this.game = game;
	}
	
	public void move(){
		if ((boardX+nextMove)>1&&(boardX+nextMove*2)< WIDTH-boardSize){
			boardX=boardX+nextMove;
		}
	}
	
	public void drawBoard (Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(boardX, 580, boardSize, 15);
		
	}
	
	public void setNextMove (int nextMove){
			this.nextMove=nextMove;
	}
	
	public void setSize (int size){
		if(size>40){
		this.boardSize=this.boardSize-size;
		}
	}
	
	public int getBoardX (){
		return this.boardX;
	}
}


