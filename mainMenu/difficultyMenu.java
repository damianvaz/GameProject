import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;

public class difficultyMenu extends JPanel
{
    private JPanel panel1;
    private JButton easyButton, mediumButton, hardButton;
    private final URL background = getClass().getResource("background2.jpg");
    Icon easyIcon = new ImageIcon(getClass().getResource("easy.png"));
    Icon mediumIcon = new ImageIcon(getClass().getResource("medium.png"));
    Icon hardIcon = new ImageIcon(getClass().getResource("hard.png"));
    
    public difficultyMenu()
    {
        setLayout(new BorderLayout());
        
        panel1 = new backgroundAdapt(background);
        panel1.setLayout(new GridBagLayout());
        
        buttonHandler handler = new buttonHandler();
        
        easyButton = new JButton();
        easyButton.setIcon(easyIcon);
        easyButton.setOpaque(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setBorderPainted(false);
        easyButton.setBorder(BorderFactory.createEmptyBorder(250, 25, 0, 0));
        easyButton.addActionListener(handler);

        
        mediumButton = new JButton();
        mediumButton.setIcon(mediumIcon);
        mediumButton.setOpaque(false);
        mediumButton.setContentAreaFilled(false);
        mediumButton.setBorderPainted(false);
        mediumButton.setBorder(BorderFactory.createEmptyBorder(250, 25, 0, 0));
        mediumButton.addActionListener(handler);

        
        hardButton = new JButton();
        hardButton.setIcon(hardIcon);
        hardButton.setOpaque(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setBorderPainted(false);
        hardButton.setBorder(BorderFactory.createEmptyBorder(250, 25, 0, 0));
        hardButton.addActionListener(handler);

        
        panel1.add(easyButton);
        panel1.add(mediumButton);   
        panel1.add(hardButton);   
        this.add(panel1);

    }

    
    private class buttonHandler implements ActionListener
    {

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton buttonPressed = (JButton) e.getSource();
			
			if (buttonPressed.equals(easyButton))
			{
				BattleshipMain battleship = new BattleshipMain(10);
			}
			else if (buttonPressed.equals(easyButton))
			{
				BattleshipMain battleship = new BattleshipMain(15);
			}
			else
			{
				BattleshipMain battleship = new BattleshipMain(20);
			}
		}
    	
    }
}
