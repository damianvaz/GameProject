package BoatTypes;

import java.awt.Color;

public class Submarine extends Boats
{
	public Submarine()
	{
		name = "Submarine";
		spaces = 1;
		boatChar = 'S';
		isHit = new boolean[spaces];
		health = spaces * 10;
		color = Color.YELLOW;
	}
}
