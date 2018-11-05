import BoatTypes.Boats;

public class Board 
{
	char[][] board;
	int size;
	public Board(int size)
	{
		this.size = size;
		board = new char[size][size];
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
			 	board[i][j] =' ';
			}
		}
	}
	public void printBoard()
	{
		for( int i = 0; i < this.size; i++)
		{
			System.out.print("|");
			for (int j = 0; j < this.size; j++)
			{
				System.out.print("" + board[i][j]);
			}
			System.out.println("|");
		}
	}
	public void setBoat(Boats boat, boolean isVertical, int x, int y)
	{
		 int size = boat.getSpaces();
		 if (isVertical)
		 {
			 for ( int i = 0; i < size; i++)
			 {
				 board[x][y] = boat.getboatChar();
				 x++;
			 }
		 }
		 else
		 {
			 for ( int i = 0; i < size; i++)
			 {
				 board[x][y] = boat.getboatChar();
				 y++;
			 }
		 }				 
	}
	
	
}
