public class Brick {
	public int x, y;
	public static final int BRICK_SIZE = 50;
	
	public Brick(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){		
		return "[x=" + x + ", y=" + y + "]";
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Brick) {
			Brick b = (Brick)obj;
			return(this.x == b.x && this.y == b.y );
		}
		return false;
	}
}