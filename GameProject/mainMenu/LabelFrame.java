
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.net.*;
import javax.swing.*;

import com.sun.glass.events.MouseEvent;

public class LabelFrame extends JFrame 
{
    private JPanel panel1;
    private JLabel label1;
    private JButton battleshipButton, ticTacToeButton;
    private final URL background = getClass().getResource("mainMenuBackground.jpg");
    Icon battleshipIcon = new ImageIcon(getClass().getResource("battleshipButton.png"));
    Icon ticTacIcon = new ImageIcon(getClass().getResource("ticTacToeButton.png"));
    
    public LabelFrame() throws MalformedURLException 
    {
        super("Main Menu");
        setLayout(new BorderLayout());
        
        panel1 = new myCustomPanel(background);
        panel1.setLayout(new GridLayout());
                
        battleshipButton = new JButton();
        battleshipButton.setIcon(battleshipIcon);
        battleshipButton.setOpaque(false);
        battleshipButton.setContentAreaFilled(false);
        battleshipButton.setBorderPainted(false);
        battleshipButton.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        
        ticTacToeButton = new JButton();
        ticTacToeButton.setIcon(ticTacIcon);
        ticTacToeButton.setOpaque(false);
        ticTacToeButton.setContentAreaFilled(false);
        ticTacToeButton.setBorderPainted(false);
        ticTacToeButton.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        
        this.add(panel1);
        panel1.add(battleshipButton);
        panel1.add(ticTacToeButton);
        
    }
}
