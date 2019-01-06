package BattleshipMain;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;

public class BattleshipMain 
{
	static int size = 0;
	public BattleshipMain(int size)
	{
		GameFrame frame = new GameFrame(size);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	//	frame.setResizable(false);
		frame.pack();
	}
}
