import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame
{
	private JPanel panel1;
	private JButton battleshipButton, ticTacButton;
	private JFrame frame;
	private final URL background = getClass().getResource("fundo jogo.jpg");
	Icon battleshipIcon = new ImageIcon(getClass().getResource("battleship botao.png"));
	Icon ticTacIcon = new ImageIcon(getClass().getResource("jogo da velha botao.png"));

	public void clearFrame()
	{
		this.dispose();
	}
	public MainMenu() throws MalformedURLException
	{
		super("Main Menu");
		frame = this;

		setLayout(new BorderLayout());

		panel1 = new backgroundAdapt(background);
	//	panel1.setLayout(new GridBagLayout());

		battleshipButton = new JButton();
		battleshipButton.setIcon(battleshipIcon);
		battleshipButton.setOpaque(false);
		battleshipButton.setContentAreaFilled(false);
		battleshipButton.setBorderPainted(false);
		battleshipButton.setBorder(BorderFactory.createEmptyBorder(250, 0, 0, 0));
		battleshipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				clearFrame();
				frame = new difficultyMenu();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setVisible(true);
				frame.setResizable(false);
			}
		});

		ticTacButton = new JButton();
		ticTacButton.setIcon(ticTacIcon);
		ticTacButton.setOpaque(false);
		ticTacButton.setContentAreaFilled(false);
		ticTacButton.setBorderPainted(false);
		ticTacButton.setBorder(BorderFactory.createEmptyBorder(250, 50, 0, 0));
		ticTacButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				clearFrame();
				TicTacToeMainFrame f = new TicTacToeMainFrame();
				TicTacToe.startGame();
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.pack();
				f.setVisible(true);
				f.setResizable(false);
				/*
				
				
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.pack();
				f.setVisible(true);
				*/
			}
		});

		this.add(panel1);
		panel1.add(battleshipButton);
		panel1.add(ticTacButton);
	}
}
