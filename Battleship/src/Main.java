import java.util.Random;
import java.util.Scanner;

import BoatTypes.Boats;

public class Main 
{
	static int size = 0;
	static boolean lastoneHit = false;
	static boolean secondLastHit = false;

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
		Player player1 = new Player(size);
		Player AIPlayer = new Player(size);
		
		player1.setRandomBoard();
		AIPlayer.setRandomBoard();
		
		while(true)
		{
			System.out.println("Your Board");
			player1.board.printBoard();
			System.out.println("Yout hits and misses on Enemy territory");
			player1.enemyBoard.printBoard();
			System.out.println();
//			AIPlayer.board.printBoard();
			askForCoordenates(player1.enemyBoard, AIPlayer);
			AIPlay(player1);
		}
	}
	
	public static void AIPlay(Player player)
	{
		Random random = new Random();
		/*
		if (lastoneHit)
		{
			// try on horizontal dimension first
			if(!secondLastHit)
			{
				
			}
		}
		*/
		int row = random.nextInt(size);
		int col = random.nextInt(size);
		
		//check if coordenates hit something
		if(player.board.board[row][col] != ' ')
		{
			System.out.println("Enemy hit your boat!!");
			Boats boat = player.getBoat(row, col);
			player.board.setHit(row, col);
			boat.setHit();
			lastoneHit = true;
		}
		else
		{
			System.out.println("Not a hit!");
			lastoneHit = false;
		}
	}
	
	public static void askForCoordenates(Board seeableEnemyBoard, Player AIPlayer)
	{
		//ask for coordenates
		Scanner in = new Scanner(System.in);
		System.out.println("Enter row coordenate: ");
		int row = in.nextInt();
		System.out.println("Enter col coordenate: ");
		int col = in.nextInt();
		
		//check if coordenates hit something
		if(AIPlayer.board.board[row][col] != ' ')
		{
			System.out.println("You got a hit!!");
			seeableEnemyBoard.setHit(row, col);
			Boats boat = AIPlayer.getBoat(row, col);
			AIPlayer.board.setHit(row, col);
			boat.setHit();
		}
		else
		{
			System.out.println("Not a hit!");
			seeableEnemyBoard.setMiss(row, col);
		}
	}
}
