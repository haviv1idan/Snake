package pack;

import java.util.Queue;
import java.util.LinkedList;

public class Snake {

	private int len;
	private Queue<Point> sBody;

	public Snake() {
		// TODO Auto-generated constructor stub
		this.len = 5;
		this.sBody = new LinkedList<Point>();
		sBody.add(new Point(14, 28));
		sBody.add(new Point(14, 29));
		sBody.add(new Point(14, 30));
		sBody.add(new Point(14, 31));
		sBody.add(new Point(14, 32));
	}
	
	public void updateSnake(int row,int col)
	{
		sBody.add(new Point(row,col));
		this.len++;
	}
	
	public Queue<Point> getBody() {
		return this.sBody;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}
}
