package BattleshipMain;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BoatTypes.Boats;

public class GameGoingPanel extends JPanel 
{
	private JButton[][] buttons;
	private JPanel[][] tiles;
	private JPanel buttonsPanel;
	private JPanel tilesPanel;
	private int size;
	private Player player1, player2;
	private Color backgroundColor = ColorScheme.backgroundColor;
	private Color mainColor = ColorScheme.mainColor;

	public GameGoingPanel(int size, Player player1, Player player2)
	{
		this.size = size;
		setBackground(backgroundColor);
		// Buttons to be where the player wants to set the hit to enemy Board
		buttons = new JButton[size][size];
		buttonsPanel = new JPanel();
		buttonsPanel.setBackground(ColorScheme.thirdColor);

		this.player1 = player1;
		this.player2 = player2;

		// tiles are my board
		tiles = new JPanel[size][size];
		tilesPanel = new JPanel();
		
		
		GridLayout layout = new GridLayout(size, size, 0, 0);
		buttonsPanel.setLayout(layout);
		tilesPanel.setLayout(layout);

		buttonHandler handler = new buttonHandler();
		// making and adding the Buttons and tiles to their respective panels
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++)
			{
				buttons[i][j] = new JButton();
				buttons[i][j].addActionListener(handler);
				buttons[i][j].setBackground(Color.BLACK);
			//	buttons[i][j].setBorderPainted(false);;
				buttonsPanel.add(buttons[i][j]);

				tiles[i][j] = new JPanel();
				if (player1.board.board[i][j] != ' ')
				{					
					Boats boat = player1.getBoat(i, j);
					Color color = boat.color;
					tiles[i][j].setBackground(color);
				} 
				else 
				{
					tiles[i][j].setBackground(Color.BLACK);
				}
				tiles[i][j].setBorder(BorderFactory.createLineBorder(null, 1));
				tilesPanel.add(tiles[i][j]);
			}
		}
		// Setting Boarders
		
		tilesPanel.setBorder(BorderFactory.createLineBorder(ColorScheme.okColor));
		
		tilesPanel.setBackground(null);		
		buttonsPanel.setPreferredSize(new Dimension(500, 500));
		tilesPanel.setPreferredSize(new Dimension(500, 500));
		
		
		setLayout(new BorderLayout(10, 10));
		
		JLabel title = new JLabel("SPACESHIPS!!!!");
		Font titleFont = LoadFonts.getTitleFont(40f);
		title.setFont(titleFont);
		title.setForeground(mainColor);
		title.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    add(title, BorderLayout.NORTH);
		add(buttonsPanel, BorderLayout.WEST);
		add(tilesPanel, BorderLayout.EAST);
		setBorder(BorderFactory.createEmptyBorder(18, 12, 18, 12));
		
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
