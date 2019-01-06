package BoatTypes;

import java.awt.Color;

public class Battleship extends Boats
{
	public Battleship()
	{
		name = "Battleship";
		spaces = 4;
		boatChar = 'B';
		isHit = new boolean[spaces];
		health = spaces * 10;
		isComplexShape = true;
		color = Color.BLUE;
	}
}
