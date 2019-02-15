package BattleshipMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import BoatTypes.Boats;

public class GameFrame extends JFrame
{
	Boats boat;
	JLabel[] boatLabels = new JLabel[5];
	JPanel[][] tiles;
	JPanel tilesPanel;
	Color hover = ColorScheme.hover;
	Color selectedColor = ColorScheme.selectedColor;
	Color tilesBackground = ColorScheme.tilesBackground;
	Color okColor = ColorScheme.okColor;
	Color notOkColor = ColorScheme.notOkColor;
	Color backgroundColor = ColorScheme.backgroundColor;
	Color mainColor = ColorScheme.mainColor;
	Color secondaryColor = ColorScheme.secondaryColor;
	Color thirdColor = ColorScheme.thirdColor;
	Color forthColor = ColorScheme.forthColor;
	Board board;
	int size;
	Boats[] boats;
	Player player;
	boolean allBoatsSet = false;
	int aircraftCarrierQtd, battleshipQtd, cruiserQtd, destroyerQtd, submarineQtd;
//	private final URL background = getClass().getResource("space.jpg");
	JPanel mainPanel;
	JButton clearBoard, randomBoard, goButton;
	Icon clearBoardIcon = new ImageIcon(getClass().getResource("/resources/clean.png"));
    Icon randomIcon = new ImageIcon(getClass().getResource("/resources/random.png"));
    Icon hoverClearBoardIcon = new ImageIcon(getClass().getResource("/resources/cleanHover.png"));
    Icon hoverRandomIcon = new ImageIcon(getClass().getResource("/resources/randomHover.png"));
    Icon goButtonIcon = new ImageIcon(getClass().getResource("/resources/goResized.gif"));
	
