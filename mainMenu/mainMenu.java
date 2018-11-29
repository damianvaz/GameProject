package principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import javax.swing.*;

public class mainMenu extends JFrame {
    private JPanel panel1;
    private JButton battleshipButton, ticTacButton;
    private final URL background = getClass().getResource("fundo jogo.jpg");
    Icon battleshipIcon = new ImageIcon(getClass().getResource("battleship botao.png"));
    Icon ticTacIcon = new ImageIcon(getClass().getResource("jogo da velha botao.png"));
    
    public mainMenu() throws MalformedURLException {
        super("Main Menu");
        setLayout(new BorderLayout());
        
        panel1 = new backgroundAdapt(background);
        panel1.setLayout(new GridBagLayout());
        
        battleshipButton = new JButton();
        battleshipButton.setIcon(battleshipIcon);
        battleshipButton.setOpaque(false);
        battleshipButton.setContentAreaFilled(false);
        battleshipButton.setBorderPainted(false);
        battleshipButton.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        battleshipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            difficultyMenu frame2 = new difficultyMenu();
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setSize(804,600);
            frame2.setResizable(false);
            frame2.setVisible(true);
            }
        });
        
        ticTacButton = new JButton();
        ticTacButton.setIcon(ticTacIcon);
        ticTacButton.setOpaque(false);
        ticTacButton.setContentAreaFilled(false);
        ticTacButton.setBorderPainted(false);
        ticTacButton.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        ticTacButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                ticTacToeBoard gameFrame = new ticTacToeBoard();
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setSize(804,600);
                gameFrame.setResizable(false);
                gameFrame.setVisible(true);
                        
            }
        });
        
        this.add(panel1);
        panel1.add(battleshipButton);
        panel1.add(ticTacButton);   
    }
}
