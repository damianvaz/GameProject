import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeMainFrame extends JFrame
{
	JButton[][] buttons = new JButton[3][3];
	private GridLayout gridLayout; 
	private char player, opponent;
	private Action lastAction;
	private int turn = 0;
	public JLabel label;
	private JPanel panel;
	
	public TicTacToeMainFrame()
	{
		super("TicTacToe Game by Damian Vaz");
		String thinkingString = "I am thinking ";
		label = new JLabel(thinkingString);
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 300));
		label.setVisible(false);
		drawFrame();
		
	}
	public void clearFrame()
	{
		this.dispose();
	}

	public void revalidateFrame()
	{
		this.revalidate();
		this.pack();
	}

	public void showLabelThinking()
	{
		label.setVisible(true);
		this.revalidate();
		this.pack();
	}
	public void hideLabelThinking()
	{
		label.setVisible(false);
		this.revalidate();
		this.pack();
	}
	public void drawFrame()
	{
		this.add(label, BorderLayout.SOUTH);

		Object[] options1 = {"I want to be Player X", "I want to be Player O"};
		
		int mode = JOptionPane.showOptionDialog(null, "Choose your Player", "Player Selection", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options1, null);
		if (mode == JOptionPane.YES_OPTION)
		{
			player = 'X';
		}
		else
		{
			player = 'O';
		}
		
		opponent = player == 'X' ? 'O' : 'X';
		gridLayout = new GridLayout(3, 3, 5, 5);
		panel.setBackground(Color.BLACK);
		panel.setLayout(gridLayout);
		ButtonHandler buttonHandler = new ButtonHandler();
		for (int i = 0; i < buttons.length; i++)
		{
			for (int j = 0; j < buttons[i].length; j++)
			{
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(Color.WHITE);
			    buttons[i][j].addActionListener(buttonHandler);
				panel.add(buttons[i][j]);
			}
		}
		add(panel);
		this.revalidate();
	}

	public void setButtonText(int i, int j)
	{
		buttons[i][j].setText("" + opponent);
		buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 73));
		turn++;
	}
	public Action getAction()
	{
		return this.lastAction;
	}
	public boolean isActionSet()
	{
		if(lastAction != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void clearAction()
	{
		lastAction = null;
	}
	public char getPlayer()
	{
		return this.player;
	}
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (player == 'X')
			{
				int rest = turn % 2;
				if (rest != 0)
				{
					JOptionPane.showMessageDialog(null, "It's still my turn! \n be patient I'm thinking", "Hold On", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					turn++;
					int x = 0;
					int y = 0;
					JButton buttonPressed = (JButton) e.getSource();
					for (int i = 0; i < buttons.length; i++)
					{
						for (int j = 0; j < buttons[i].length; j++)
						{
							if (buttonPressed.equals(buttons[i][j]))
							{
								x = i;
								y = j;
							}
						}
					}
					lastAction = new Action(x, y);
					buttonPressed.setFont(new Font("Arial", Font.PLAIN, 73));
					buttonPressed.setText("" + player);
				}
			}
			else
			{
				int rest = turn % 2;
				if (rest == 0)
				{
					JOptionPane.showMessageDialog(null, "It's still my turn! \n be patient I'm thinking", "Hold On", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					turn++;
					int x = 0;
					int y = 0;
					JButton buttonPressed = (JButton) e.getSource();
					for (int i = 0; i < buttons.length; i++)
					{
						for (int j = 0; j < buttons[i].length; j++)
						{
							if (buttonPressed.equals(buttons[i][j]))
							{
								x = i;
								y = j;
							}
						}
					}
					lastAction = new Action(x, y);
					buttonPressed.setFont(new Font("Arial", Font.PLAIN, 73));
					buttonPressed.setText("" + player);
				}
			}
			
		}
		
	}
}
