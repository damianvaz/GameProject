package BoatTypes;

public class Destroyer extends Boats
{
	public Destroyer()
	{
		name = "Destroyer";
		spaces = 2;
		boatChar = 'D';
		isHit = new boolean[spaces];
		health = spaces * 10;
	}
}
