import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe
{
	
	public static void makeNewGame(Game game, TicTacToeMainFrame f)
	{
		char player = f.getPlayer();
		char opponent;
		opponent = player == 'X' ? 'O' : 'X';
		while (!game.getBoard().isGameOver())
		{
			if (player == 'X')
			{
				f.hideLabelThinking();
				while (!f.isActionSet())
				{
					f.revalidateFrame();
					;
				}

				Action newAction = f.getAction();
				f.clearAction();
				game.makeMove(newAction.getAction()[0], newAction.getAction()[1]);

				if (game.getBoard().isGameOver())
				{
					break;
				}
				f.showLabelThinking();
				Minimax AI = new Minimax(game.getBoard(), 'O');
				Action Move = AI.getBestChoice();
				game.makeMove(Move.getAction()[0], Move.getAction()[1]);
				f.setButtonText(Move.getAction()[0], Move.getAction()[1]);
			} else
			{
				f.showLabelThinking();
				Minimax AI = new Minimax(game.getBoard(), 'X');
				Action Move = AI.getBestChoice();
				game.makeMove(Move.getAction()[0], Move.getAction()[1]);
				f.setButtonText(Move.getAction()[0], Move.getAction()[1]);
				f.hideLabelThinking();
				if (game.getBoard().isGameOver())
				{
					break;
				}

				while (!f.isActionSet())
				{
					f.revalidateFrame();
					// waiting for action
				}
				Action newAction = f.getAction();
				f.clearAction();
				game.makeMove(newAction.getAction()[0], newAction.getAction()[1]);
			}
		}
		String message;
		if (game.getBoard().whoWon() == player)
		{
			message = "Congratulations!! You Won!!";
			
		} else if (game.getBoard().whoWon() == opponent)
		{
			message = "Too bad! Try next time!";
		} else
		{
			message = "oh oh StaleMate!";
		}
		Object[] options1 =
		{ "New Game", "Cancel" };

		int mode = JOptionPane.showOptionDialog(null, message, "Game Over", JOptionPane.YES_NO_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options1, null);
		if (mode == JOptionPane.YES_OPTION)
		{
			game = new Game();
			f.clearFrame();
			f = new TicTacToeMainFrame();
			player = f.getPlayer();
			opponent = player == 'X' ? 'O' : 'X';
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.pack();
			f.setVisible(true);
			makeNewGame(game, f);

		} else
		{
			f.dispose();
		}
	}

	public static void startGame()
	{
		Game game = new Game();
		TicTacToeMainFrame f = new TicTacToeMainFrame();
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		makeNewGame(game, f);
	}

	public static void main(String[] args)
	{
		startGame();
	}

}
