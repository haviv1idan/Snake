package pack;

public class Point {

	private int x;
	private int y;
	
	Point(int x1,int y1)
	{
		this.x = x1;
		this.y = y1;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isEquelPoints(Point p2)
	{
		return (this.x == p2.getX() && this.y == p2.getY());
	}
}
