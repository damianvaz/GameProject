package BattleshipMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BoatTypes.Boats;

public class GameFrame extends JFrame
{
	Boats boat;
	JLabel[] boatLabels = new JLabel[5];
	JPanel[][] tiles;
	JPanel tilesPanel;
	Color hover = new Color (135,206,250);
	Color selectedColor = new Color(100,149,237);
	Color tilesBackground = Color.BLACK;
	Color okColor = Color.GREEN;
	Color notOkColor = Color.RED;
	Board board;
	int size;
	Boats[] boats;
	Player player;
	boolean allBoatsSet = false;
	int aircraftCarrierQtd, battleshipQtd, cruiserQtd, destroyerQtd, submarineQtd;
	private final URL background = getClass().getResource("space.jpg");
	JPanel mainPanel;
	
	
	public GameFrame(int size)
	{	
		super("Battleship Game by Damian Vaz");
		this.size = size;
	//	mainPanel = new BackgroundAdapt(background);
		mainPanel = new JPanel();
		board = new Board(size);
		tilesPanel = boardPanel(size);
		player = new Player(size);
		boats = player.getBoats();
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
		
		// Panel that shows the type of boats layout so that the user can set them on the board
		JPanel boatsPanel = new JPanel();
		JLabel lala = new JLabel("kaka");
		boatsPanel.setPreferredSize(new Dimension(500,500));
		boatsPanel.setLayout(new GridLayout(3, 2, 10, 10));
		//making boats panel		
	    Icon aircraftCarrierIcon = new ImageIcon(getClass().getResource("aircraftCarrier.png"));
	    Icon battleshipIcon = new ImageIcon(getClass().getResource("battleship.png"));
	    Icon cruiserIcon = new ImageIcon(getClass().getResource("cruiser.png"));
	    Icon destroyerIcon = new ImageIcon(getClass().getResource("destroyer.png"));
	    Icon submarineIcon = new ImageIcon(getClass().getResource("submarine.png"));
	    
	    BoatsMouseHandler boatsHandler = new BoatsMouseHandler();
	    boatLabels[0] = makeBoatLabel(aircraftCarrierIcon, "SPACESHIP CARRIER", aircraftCarrierQtd, boatsHandler);
	    boatLabels[1] = makeBoatLabel(battleshipIcon, "BATTLESHIP", battleshipQtd, boatsHandler);
	    boatLabels[2] = makeBoatLabel(cruiserIcon, "CRUISER", cruiserQtd, boatsHandler);
	    boatLabels[3] = makeBoatLabel(destroyerIcon, "DESTROYER", + destroyerQtd, boatsHandler);
	    boatLabels[4] = makeBoatLabel(submarineIcon, "SUBSPACE", submarineQtd, boatsHandler);
	    
	    for (int i = 0; i < boatLabels.length; i++)
	    {
	    	boatsPanel.add(boatLabels[i]);
	    }
	    
	    boatLabels[0].setBackground(selectedColor);
	    boatsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
	    
	    JLabel title = new JLabel("Set your Board!");
	    title.setFont(new Font("Papyrus",Font.PLAIN, 55));
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    
	    mainPanel.setLayout(new BorderLayout(10,10));
	    mainPanel.add(title, BorderLayout.NORTH);
		mainPanel.add(tilesPanel, BorderLayout.CENTER);
		mainPanel.add(boatsPanel, BorderLayout.EAST);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(mainPanel);
	}
	public JLabel makeBoatLabel(Icon icon, String boatName, int boatQtd, BoatsMouseHandler handler)
	{
		JLabel boatLabel = new JLabel(icon, JLabel.CENTER);
		boatLabel.setText("x" + boatQtd);
	    boatLabel.setHorizontalTextPosition(JLabel.CENTER);
	    boatLabel.setVerticalTextPosition(JLabel.BOTTOM);
	    boatLabel.setOpaque(true);
	    boatLabel.addMouseListener(handler);
	    boatLabel.setBorder(BorderFactory.createTitledBorder(boatName));
	    return boatLabel;
	}
	public JPanel boardPanel(int size)
	{
		JPanel tilesPanel = new JPanel();
		tiles = new Tiles[size][size];
		tilesPanel.setPreferredSize(new Dimension(500, 500));
		GridLayout layout = new GridLayout(size, size, 1, 1);
		tilesPanel.setLayout(layout);
		TilesMouseHandler tilesHandler = new TilesMouseHandler();
		for (int i = 0; i < size; i++) 
		{
			for (int j = 0; j < size; j++)
			{
				tiles[i][j] = new Tiles(i,j);
				tiles[i][j].addMouseListener(tilesHandler);
				
				/*
				if (board.board[i][j] != ' ')
				{
					tiles[i][j].setBackground(Color.ORANGE);
				} 
				*/
				tiles[i][j].setBorder(BorderFactory.createLineBorder(null, 1));
				tilesPanel.add(tiles[i][j]);
			}
		}
		return tilesPanel;
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
					Player enemyPlayer = new Player(size);
					player.board = board;
					enemyPlayer.setRandomBoard();
					
					getContentPane().removeAll();
					JLabel title = new JLabel("SPACESHIPS!!!!");
				    title.setFont(new Font("Papyrus",Font.PLAIN, 55));
				    title.setHorizontalAlignment(SwingConstants.CENTER);
					JPanel gamePanel = new BoardPanel(size, player, enemyPlayer);
					gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					getContentPane().add(title, BorderLayout.NORTH);
					getContentPane().add(gamePanel);
					pack();
					getContentPane().revalidate();
					getContentPane().repaint();

				//	frame.add(new BattleshipMain());
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
