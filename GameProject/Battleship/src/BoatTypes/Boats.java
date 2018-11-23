package BoatTypes;
import java.util.Random;

public class Boats 
{
	String name;
	int spaces;
	char boatChar;
	int rowBegin;
	int colBegin;
	int rowEnd;
	int colEnd;
	boolean isVertical = false;
	boolean[] isHit;
	boolean isSunk;
	int health;
	
	
	public void setBoatVar(int row, int col, boolean isVertical)
	{
		this.rowBegin = row;
		this.colBegin = col;
		this.isVertical = isVertical;
		if (isVertical)
		{
			this.rowEnd = rowBegin + spaces;
			this.colEnd = colBegin;
		}
		else
		{
			this.colEnd = colBegin + spaces;
			this.rowEnd = rowBegin;
		}
		this.isSunk = false;
	}
	public boolean isHere(int x, int y)
	{
		boolean condition = false;
		if (isVertical)
		{
			if (this.colBegin <= y && y <= this.colEnd )
			{
				condition = true;
			}
		}
		else
		{
			if (this.rowBegin <= x && x <= this.rowEnd)
			{
				condition = true;
			}
		}
		return condition;
	}
	public void setHit()
	{
		this.health -= 10;
		if (health <= 0)
		{
			System.out.println("BOAT SUNK");
		}
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
	public void setRowBegin(int row)
	{
		this.rowBegin = row;
	}
	public void setColBegin(int col)
	{
		this.colBegin = col;
	}
	public int getRowBegin()
	{
		return this.rowBegin;
	}
	public int getColBegin()
	{
		return this.colBegin;
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
