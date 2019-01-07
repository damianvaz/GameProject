package BattleshipMain;
import java.util.Random;
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
	Board enemyBoard;
	int boardSize;
	int boatsAlive = 10;

	
	public Player(int size)
	{
		board = new Board(size);
		enemyBoard = new Board(size);
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
		this.boardSize = size;
	}
	public Boats[] getBoats()
	{
		return boats;
	}
	public void killBoat()
	{
		boatsAlive--;
		if (boatsAlive <= 0)
		{
			System.out.println("GAME OVER!");
			System.exit(0);
		}
	}
	/*
	public void setBoard()
	{
		for(int i = 0; i < boats.length; i++)
		{
			boolean condicao = true;
			while (condicao)
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
				boats[i].setBoatVar(row, col, isVertical);
				if (board.isValidPlay(boats[i]))
				{
					board.setBoat(boats[i]);
					condicao = false;
				}
				else 
				{
					System.out.println("Ilegal Position, try again");
				}
			}
		}
	}
	*/
	public void setRandomBoard()
	{
		for (int i = 0; i < boats.length; i++)
		{
			boolean condicao = true;
			while (condicao)
			{
				Random random = new Random();
				
				int x = random.nextInt(boardSize);
				int y = random.nextInt(boardSize);
				boolean vertical = random.nextBoolean();
								
				boats[i].setBoatVar(x, y,vertical);
				if(board.isValidPlay(boats[i]))
				{
					board.setBoat(boats[i]);
					//board.printBoard();
					condicao = false;
				}
			}
		}
	}
	
	public Boats getBoat(int row, int col)
	{
		Boats boatFound = null;
		for (int i = 0; i < boats.length; i++)
		{
			if (boats[i].isHere(row, col))
			{
				boatFound = boats[i];
				break;
			}
		}
		return boatFound;
	}
	
}
