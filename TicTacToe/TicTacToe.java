import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe
{	
	private TicTacToeMainFrame frame;
	
	public TicTacToe()
	{
		Game game = new Game();
		TicTacToeMainFrame f = new TicTacToeMainFrame(game);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setVisible(true);
	}
}

