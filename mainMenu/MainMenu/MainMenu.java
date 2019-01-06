package MainMenu;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainTicTacToe.TicTacToe;

public class MainMenu extends JFrame
{
	private JPanel panel1;
	private JButton battleshipButton, ticTacButton;
	private final URL background = getClass().getResource("mainMenuBackground.jpg");
	Icon battleshipIcon = new ImageIcon(getClass().getResource("battleshipButton.png"));
	Icon ticTacIcon = new ImageIcon(getClass().getResource("ticTacToeButton.png"));

	public MainMenu()// throws MalformedURLException
	{
		super("Main Menu");
		setLayout(new BorderLayout());

		panel1 = new backgroundAdapt(background);
		
		battleshipButton = new JButton();
		battleshipButton.setIcon(battleshipIcon);
		battleshipButton.setOpaque(false);
		battleshipButton.setContentAreaFilled(false);
		battleshipButton.setBorderPainted(false);
		battleshipButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					JPanel p = new difficultyMenu();
					getContentPane().removeAll();
					add(p);
					revalidate();
					repaint();
				}
			});

		ticTacButton = new JButton();
		ticTacButton.setIcon(ticTacIcon);
		ticTacButton.setOpaque(false);
		ticTacButton.setContentAreaFilled(false);
		ticTacButton.setBorderPainted(false);
		ticTacButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				TicTacToe ticTacToe = new TicTacToe();
			}
		});
		
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(battleshipButton);
		buttonBox.add(ticTacButton);
		buttonBox.setBorder(BorderFactory.createEmptyBorder(250, 50, 0, 0));
		
		panel1.add(buttonBox);
		add(panel1);
	}
}