	public GameFrame(int size)
	{	
		super("Spaceships: A game by Damian Vaz");
		this.size = size;
		board = new Board(size);
		player = new Player(size);
		boats = player.getBoats();
		getBoatsQtd();
		makeMainPanel();	
	}
	private void makeMainPanel()
	{
		mainPanel = new JPanel();
		mainPanel.setBackground(backgroundColor);
		tilesPanel = boardPanel(size);
		// Panel that shows the type of boats so that the user can set them on the board
		JPanel boatsPanel = new JPanel();
		boatsPanel.setBackground(backgroundColor);
		boatsPanel.setPreferredSize(new Dimension(500,500));
		boatsPanel.setLayout(new GridLayout(3, 2, 10, 10));
		//making boats panel		
	    Icon aircraftCarrierIcon = new ImageIcon(getClass().getResource("/resources/aircraftCarrier.png"));
	    Icon battleshipIcon = new ImageIcon(getClass().getResource("/resources/battleship.png"));
	    Icon cruiserIcon = new ImageIcon(getClass().getResource("/resources/cruiser.png"));
	    Icon destroyerIcon = new ImageIcon(getClass().getResource("/resources/destroyer.png"));
	    Icon submarineIcon = new ImageIcon(getClass().getResource("/resources/submarine.png"));
	    
	    BoatsMouseHandler boatsHandler = new BoatsMouseHandler();
	    boatLabels[0] = makeBoatLabel(aircraftCarrierIcon, "SPACESHIP CARRIER", aircraftCarrierQtd, boatsHandler);
	    boatLabels[1] = makeBoatLabel(battleshipIcon, "BATTLESHIP", battleshipQtd, boatsHandler);
	    boatLabels[2] = makeBoatLabel(cruiserIcon, "CRUISER", cruiserQtd, boatsHandler);
	    boatLabels[3] = makeBoatLabel(destroyerIcon, "DESTROYER", + destroyerQtd, boatsHandler);
	    boatLabels[4] = makeBoatLabel(submarineIcon, "SUBSPACE", submarineQtd, boatsHandler);
	    
	    for (int i = 0; i < boatLabels.length; i++)
	    {
	    	boatsPanel.add(boatLabels[i]);
	    	boatLabels[i].setBackground(backgroundColor);
	    }
	    
	    JPanel buttonsPanel = new JPanel();
	    buttonsPanel.setBackground(backgroundColor);
	    buttonsPanel.setLayout(new GridBagLayout());
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.gridwidth = GridBagConstraints.REMAINDER;
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.fill = GridBagConstraints.HORIZONTAL;
	    constraints.weighty = 1;
	    
	    clearBoard = new JButton();
	    randomBoard = new JButton();
	    
	    randomBoard.setOpaque(false);
        randomBoard.setContentAreaFilled(false);
        Dimension randomButtonDimension = new Dimension(randomIcon.getIconWidth(), randomIcon.getIconHeight());
        randomBoard.setPreferredSize(randomButtonDimension);
        randomBoard.setBorderPainted(false);
        
        clearBoard.setOpaque(false);
        clearBoard.setContentAreaFilled(false);
        Dimension clearButtonDimension = new Dimension(clearBoardIcon.getIconWidth(), clearBoardIcon.getIconHeight());
        clearBoard.setPreferredSize(clearButtonDimension);
        clearBoard.setBorderPainted(false);
	    
	    clearBoard.setIcon(clearBoardIcon);
	    randomBoard.setIcon(randomIcon);
	    clearBoard.setRolloverIcon(hoverClearBoardIcon);
	    randomBoard.setRolloverIcon(hoverRandomIcon);
	    clearBoard.setPressedIcon(hoverClearBoardIcon);
	    randomBoard.setPressedIcon(hoverRandomIcon);
	    
	    ButtonListener buttonHandler = new ButtonListener();
	    clearBoard.addActionListener(buttonHandler);
	    randomBoard.addActionListener(buttonHandler);
	    
	    buttonsPanel.add(clearBoard, constraints);
	    buttonsPanel.add(randomBoard, constraints);
	    boatsPanel.add(buttonsPanel);
	    
	    boatLabels[0].setBackground(selectedColor);
	    
	    // Making JLabel yo go on mainPanel north
	    JLabel title = new JLabel("Set your Board!");
	    Font titleFont = LoadFonts.getTitleFont(40f);
	    title.setFont(titleFont);
	    title.setForeground(mainColor);
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    // making Go button, if all the boats are set, it becomes enable and the user can click on it to fo to the GameGoingPanel
	    goButton = new JButton();
	    if(allBoatsSet)
	    {
	    	goButton.setOpaque(true);
	        goButton.setContentAreaFilled(true);
	        goButton.setBorder(BorderFactory.createLineBorder(ColorScheme.fifthColor, 3));
	    }
	    else
	    {
	    	goButton.setOpaque(false);
	        goButton.setContentAreaFilled(false);
	    }
        Dimension goButtonDimension = new Dimension(goButtonIcon.getIconWidth(), goButtonIcon.getIconHeight());
        goButton.setPreferredSize(goButtonDimension);
        goButton.setBackground(ColorScheme.secondaryColor);
	    goButton.setEnabled(allBoatsSet);
	    goButton.setIcon(goButtonIcon);
	    goButton.addActionListener(buttonHandler);
	    
	    // Making Panel that contains the JLabel and the Go Button
	    JPanel northPanel = new JPanel();
	    northPanel.setLayout(new BorderLayout());
	    northPanel.setBackground(backgroundColor);
	    northPanel.add(title, BorderLayout.CENTER);
	    northPanel.add(goButton, BorderLayout.EAST);
	    
	    // Setting and adding components to mainPanel
	    mainPanel.setLayout(new BorderLayout(15,15));
	    mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(tilesPanel, BorderLayout.CENTER);
		mainPanel.add(boatsPanel, BorderLayout.EAST);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(mainPanel);
	}
	private void getBoatsQtd()
	{
		aircraftCarrierQtd = 0;
		battleshipQtd = 0;
		cruiserQtd = 0;
		destroyerQtd = 0;
		submarineQtd = 0;
		for(int i = 0; i < boats.length; i++)
		{
			String boatName = boats[i].getName();
			switch(boatName)
			{
				case("Aircraft Carrier"):
				{
					aircraftCarrierQtd++;
					break;
				}
				case("Battleship"):
				{
					battleshipQtd++;
					break;
				}
				case("Cruiser"):
				{
					cruiserQtd++;
					break;
				}
				case("Destroyer"):
				{
					destroyerQtd++;
					break;
				}
				default:
				{
					submarineQtd++;
				}
			}
		}
	}
	public JLabel makeBoatLabel(Icon icon, String boatName, int boatQtd, BoatsMouseHandler handler)
	{
		JLabel boatLabel = new JLabel(icon, JLabel.CENTER);
		boatLabel.setText("x" + boatQtd);
		Font customFont = LoadFonts.getMainFont(12f);
		boatLabel.setFont(customFont);
		boatLabel.setForeground(secondaryColor);
	    boatLabel.setHorizontalTextPosition(JLabel.CENTER);
	    boatLabel.setVerticalTextPosition(JLabel.BOTTOM);
	    boatLabel.setOpaque(true);
	    boatLabel.addMouseListener(handler);
	    boatLabel.setBorder(BorderFactory.createTitledBorder(null, boatName, TitledBorder.LEFT, TitledBorder.TOP, customFont, secondaryColor));
	    return boatLabel;
	}
	public JPanel boardPanel(int size)
	{
		JPanel tilesPanel = new JPanel();
		tilesPanel.setBackground(thirdColor);
		tiles = new Tiles[size][size];
		tilesPanel.setPreferredSize(new Dimension(500, 500));
		GridLayout layout = new GridLayout(size, size, 0, 0);
		tilesPanel.setLayout(layout);
		tilesPanel.setBorder(BorderFactory.createLineBorder(thirdColor, 5));
		TilesMouseHandler tilesHandler = new TilesMouseHandler();
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++)
			{
				tiles[i][j] = new Tiles(i,j);
				tiles[i][j].addMouseListener(tilesHandler);
			
				if(board.board[i][j] != ' ')
				{
					Boats boat = player.getBoat(i, j);
					tiles[i][j].setBackground(boat.color);
				}
		
				tiles[i][j].setBorder(BorderFactory.createLineBorder(forthColor, 1));
				tilesPanel.add(tiles[i][j]);
			}
		}
		return tilesPanel;
	}
	
	private class ButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton source = (JButton) e.getSource();
			if (source.equals(clearBoard))
			{
				board = new Board(size);
				player = new Player(size);
				allBoatsSet = false;
				boats = player.boats;
				
				getBoatsQtd();
				getContentPane().removeAll();
				makeMainPanel();
				getContentPane().add(mainPanel);
				getContentPane().revalidate();
			}
			else if (source.equals(randomBoard))
			{
				player = new Player(size);
				player.setRandomBoard();
				boats = player.getBoats();
				board = player.board;
				aircraftCarrierQtd = 0;
				battleshipQtd = 0;
				cruiserQtd = 0;
				destroyerQtd = 0;
				submarineQtd = 0;
				allBoatsSet = true;
				getContentPane().removeAll();
				makeMainPanel();
				getContentPane().add(mainPanel);
				getContentPane().revalidate();
			}
			else
			{
				Player enemyPlayer = new Player(size);
				player.board = board;
				enemyPlayer.setRandomBoard();
				
				getContentPane().removeAll();
			    
				JPanel gamePanel = new GameGoingPanel(size, player, enemyPlayer);
				
				getContentPane().add(gamePanel);
				pack();
			}
		}
	}
	private class TilesMouseHandler implements MouseListener
	{
		private Boats getBoatSelected()
		{
			boat = null;
			for (int i = 0; i < boatLabels.length; i++)
			{
				if (boatLabels[i].getBackground().equals(selectedColor))
				{
					switch(i)
					{
						case(0):
						{
							boat = boats[0];
							break;
						}
						case(1):
						{
							if (battleshipQtd == 2)
							{
								boat = boats[1];
							}
							else
							{
								boat = boats[2];
							}
							break;
						}
						case(2):
						{
							if (cruiserQtd == 2)
							{
								boat = boats[3];
							}
							else
							{
								boat = boats[4];
							}
							break;
						}
						case(3):
						{
							if (destroyerQtd == 2)
							{
								boat = boats[5];
							}
							else
							{
								boat = boats[6];
							}
							break;
						}
						default:
						{
							if (submarineQtd == 3)
							{
								boat = boats[7];
							}
							else if (submarineQtd == 2)
							{
								boat = boats[8];
							}
							else
							{
								boat = boats[9];
							}
						}
					}
				}
			}
			return boat;
		}
		private void paintTile(int x, int y, Color color)
		{
			if(x < size && y < size && x >= 0 && y >= 0 && board.board[x][y] == ' ')
			{
				tiles[x][y].setBackground(color);
			}
		}
	
		private void paintBoatTiles(Tiles tile, boolean isEntered)
		{
			int spaces = boat.getSpaces();
			int x = tile.getRow();
			int y = tile.getCol();
			
			if (boat.getIsComplexShape())
			{
				if (spaces == 4)
				{
					if(boat.getIsVertical())
					{
						boat.setBoatVar(x, y, true);
						Color color = getColorToPaint(boat, isEntered);
						paintTile(x, y, color);
						paintTile(x + 1, y, color);
						paintTile(x + 2, y, color);
						paintTile(x + 1, y + 1, color);
					}
					else
					{
						boat.setBoatVar(x, y, false);
						Color color = getColorToPaint(boat, isEntered);
						paintTile(x, y, color);
						paintTile(x, y + 1, color);
						paintTile(x, y + 2, color);
						paintTile(x - 1, y + 1, color);	
					}
				}
				else
				{
					if(boat.getIsVertical())
					{
						boat.setBoatVar(x, y, true);
						Color color = getColorToPaint(boat, isEntered);
						paintTile(x, y, color);
						paintTile(x, y + 1, color);
						paintTile(x + 1, y, color);
					}
					else
					{
						boat.setBoatVar(x, y, false);
						Color color = getColorToPaint(boat, isEntered);
						paintTile(x, y, color);
						paintTile(x, y + 1, color);
						paintTile(x + 1, y + 1, color);
					}
				}
			}
			else if (boat.getIsVertical())
			{
				boat.setBoatVar(x, y, true);
				Color color = getColorToPaint(boat, isEntered);
				for (int i = 0; i < spaces; i++)
				{
					paintTile(x + i, y, color);
				}
			}
			else
			{
				boat.setBoatVar(x, y, false);
				Color color = getColorToPaint(boat, isEntered);
				for (int i = 0; i < spaces; i++)
				{
					paintTile(x, y + i, color);
				}
			}
		}
		private Color getColorToPaint(Boats boat, boolean isEntered)
		{
			Color color;
			if(!isEntered)
			{
				color = tilesBackground;
			}
			else
			{
				if(boat.isBoatSet)
				{
					color = boat.color;
				}
				else if (board.isValidPlay(boat))
				{
					color = okColor;
				}
				else
				{
					color = notOkColor;
				}
			}
			return color;
		}
		private void selectNextBoat()
		{
			JLabel boatLabelSelected = getLabelSelected();
			if (aircraftCarrierQtd > 0)
			{
				boatLabelSelected.setBackground(null);
				boatLabels[0].setBackground(selectedColor);
			}
			else if (battleshipQtd > 0)
			{
				boatLabelSelected.setBackground(null);
				boatLabels[1].setBackground(selectedColor);
			}
			else if (cruiserQtd > 0)
			{
				boatLabelSelected.setBackground(null);
				boatLabels[2].setBackground(selectedColor);
			}
			else if (destroyerQtd > 0)
			{
				boatLabelSelected.setBackground(null);
				boatLabels[3].setBackground(selectedColor);
			}
			else if (submarineQtd > 0)
			{
				boatLabelSelected.setBackground(null);
				boatLabels[4].setBackground(selectedColor);
			}
			else
			{
				boat = null;
			}
		}
		private JLabel getLabelSelected()
		{
			JLabel boatLabelSelected = null;
			for(int i = 0; i < boatLabels.length; i++)
			{
				if (boatLabels[i].getBackground() == selectedColor)
				{
					boatLabelSelected = boatLabels[i];
				}
			}
			return boatLabelSelected;
		}
		@Override
		public void mouseClicked(MouseEvent e)
		{
			Tiles tile = (Tiles) e.getSource();
			
			if (e.getButton() == MouseEvent.BUTTON1 && !allBoatsSet)
			{
				if (board.isValidPlay(boat))
				{
					boat.setIsBoatSet(true);
					tile.isBoatSetHere = true;
					paintBoatTiles(tile, true);
					board.setBoat(boat);
					JLabel labelSelected = getLabelSelected();
					if (labelSelected == boatLabels[0])
					{
						if (aircraftCarrierQtd > 0)
						{
							labelSelected.setText("x" + --aircraftCarrierQtd);
						}
					}
					else if (labelSelected == boatLabels[1])
					{
						if(battleshipQtd > 0)
						{
							labelSelected.setText("x" + --battleshipQtd);
						}
					}
					else if (labelSelected == boatLabels[2])
					{
						if(cruiserQtd > 0)
						{
							labelSelected.setText("x" + --cruiserQtd);
						}
					}
					else if (labelSelected == boatLabels[3])
					{
						if(destroyerQtd > 0)
						{
							labelSelected.setText("x" + --destroyerQtd);
						}
					}
					else
					{
						if(submarineQtd > 0)
						{
							labelSelected.setText("x" + --submarineQtd);
							
						}
					}
					selectNextBoat();
				}
				if (aircraftCarrierQtd == 0 && battleshipQtd == 0 && cruiserQtd == 0 && destroyerQtd == 0 && submarineQtd == 0)
				{
					allBoatsSet = true;
					goButton.setOpaque(true);
			        goButton.setContentAreaFilled(true);
					goButton.setEnabled(true);
					goButton.setBorder(BorderFactory.createLineBorder(ColorScheme.fifthColor, 3));
				}
			}
			if ( e.getButton() == MouseEvent.BUTTON3 && !allBoatsSet)
			{
				boat = getBoatSelected();
				if(boat != null)
				{
					if (boat.getIsVertical())
					{
						paintBoatTiles(tile, false);
						boat.setIsVertical(false);
					}
					else
					{
						paintBoatTiles(tile, false);
						boat.setIsVertical(true);
					}
					paintBoatTiles(tile, true);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			Tiles panelMouseOn = (Tiles) e.getSource();
			if (!allBoatsSet)
			{
				boat = getBoatSelected();
				boat.setBoatVar(panelMouseOn.getRow(), panelMouseOn.getCol(), boat.getIsVertical());
				boat.isBoatSet = false;
				paintBoatTiles(panelMouseOn, true);
			}
			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			Tiles panelMouseOn = (Tiles) e.getSource();
			if (!allBoatsSet)
			{
				boat = getBoatSelected();
				boat.setBoatVar(panelMouseOn.getRow(), panelMouseOn.getCol(), boat.getIsVertical());
				boat.isBoatSet = false;
				paintBoatTiles(panelMouseOn, false);
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	private class BoatsMouseHandler implements MouseListener
	{
		@Override
		public void mouseClicked(MouseEvent e)
		{
			JLabel source = (JLabel) e.getSource();
			for(int i = 0; i < boatLabels.length; i++)
			{
				boatLabels[i].setBackground(null);
			}
			source.setBackground(selectedColor);
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			JLabel source = (JLabel) e.getSource();
			if (!isSelected(source))
			{
				source.setBackground(hover);
			}
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			JLabel source = (JLabel) e.getSource();
			if (!isSelected(source))
			{
				source.setBackground(null);
			}
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		private boolean isSelected(JLabel label)
		{
			if (label.getBackground().equals(selectedColor))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
}
