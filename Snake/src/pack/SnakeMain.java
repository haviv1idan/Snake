package pack;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeMain extends JPanel implements ActionListener {

	private Timer timer;
	private int[][] matrix;
	private Snake snake;
	private Point apple;
	Point last = new Point(14, 32);
	int sHeadRow = 14, sHeadCol = 32;
	int direction = 0;

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public SnakeMain(int time) {
		// TODO Auto-generated constructor stub
		this.timer = new Timer(time, this);
		this.matrix = new int[32][63];
		this.snake = new Snake();
		addKeyListener(new KL());
		setFocusable(true);
		timer.start();
		// this.apple = changeApple();
		this.apple = new Point(14, 40);
		this.matrix[apple.getX()][apple.getY()] = 1;
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == timer) {
			if (direction == 39) // right
			{
				Point nextPoint = new Point(last.getX(), last.getY() + 1);
				if(nextPoint.getX() == -1 || nextPoint.getY() == -1 || nextPoint.getX() == 32 || nextPoint.getY() == 63)
				{
					JOptionPane.showMessageDialog(null,
							"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
					System.exit(0);
				}
				if (nextPoint.isEquelPoints(apple)) {
					snake.updateSnake(nextPoint.getX(), nextPoint.getY());
					sHeadCol++;
					this.matrix[apple.getX()][apple.getY()] = 0;
					this.apple = changeApple();
				} else {
					if (isPointInSnake(sHeadRow, sHeadCol + 1)) {
						JOptionPane.showMessageDialog(null,
								"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
						System.exit(0);
					} else {
						snake.getBody().add(new Point(sHeadRow, sHeadCol + 1));
						sHeadCol++;
						snake.getBody().remove();
					}
				}
			} else if (direction == 38) // up
			{
				Point nextPoint = new Point(last.getX() - 1, last.getY());
				if(nextPoint.getX() == -1 || nextPoint.getY() == -1 || nextPoint.getX() == 32 || nextPoint.getY() == 63)
				{
					JOptionPane.showMessageDialog(null,
							"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
					System.exit(0);
				}
				if (nextPoint.isEquelPoints(apple)) {
					snake.updateSnake(nextPoint.getX(), nextPoint.getY());
					sHeadRow--;
					this.matrix[apple.getX()][apple.getY()] = 0;
					this.apple = changeApple();
				} else {
					if (isPointInSnake(sHeadRow - 1, sHeadCol)) {
						JOptionPane.showMessageDialog(null,
								"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
						System.exit(0);
					} else {
						snake.getBody().add(new Point(sHeadRow - 1, sHeadCol));
						sHeadRow--;
						snake.getBody().remove();
					}
				}
			} else if (direction == 40) // down
			{
				Point nextPoint = new Point(last.getX() + 1, last.getY());
				if(nextPoint.getX() == -1 || nextPoint.getY() == -1 || nextPoint.getX() == 32 || nextPoint.getY() == 63)
				{
					JOptionPane.showMessageDialog(null,
							"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
					System.exit(0);
				}
				if (nextPoint.isEquelPoints(apple)) {
					snake.updateSnake(nextPoint.getX(), nextPoint.getY());
					sHeadRow++;
					this.matrix[apple.getX()][apple.getY()] = 0;
					this.apple = changeApple();
				} else {
					if (isPointInSnake(sHeadRow + 1, sHeadCol)) {
						JOptionPane.showMessageDialog(null,
								"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
						System.exit(0);
					} else {
						snake.getBody().add(new Point(sHeadRow + 1, sHeadCol));
						sHeadRow++;
						snake.getBody().remove();
					}
				}
			} else if (direction == 37) // left
			{
				Point nextPoint = new Point(last.getX(), last.getY() - 1);
				if(nextPoint.getX() == -1 || nextPoint.getY() == -1 || nextPoint.getX() == 32 || nextPoint.getY() == 63)
				{
					JOptionPane.showMessageDialog(null,
							"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
					System.exit(0);
				}
				if (nextPoint.isEquelPoints(apple)) {
					snake.updateSnake(nextPoint.getX(), nextPoint.getY());
					sHeadCol--;
					this.matrix[apple.getX()][apple.getY()] = 0;
					this.apple = changeApple();
				} else {
					if (isPointInSnake(sHeadRow, sHeadCol - 1)) {
						JOptionPane.showMessageDialog(null,
								"Game Over...You Finish The Game :(\nYour lenght = " + snake.getLen());
						System.exit(0);
					} else {
						snake.getBody().add(new Point(sHeadRow, sHeadCol - 1));
						sHeadCol--;
						snake.getBody().remove();
					}
				}
			}
			last = new Point(sHeadRow, sHeadCol);
			repaint();// this will call at every 1 second
		}
	}

	class KL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyCode());
			if (e.getKeyCode() >= 37 && e.getKeyCode() <= 40)
				if (direction == 37 && e.getKeyCode() == 39)
					direction = 37;
				else if (direction == 39 && e.getKeyCode() == 37)
					direction = 39;
				else if (direction == 38 && e.getKeyCode() == 40)
					direction = 38;
				else if (direction == 40 && e.getKeyCode() == 38)
					direction = 40;
				else
					direction = e.getKeyCode();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.WHITE);
		Font font = new Font("Verdana", Font.BOLD, 16);
		g.setFont(font);
		g.drawString("lenght = " + snake.getLen(), 10, 20);
		// g.fillRect(10, 0, 100, 20);
		int cell = 30;
		int x = 10, y = 40;
		g.setColor(Color.RED);
		// int rowsCount = 0, colsCount = 0;
		int row = -1, col = -1;
		while (y + cell < getHeight()) {
			// rowsCount++;
			row++;
			g.drawLine(x, y, x, y + cell);
			while (x + cell < getWidth()) {
				col++;
				//g.drawLine(x, y, x + cell, y);
				if(row == 0)
					g.drawLine(x, y, x + cell, y);
				g.setColor(Color.GREEN);
				if (isPointInSnake(row, col))
					g.fillRect(x, y, cell, cell);
				if (this.matrix[row][col] == 1) {
					g.setColor(Color.RED);
					g.fillOval(x + 5, y + 5, cell - 10, cell - 10);
				}
				g.setColor(Color.RED);
				x += cell;
			}
			g.drawLine(x, y, x, y + cell);
			x = 10;
			col = -1;
			y += cell;
		}
		while (x + cell < getWidth()) {
			// colsCount++;
			g.drawLine(x, y, x + cell, y);
			x += cell;
		}
		// System.out.println("rows = " + rowsCount + " cols = " + colsCount);
	}
	
	public Point changeApple() {
		Random rnd = new Random();
		int col, row;
		while (true) {
			col = rnd.nextInt(63);
			row = rnd.nextInt(32);
			if (!isPointInSnake(row, col))
				break;
		}
		this.matrix[row][col] = 1;
		return new Point(row, col);
	}

	public boolean isPointInSnake(int row, int col) {
		boolean flag = false;
		int i = this.snake.getLen();
		while (i > 0) {
			if (row == this.snake.getBody().peek().getX() && col == this.snake.getBody().peek().getY())
				flag = true;
			this.snake.getBody().add(this.snake.getBody().remove());
			i--;
		}
		return flag;
	}
}