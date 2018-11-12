package BoatTypes;
import java.util.Random;

public class Boats 
{
	String name;
	int spaces;
	char boatChar;
	int row;
	int col;
	boolean isVertical = false;
	boolean[] isHit;
	boolean isSunk;
	
	
	public void setBoatVar(int row, int col, boolean isVertical)
	{
		this.row = row;
		this.col = col;
		this.isVertical = isVertical;
		this.isSunk = false;
	}
	public void setHit(int space)
	{
		isHit[space] = true;
		System.out.println("Boat hit");
		boolean sunk = true;
		for (int i = 0; i < spaces; i++)
		{
			if (!isHit[i])
			{
				sunk = false;
			}
		}
		this.isSunk = sunk;
		if (sunk)
		{
			System.out.println("Boat sunk!");
		}
	}
	public boolean isBoatHere(int x, int y)
	{
		boolean isHere = false;
		if (isVertical)
		{
			if (this.col == y && (this.row >= x || this.row < x))
			{
				isHere = true;
			}
		}
		return isHere;
	}
	public String getName()
	{
		return name;
	}
	public int getSpaces()
	{
		return spaces;
	}
	public char getboatChar()
	{
		return boatChar;
	}
	public void setRow(int row)
	{
		this.row = row;
	}
	public void setCol(int col)
	{
		this.col = col;
	}
	public int getRow()
	{
		return this.row;
	}
	public int getCol()
	{
		return this.col;
	}
	public void setIsVertical(boolean b)
	{
		this.isVertical = b;
	}
	public boolean getIsVertical()
	{
		return this.isVertical;
	}
}
