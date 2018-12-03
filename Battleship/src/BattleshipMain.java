import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;

import BoatTypes.Boats;

public class BattleshipMain 
{
	static int size = 0;
	static boolean lastoneHit = false;
	static int[] pointHitLast;
	static boolean secondLastHit = false;
	static BattleshipFrame frame;
	public BattleshipMain(int size)
	{
		//menu();
		Player player1 = new Player(size);
		Player AIPlayer = new Player(size);
		
		player1.setRandomBoard();
		AIPlayer.setRandomBoard();
		
		// Opens the frame
		frame = new BattleshipFrame(size, player1, AIPlayer);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.pack();
	}
}
