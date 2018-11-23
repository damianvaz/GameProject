package menu.principal;

import java.awt.*;
import java.net.*;
import javax.swing.*;

public class LabelFrame extends JFrame {
    private JPanel panel1;
    private JLabel label1;
    private JButton battleshipButton, ticTacButton;
    private final URL background = getClass().getResource("fundo jogo.jpg");
    Icon battleshipIcon = new ImageIcon(getClass().getResource("battleship botao.png"));
    Icon ticTacIcon = new ImageIcon(getClass().getResource("jogo da velha botao.png"));
    
    public LabelFrame() throws MalformedURLException {
        super("Main Menu");
        setLayout(new BorderLayout());
        
        panel1 = new myCustomPanel(background);
        panel1.setLayout(new GridLayout());
        
        battleshipButton = new JButton();
        battleshipButton.setIcon(battleshipIcon);
        battleshipButton.setOpaque(false);
        battleshipButton.setContentAreaFilled(false);
        battleshipButton.setBorderPainted(false);
        
        ticTacButton = new JButton();
        ticTacButton.setIcon(ticTacIcon);
        ticTacButton.setOpaque(false);
        ticTacButton.setContentAreaFilled(false);
        ticTacButton.setBorderPainted(false);
        
        this.add(panel1);
        panel1.add(battleshipButton);
        panel1.add(ticTacButton);
        
    }
}
