package BoatTypes;

public class AircraftCarrier extends Boats
{
	public AircraftCarrier()
	{
		name = "Aircraft Carrier";
		spaces = 5;
		boatChar = 'A';
		isHit = new boolean[spaces];
		health = spaces * 10;
	}
}
