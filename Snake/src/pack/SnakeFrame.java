package pack;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SnakeFrame extends JFrame{

	public SnakeFrame(int t)
	{	
		SnakeMain sm = new SnakeMain(t);
		add(sm);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(false);
		setVisible(true);
		setFocusable(false);

	}
	
	public static int  menu()
	{
		String[] options =  {"Easy", "Medium", "Hard","Exit"};
		int response = JOptionPane.showOptionDialog(null, "Choose Type Game ",null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		
		switch(response)
		{
			case -1:
				System.out.println("Option Dialog Window Was Closed");
				System.exit(0);
			case 0:
				return 100;
			case 1:
				return 75;
			case  2:
				return 50;
			default:
				return 100;		
		}

	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = menu();
		new SnakeFrame(t);
	}
}
