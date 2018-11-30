package BoatTypes;

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
	public int health;
	
	
	public void setBoatVar(int row, int col, boolean isVertical)
	{
		this.rowBegin = row;
		this.colBegin = col;
		this.isVertical = isVertical;
		if (isVertical)
		{
			this.rowEnd = rowBegin + (spaces - 1);
			this.colEnd = colBegin;
		}
		else
		{
			this.colEnd = colBegin + (spaces - 1);
			this.rowEnd = rowBegin;
		}
		this.isSunk = false;
	}
	public boolean isHere(int x, int y)
	{
		boolean condition = false;
		if (isVertical)
		{
			// if the boat is vertical the col is constant, and the row varies between the boat rowBegin and boat rowEnd
			if (this.colBegin == this.colEnd && this.colEnd == y && this.rowBegin <= x && x <= this.rowEnd)
			{
				condition = true;
			}
		}
		else
		{
			// if the boat is not vertical the row remains the same and the col varies between colBegin and colEnd
			if (this.rowBegin == this.rowEnd && this.rowEnd == x && this.colBegin <= y && y <= this.colEnd)
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
