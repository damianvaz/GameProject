import java.util.Scanner;

public class Game 
{
	
	private int turn =0;
	private Board board = new Board();
	private char player;
	
	
	public Game()
	{
		
	}
	
	public Board getBoard()
	{
		return this.board;
	}
	
	

	public void makeMove(int row, int col)
	{
		turn++;
		while(!board.isValidPlay(row, col))
		{
			Scanner teclado = new Scanner(System.in);
			System.out.println("Enter row of play");
			row = teclado.nextInt();
			System.out.println("Enter col of play");
			col = teclado.nextInt();
		}
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
