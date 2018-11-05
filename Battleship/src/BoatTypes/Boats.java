package BoatTypes;
import java.util.Random;

public class Boats 
{
	String name;
	int spaces;
	char boatChar;
	boolean isVertical = false;
	boolean[] isHit = new boolean[spaces];
	
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
}
