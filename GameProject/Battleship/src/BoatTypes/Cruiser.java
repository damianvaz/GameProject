package BoatTypes;

public class Cruiser extends Boats
{
	public Cruiser()
	{
		name = "Cruiser";
		spaces = 3;
		boatChar = 'C';
		isHit = new boolean[spaces];
		health = spaces * 10;
	}
}