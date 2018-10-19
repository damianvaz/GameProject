package jogoDaVelha;

public final class Minimax 
{
	private static Action bestActionForX;
	private static Action bestActionForO;
	private static Action bufferAction;
	private static int max = -10;
	private static int min = 10;
	private static Board bufferBoard;
	
	private Minimax()
	{
		// do not instantiate
	}
	public static Action minimax(Board board) 
	{
		maxValue(board);
		//return bestActionForO;
		return bufferAction;


	}
	
	public static void clean()
	{
		bestActionForX = null;
		bestActionForO = null;
		//max = -10;
		//min = 10;
	}
	public static int maxValue(Board board)
	{
		// if its a terminal state
		if(board.isGameOver())
		{

			char winner = board.whoWon();
			if (winner == 'O')
			{
				return 1;
			}
			else if (winner == 'X')
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
		
		Action[] actions = board.possiblePlays();
		
		for(int i = 0; i < actions.length; i++)
		{
			char[][] bb = new char[3][3];
			// make copy of array
			for(int j=0;j<board.getArrayBoard().length; j++)
			{
				for (int k=0;k<board.getArrayBoard()[j].length;k++)
				{
					bb[j][k] = board.getArrayBoard()[j][k];
				}
			}
			Board possibleBoard = new Board(board.getTurn(), bb);
			bufferBoard = possibleBoard;
			System.out.println(board.getTurn());
			possibleBoard.setBoard('O', actions[i].getAction()[0], actions[i].getAction()[1]);
			if (i==0)
			{
				System.out.println("PRIMEIRA ACAO");
				possibleBoard.printBoard();
			}
			if (i==1)
			{
				System.out.println("SEGUNDA ACAO");
				possibleBoard.printBoard();
			}
			if (max < minValue(possibleBoard))
			{
				max = minValue(possibleBoard);
				bestActionForO = actions[i];
				bufferAction = actions[i];
				System.out.println("" + actions[i].getAction()[0] + ", " + actions[i].getAction()[1]);
			}
		}
		System.out.println("TERMINOUMAXVALUE");
		if(!board.isGameOver())
		{
			clean();
		}
		return max;
	}
	
	public static int minValue(Board board)
	{
		if(board.isGameOver())
		{
			char winner = board.whoWon();
			if (winner == 'O')
			{
				return 1;
			}
			else if (winner == 'X')
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
		
		
		Action[] actions = board.possiblePlays();
		char[][] bb = new char[3][3];
		// make copy of array
		
		for(int i = 0; i < actions.length; i++)
		{
			for(int j = 0;j < board.getArrayBoard().length; j++)
			{
				for (int k = 0;k < board.getArrayBoard()[j].length;k++)
				{
					bb[j][k] = board.getArrayBoard()[j][k];
				}
			}
			Board possibleBoard = new Board(board.getTurn(), bb);
			possibleBoard.setBoard('X', actions[i].getAction()[0], actions[i].getAction()[1]);
			if (min > maxValue(possibleBoard))
			{
				min = maxValue(possibleBoard);
				bestActionForX = actions[i];
			}
		}
		//System.out.println("MAx in MIN is: " + max + " Min in Min is: " + min);
		//board.printBoard();
		if(!board.isGameOver())
		{
			clean();
		}
		return min;
	}
	

}
