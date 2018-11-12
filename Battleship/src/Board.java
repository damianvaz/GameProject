import BoatTypes.Boats;

public class Board 
{
	char[][] board;
	int size;
	Boats[] boats = new Boats[10];
	
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
	public void setBoat(Boats boat)
	{
		 int size = boat.getSpaces();
		 int row = boat.getRow();
		 int col = boat.getCol();
		 
		 if (boat.getIsVertical())
		 {
			 for ( int i = 0; i < size; i++)
			 {
				 board[row][col] = boat.getboatChar();
				 row++;
			 }
		 }
		 else
		 {
			 for ( int i = 0; i < size; i++)
			 {
				 board[row][col] = boat.getboatChar();
				 col++;
			 }
		 }				 
	}
	public Boat getBoat(int x int y)
	{
		
	}
	public void setHit(int x, int y)
	{
		board[x][y] = '!';
		
	}
	public void setMiss(int x, int y)
	{
		board[x][y] = 'X';
		
	}
	
	public boolean isValidPlay(Boats boats)
	{
		int row = boats.getRow();
		int col = boats.getCol();
		boolean validPlay = true;
		boolean isVertical = boats.getIsVertical();
		int spaces = boats.getSpaces();
		
		
		if(isVertical)
		{
			for(int i = 0; i < spaces; i++)
			{
				if (row < size)
				{
					if (board[row][col] != ' ')
					{
						validPlay = false;
					}
					row++;
				}
				else
				{
					validPlay = false;
				}
			}
		}
		else
		{
			for(int i = 0; i < spaces; i++)
			{
				if(col < size)
				{
					if (board[row][col] != ' ')
					{
						validPlay = false;
					}
					col++;
				}
				else
				{
					validPlay = false;
				}
			}
		}
		return validPlay;
	}
	
	
}
