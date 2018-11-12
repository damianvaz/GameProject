import java.util.Scanner;

import BoatTypes.AircraftCarrier;
import BoatTypes.Battleship;
import BoatTypes.Cruiser;
import BoatTypes.Destroyer;
import BoatTypes.Submarine;

public class Main 
{
	static int size = 0;
	public static void menu()
	{
		System.out.println("Select the difficulty: ");
		System.out.println("1 - Easy");
		System.out.println("2 - Medium");
		System.out.println("3 - Hard");
		Scanner in = new Scanner(System.in);
		int difficulty = in.nextInt();
		
		switch (difficulty)
		{
			case(1):
			{
				size = 10;
				break;
			}
			case(2):
			{
				size = 15;
				break;
			}
			case(3):
			{
				size = 20;
				break;
			}
			default:
			{
				System.out.println("Try Again");
				menu();
			}
		}
	}
	
	
	public static void main(String[] args) 
	{
		menu();
		//Board board = new Board(size);
		

		Player player1 = new Player(size);
		
		player1.setBoard();
		System.out.println();
		player1.board.printBoard();
		
		
		
	}
}
