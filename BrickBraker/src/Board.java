import java.awt.Color;
import java.awt.Graphics;


public class Board {
	private static final int WIDTH = 600;
	private static final int initialBoardSize = 100;
	private int boardX = 300;
	private int nextMove = 0;
	private int boardSize= initialBoardSize;
	
		public Board (){
		//this.game = game;
	}
	
	public void move(){
		if ((boardX+nextMove*5)>1&&(boardX+nextMove*2)< WIDTH-boardSize){
			boardX=boardX+nextMove*5;
		}
	}
	
	public void drawBoard (Graphics g){
		g.setColor(Color.darkGray);
		g.fillRect(boardX, 580, boardSize, 15);
		
	}
	
	public void setNextMove (int nextMove){
			this.nextMove=nextMove;
	}
	
	public void setSize (int score){
		if(this.boardSize>30){
		this.boardSize=Board.initialBoardSize-5*(score/20);
		
		}
	}
	
	public int getBoardX (){
		return this.boardX;
	}
}


