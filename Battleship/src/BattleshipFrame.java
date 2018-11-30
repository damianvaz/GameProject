import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import BoatTypes.Boats;

public class BattleshipFrame extends JFrame {
	private JButton[][] buttons;
	private JPanel[][] tiles;
	private JPanel buttonsPanel;
	private JPanel tilesPanel;
	private int size;
	private char[][] myBoard;
	private Player player;

	/*
	public void doHit(int x, int y) 
	{
		// check if coordinates hit something
		if (player.enemyBoard[x][y] != ' ' && player != '!') 
		{
			System.out.println("You got a hit!!");
			seeableEnemyBoard.setHit(row, col);
			Boats boat = AIPlayer.getBoat(row, col);
			AIPlayer.board.setHit(row, col);
			boat.setHit();
			if (boat.health <= 0) 
			{
				AIPlayer.killBoat();
			}
		} else 
		{
			System.out.println("Not a hit!");
			seeableEnemyBoard.setMiss(row, col);
		}
	}
*/
	public BattleshipFrame(int size, Player player) {
		super("Battleship");
		this.size = size;
		myBoard = player.board.board;
		buttons = new JButton[size][size];
		buttonsPanel = new JPanel();
		this.player = player;
		tiles = new JPanel[size][size];
		tilesPanel = new JPanel();

		GridLayout layout = new GridLayout(size, size, 0, 0);
		buttonsPanel.setLayout(layout);
		tilesPanel.setLayout(layout);

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				buttons[i][j] = new JButton();
				// add listener
				buttonsPanel.add(buttons[i][j]);

				tiles[i][j] = new JPanel();
				if (myBoard[i][j] != ' ') {
					tiles[i][j].setBackground(Color.ORANGE);
				} else {
					tiles[i][j].setBackground(Color.CYAN);
				}
				tiles[i][j].setBorder(BorderFactory.createLineBorder(null, 1));
				tilesPanel.add(tiles[i][j]);
			}
		}
		tilesPanel.setBackground(null);
		Border insideBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		Border outsideBorder = BorderFactory.createTitledBorder("Enemy Territory");
		buttonsPanel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));

		Border insideBorder2 = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		Border outsideBorder2 = BorderFactory.createTitledBorder("My territory");
		tilesPanel.setBorder(BorderFactory.createCompoundBorder(outsideBorder2, insideBorder2));

		buttonsPanel.setPreferredSize(new Dimension(500, 500));
		tilesPanel.setPreferredSize(new Dimension(500, 500));

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(buttonsPanel);
		horizontalBox.add(tilesPanel);

		add(horizontalBox);

		// add(labelsPanel);

	}

	/*
	 * public static void main(String[] args) { BattleshipFrame f = new
	 * BattleshipFrame(10, ); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * f.setVisible(true); f.setResizable(false); f.pack(); }
	 */
	private class buttonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int x, y;

			JButton buttonPressed = (JButton) e.getSource();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (buttonPressed.equals(buttons[i][j])) {

					}
				}
			}
		}

	}
}
