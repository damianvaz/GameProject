import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import BoatTypes.Boats;

public class BattleshipFrame extends JFrame {
	private JButton[][] buttons;
	private JPanel[][] tiles;
	private JPanel buttonsPanel;
	private JPanel tilesPanel;
	private int size;
	private Player player1, player2;

	public BattleshipFrame(int size, Player player1, Player player2)
	{
		super("Battleship Game By Damian Vaz");

		this.size = size;
		buttons = new JButton[size][size];
		buttonsPanel = new JPanel();

		this.player1 = player1;
		this.player2 = player2;

		// tiles are my board
		tiles = new JPanel[size][size];
		tilesPanel = new JPanel();

		GridLayout layout = new GridLayout(size, size, 0, 0);
		buttonsPanel.setLayout(layout);
		tilesPanel.setLayout(layout);

		buttonHandler handler = new buttonHandler();
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++)
			{
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(handler);
				buttonsPanel.add(buttons[i][j]);

				tiles[i][j] = new JPanel();
				if (player1.board.board[i][j] != ' ')
				{
					tiles[i][j].setBackground(Color.ORANGE);
				} 
				else 
				{
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

	}
	
	public void shootAtPlayer()
	{
		int row, col;
		Random random = new Random();
		
		row = random.nextInt(size);
		col = random.nextInt(size);
		
		//check if coordenates hit something
		char space = player1.board.board[row][col];
		if(space != ' ' && space != '!' && space != 'X')
		{
			Boats boat = player1.getBoat(row, col);
			player1.board.setHit(row, col);
			boat.setHit();
			tiles[row][col].setBackground(Color.RED);
			if(boat.health <= 0)
			{
				player1.killBoat();
			}
		}
		else if (space == 'X' || space == '!')
		{
			// already tried here
			shootAtPlayer();
		}
		else
		{
			player1.board.setMiss(row, col);
			tiles[row][col].setBackground(Color.GRAY);
		}
	}
	
	private void shootAtOpponent(int x, int y)
	{
		char space = player2.board.board[x][y];
		if (space != ' ' && space != '!' && space != 'X')
		{
			player2.board.setHit(x, y);
			player1.enemyBoard.setHit(x, y);
			Boats boat = player2.getBoat(x, y);
			boat.setHit();
			if(boat.health <= 0)
			{
				player2.killBoat();
			}
			buttons[x][y].setBackground(Color.GREEN);
		}
		else
		{
			buttons[x][y].setBackground(Color.RED);
			player1.enemyBoard.board[x][y] = 'X';
		}
	}
	private class buttonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int x = 0;
			int y = 0;

			JButton buttonPressed = (JButton) e.getSource();
			// get row and column of boat
			for (int i = 0; i < size; i++)
			{
				for (int j = 0; j < size; j++) 
				{
					if (buttonPressed.equals(buttons[i][j])) 
					{
						x = i;
						y = j;
						break;
					}
				}
			}
			if (player1.enemyBoard.board[x][y] == 'X' || player1.enemyBoard.board[x][y] == '!')
			{
				JOptionPane.showMessageDialog(null, "You already tried here!", "Nope", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				shootAtOpponent(x, y);
				shootAtPlayer();
			}
		}

	}
}
