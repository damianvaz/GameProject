package principal;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class difficultyMenu extends JFrame {
    private JPanel panel1;
    private JButton easyButton, mediumButton, hardButton;
    private final URL background = getClass().getResource("background2.jpg");
    Icon easyIcon = new ImageIcon(getClass().getResource("easy.png"));
    Icon mediumIcon = new ImageIcon(getClass().getResource("medium.png"));
    Icon hardIcon = new ImageIcon(getClass().getResource("hard.png"));
    
    public difficultyMenu(){
        super("Main Menu");
        setLayout(new BorderLayout());
        
        panel1 = new backgroundAdapt(background);
        panel1.setLayout(new GridBagLayout());
        
        easyButton = new JButton();
        easyButton.setIcon(easyIcon);
        easyButton.setOpaque(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setBorderPainted(false);
        
        mediumButton = new JButton();
        mediumButton.setIcon(mediumIcon);
        mediumButton.setOpaque(false);
        mediumButton.setContentAreaFilled(false);
        mediumButton.setBorderPainted(false);
        
        hardButton = new JButton();
        hardButton.setIcon(hardIcon);
        hardButton.setOpaque(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setBorderPainted(false);
        
        this.add(panel1);
        panel1.add(easyButton);
        panel1.add(mediumButton);   
        panel1.add(hardButton);   
    }
}
