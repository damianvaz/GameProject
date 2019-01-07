package BoatTypes;

import java.awt.Color;

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
	boolean isComplexShape = false;
	public int health;
	public boolean isBoatSet = false;
	public Color color = Color.BLACK;
	
	
	public void setBoatVar(int row, int col, boolean isVertical)
	{
		this.rowBegin = row;
		this.colBegin = col;
		this.isVertical = isVertical;
		if (isVertical)
		{
			if (isComplexShape)
			{
				this.rowEnd = rowBegin + (spaces - 2);
				this.colEnd = colBegin;
			}
			else
			{
				this.rowEnd = rowBegin + (spaces - 1);
				this.colEnd = colBegin;
			}
		}
		else
		{
			if (isComplexShape)
			{
				this.colEnd = colBegin + (spaces - 2);
				this.rowEnd = rowBegin;
			}
			else
			{
				this.colEnd = colBegin + (spaces - 1);
				this.rowEnd = rowBegin;
			}
		}
		this.isSunk = false;
	}
	public void setIsBoatSet(boolean isBoatSet)
	{
		this.isBoatSet = isBoatSet;
	}
	public boolean isHere(int x, int y)
	{
		boolean condition = false;
		if (isComplexShape)
		{
			if (isVertical)
			{
				if (spaces == 4)
				{
					if (this.colBegin == this.colEnd && this.colEnd == y && this.rowBegin <= x && x <= this.rowEnd || 
							(x == rowBegin + 1 && y == colBegin + 1))
					{
						condition = true;
					}
				}
				else
				{
					if (this.colBegin == this.colEnd && this.colEnd == y && this.rowBegin <= x && x <= this.rowEnd || 
							(x == rowBegin && y == colBegin + 1))
					{
						condition = true;
					}
				}
			}
			else
			{
				if (spaces == 4)
				{
					if (this.rowBegin == this.rowEnd && this.rowEnd == x && this.colBegin <= y && y <= this.colEnd
							|| (x == rowBegin - 1 && y == colBegin + 1))
					{
						condition = true;
					}
				}
				else
				{
					if (this.rowBegin == this.rowEnd && this.rowEnd == x && this.colBegin <= y && y <= this.colEnd
							|| (x == rowBegin + 1 && y == colEnd))
					{
						condition = true;
					}
				}
			}
		}
		else if (isVertical)
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
	public boolean getIsComplexShape()
	{
		return isComplexShape;
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
