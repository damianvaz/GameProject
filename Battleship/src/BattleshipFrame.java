import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BattleshipFrame extends JFrame
{
	private JButton[][] buttons;
	private JLabel[][] labels;
	private JPanel buttonsPanel;
	private JPanel labelsPanel;
	
	
	public BattleshipFrame(int size)
	{
		super("Battleship");
		
		buttons = new JButton[size][size];
		buttonsPanel = new JPanel();
		
		labels = new JLabel[size][size];
		labelsPanel = new JPanel();
		
		GridLayout layout = new GridLayout(size, size, 0, 0);
		buttonsPanel.setLayout(layout);
		labelsPanel.setLayout(layout);
		
		
		
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				buttons[i][j] = new JButton();
				// add listener
				buttonsPanel.add(buttons[i][j]);
				
				labels[i][j] = new JLabel("");
				labelsPanel.add(labels[i][j]);
			}
		}
		labelsPanel.setBackground(Color.CYAN);
		Border insideBorder  = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		Border outsideBorder = BorderFactory.createTitledBorder("Enemy Territory");
		buttonsPanel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
		buttonsPanel.setPreferredSize(new Dimension(500, 500));
		labelsPanel.setPreferredSize(new Dimension(500, 500));
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(buttonsPanel);
		horizontalBox.add(labelsPanel);

		add(horizontalBox);
		
		//add(labelsPanel);
		
	}
	public static void main(String[] args)
	{
		BattleshipFrame f = new BattleshipFrame(10);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.setResizable(false);
		f.pack();
	}
	
	
}
