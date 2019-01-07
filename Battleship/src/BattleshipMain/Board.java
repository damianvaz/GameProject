package BattleshipMain;
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

	public void setBoat(Boats boat)
	{
		 int size = boat.getSpaces();
		 int row = boat.getRowBegin();
		 int col = boat.getColBegin();
		 
		 if(boat.getIsComplexShape())
		 {
			 if(boat.getName().equals("Battleship"))
			 {
				 if(boat.getIsVertical())
				 {
					 board[row + 1][col + 1] = boat.getboatChar();
					 for ( int i = 0; i < size - 1; i++)
					 {
						 board[row][col] = boat.getboatChar();
						 row++;
					 }
				 }
				 else
				 {
					 board[row - 1][col + 1] = boat.getboatChar();
					 for ( int i = 0; i < size - 1; i++)
					 {
						 board[row][col] = boat.getboatChar();
						 col++;
					 }
				 }
			 }
			 else
			 {
				 if (boat.getIsVertical())
				 {
					 board[row][col + 1] = boat.getboatChar();
					 for ( int i = 0; i < size - 1; i++)
					 {
						 board[row][col] = boat.getboatChar();
						 row++;
					 }
				 }
				 else
				 {
					 board[row + 1][col + 1] = boat.getboatChar();
					 for ( int i = 0; i < size - 1; i++)
					 {
						 board[row][col] = boat.getboatChar();
						 col++;
					 }
				 }
			 }
		 }
		 else
		 {
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
		int row = boats.getRowBegin();
		int col = boats.getColBegin();
		boolean validPlay = true;
		boolean isVertical = boats.getIsVertical();
		int spaces = boats.getSpaces();
		
		if(boats.getIsComplexShape())
		{
			if(spaces == 4)
			{
				if (isVertical)
				{
					if (col + 1 > size - 1 || row + 1 > size - 1)
					{
						validPlay = false;
					}
					else if (board[row + 1][col + 1] != ' ')
					{
						validPlay = false;
					}
				}
				else
				{
					if (row - 1 < 0)
					{
						validPlay = false;
					}
					else if (col + 1 > size -1)
					{
						validPlay = false;
					}
					else if (board[row - 1][col + 1] != ' ')
					{
						validPlay = false;
					}
				}
			}
			else
			{
				if (isVertical)
				{
					if (col + 1 > size - 1)
					{
						validPlay = false;
					}
					else if (board[row][col + 1] != ' ')
					{
						validPlay = false;
					}
				}
				else
				{
					if (row + 1 > size - 1 || col + 1 > size - 1)
					{
						validPlay = false;
					}
					else if (board[row + 1][col + 1] != ' ')
					{
						validPlay = false;
					}
				}
			}
			spaces--;
		}
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
