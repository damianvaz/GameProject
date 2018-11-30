import java.util.ArrayList;

public class Minimax
{
	// Player is AIPlayer and opponent is Human Player
	private char playerAI, opponent;
	// private TicTacToeBoard gameBoard;
	public Action bestChoice;

	public int endGameScore(TicTacToeBoard gameBoard)
	{
		System.out.println("Reached End Game Player who won: " + gameBoard.getPlayer());
		if (gameBoard.whoWon() == playerAI)
		{
			System.out.println("DETECTED AI WON");
			return 10;
		} 
		else if (gameBoard.whoWon() == opponent)
		{
			System.out.println("DETECTED OPPONENT WON");
			return -10;
		} 
		else
		{
			System.out.println("Detected Draaaaaww!");
			return 0;
		}
	}

	public Action getBestChoice()
	{
		return this.bestChoice;
	}

	public Minimax(TicTacToeBoard board, char playerAI)
	{
		this.playerAI = playerAI;
		if (playerAI == 'O')
		{
			opponent = 'X';
		} else
		{
			opponent = 'O';
		}
		// making new board
		char[][] boardArrayChar = new char[3][3];
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				boardArrayChar[i][j] = board.getArrayBoard()[i][j];
			}
		}
		TicTacToeBoard receivedBoard = new TicTacToeBoard(boardArrayChar);
		minimax(receivedBoard);
	}

	public int minimax(TicTacToeBoard boardR)
	{
		// making new board
		char[][] boardArrayChar = new char[3][3];
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				boardArrayChar[i][j] = boardR.getArrayBoard()[i][j];
			}
		}
		TicTacToeBoard board = new TicTacToeBoard(boardArrayChar);
		if (board.isGameOver())
		{
			return endGameScore(board);
		}

		ArrayList<Integer> scores = new ArrayList<Integer>();
		// ArrayList<Action> storeMoves = new ArrayList<Action>();

		Action[] moves = board.possiblePlays();
		// making new board
		char[][] boardReceivedCharArray = new char[3][3];
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				boardReceivedCharArray[i][j] = board.getArrayBoard()[i][j];
			}
		}
		
		// populate array scores
		for (int i = 0; i < moves.length; i++)
		{
			int x = moves[i].getAction()[0];
			int y = moves[i].getAction()[1];
			char player = board.getPlayer();
			char[][] copiedCharArray = new char[3][3];
			for (int j = 0; j < 3; j++)
			{
				for (int k = 0; k < 3; k++)
				{
					copiedCharArray[j][k] = boardReceivedCharArray[j][k];
				}
			}
			TicTacToeBoard possibleBoard = new TicTacToeBoard(copiedCharArray, player, x, y);
			System.out.println("POSSSSSWSSSSSSSSSIBLE BOARD:  ___________________________________________");
			possibleBoard.printBoard();
			scores.add(minimax(possibleBoard));
			// list of moves
			// storeMoves.add(moves[i]);
		}
		/*
		for (int i = 0; i < moves.length; i++)
		{
			System.out.println(
					"Scores: " + scores.get(i) + " Move: " + moves[i].getAction()[0] + ", " + moves[i].getAction()[1]);

		}
		*/
		System.out.println("DONE -----------------------------------------------------------------------------------");
		scores.trimToSize();
		char player = board.getPlayer();
		// Decide between choosing min or max Calculation
		if (player == playerAI)
		{
			System.out.println("decided to do MAX, Player: " + player);
			// Do max
			int maxScoreIsAt = 0;
			int max = -10;
			Integer[] scoresArray = scores.toArray(new Integer[scores.size()]);
			for (int i = 0; i < scoresArray.length; i++)
			{
				if ((int) scoresArray[i] > max)
				{
					max = (int) scoresArray[i];
					maxScoreIsAt = i;
					bestChoice = moves[i];
				}
			}
			return (int) scoresArray[maxScoreIsAt];
		} 
		else
		{
			System.out.println("Decided to do MIN, Player: " + player);
			// Do min
			int minScoreIsAt = 0;
			int min = 10;
			Integer[] scoresArray = scores.toArray(new Integer[scores.size()]);
			for (int i = 0; i < scoresArray.length; i++)
			{
				if ((int) scoresArray[i] < min)
				{
					min = (int) scoresArray[i];
					minScoreIsAt = i;
					bestChoice = moves[i];
				}
			}
			return (int) scoresArray[minScoreIsAt];
		}
	}

}