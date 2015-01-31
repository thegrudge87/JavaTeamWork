public class BoxBall {
	public int x,y;
	public static final int BOX_SIZE = 20;
	
	public BoxBall(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof BoxBall){
			BoxBall b = (BoxBall) obj;
			return (this.x==b.x && this.y==b.y);
		}
		return false;
	}

}
