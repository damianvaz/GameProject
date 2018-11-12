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
	boolean[] isHit = new boolean[spaces];
	
	
	public void setBoatVar(int row, int col, boolean isVertical)
	{
		this.row = row;
		this.col = col;
		this.isVertical = isVertical;
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
