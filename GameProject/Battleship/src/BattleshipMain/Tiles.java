package BattleshipMain;

import java.awt.Color;

import javax.swing.JPanel;

public class Tiles extends JPanel
{
	public int row;
	public int col;
	boolean isBoatSetHere = false;
	public Tiles(int x, int y)
	{
		this.row = x;
		this.col = y;
		setBackground(Color.BLACK);
	}
	
	public int getRow()
	{
		return row;
	}
	
	public int getCol()
	{
		return col;
	}
	public void setBoatHere()
	{
		isBoatSetHere = true;
	}
}
