package jogoDaVelha;

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Game game = new Game();
		
		
		Scanner in = new Scanner(System.in);
		// While game isn't over
		while(!game.getBoard().isGameOver())
		{
			System.out.println("Enter row of play");
			int row = in.nextInt();
			System.out.println("Enter col of play");
			int col = in.nextInt();
			game.makeMove(row, col);
			game.getBoard().printBoard();
			//if game still not over
			/*
			char [][] testeBoardChar = new char[][]
			{
				{'X', ' ', 'X'},
				{' ', 'O', ' '},
				{'O', ' ', 'X'},
			};
			
			*/
			//Board teste = new Board(testeBoardChar);
			//char a = teste.whoWon();
			//System.out.println("venceu   !!! " + a);
			Action Move = Minimax.minimax(game.getBoard());
			game.makeMove(Move.getAction()[0], Move.getAction()[1]);
			game.getBoard().printBoard();
			//System.out.println("Ação " + Move.getAction()[0] + Move.getAction()[1]);
			/*
			if(!game.getBoard().isGameOver())
			{
				char[][] board = new char[3][3];
				for(int i=0;i<game.getBoard().getArrayBoard().length; i++)
				{
					for (int j=0;j<game.getBoard().getArrayBoard()[i].length;j++)
					{
						board[i][j] = game.getBoard().getArrayBoard()[i][j];
					}
				}
				Board bb = new Board(game.getBoard().getTurn(), board);
				bb.printBoard();
				Action PcMove = Minimax.minimax(bb);
				System.out.println("" + PcMove.getAction()[0] + ", " + PcMove.getAction()[1]);
				game.makeMove(PcMove.getAction()[0], PcMove.getAction()[1]);
				game.getBoard().printBoard();
				Minimax.clean();
			}
			
		*/
		}
		in.close();
		
	}
	
}
