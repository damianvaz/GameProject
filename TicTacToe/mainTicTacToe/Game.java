package mainTicTacToe;
import java.util.Scanner;

public class Game 
{
	
	private int turn =0;
	private TicTacToeBoard board = new TicTacToeBoard();
	private char player;
	
	
	public Game()
	{
		
	}
	
	public TicTacToeBoard getBoard()
	{
		return this.board;
	}
	
	

	public void makeMove(int row, int col)
	{
		turn++;
		board.setBoard(this.getPlayer(), row, col);
	}
	public char getPlayer()
	{
		if (turn % 2 == 0)
		{
			player = 'O';
			return player;
		}
		else 
		{
			player = 'X';
			return player;
		}
	}
	
	
}
