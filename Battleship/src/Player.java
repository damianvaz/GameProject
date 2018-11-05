import java.util.Scanner;

import BoatTypes.AircraftCarrier;
import BoatTypes.Battleship;
import BoatTypes.Boats;
import BoatTypes.Cruiser;
import BoatTypes.Destroyer;
import BoatTypes.Submarine;

public class Player 
{
	Boats[] boats = new Boats[10];
	Board board;
	Board enemyHitsMisses;
	
	public Player(int size)
	{
		board = new Board(size);
		boats[0] = new AircraftCarrier();
		boats[1] = new Battleship();
		boats[2] = new Battleship();
		boats[3] = new Cruiser();
		boats[4] = new Cruiser();
		boats[5] = new Destroyer();
		boats[6] = new Destroyer();
		boats[7] = new Submarine();
		boats[8] = new Submarine();
		boats[9] = new Submarine();
	}
	
	public void setBoard()
	{
		for(int i = 0; i < boats.length; i++)
		{
			System.out.println("Setting boat: " + boats[i].getName());
			System.out.println("Enter number of row: ");
			Scanner in = new Scanner(System.in);
			int row = in.nextInt();
			System.out.println("Enter number of Col");
			int col = in.nextInt();
			System.out.println("Is the boat on vertical? y/n");
			String vertical = in.next();
			boolean isVertical = false;
			if (vertical.equals("y"))
			{
				isVertical = true;
			}
			board.setBoat(boats[i], isVertical, row, col);
			board.printBoard();
		}
	}
}
