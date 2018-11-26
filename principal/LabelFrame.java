package menu.principal;

import java.awt.*;
import java.awt.event.ActionEvent;
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
        
        //essa parte tem que ter em todas as telas do jogo
        //fazer só quando tiver acabado pq não é necessário ter isso
        
        JMenu fileMenu = new JMenu("Arquivo");
        fileMenu.setMnemonic('A');
        JMenuItem novoItem = new JMenuItem("Novo");
        novoItem.setMnemonic('N');
        novoItem.addActionListener((ae) -> {
            
            //fazer com que comece um novo jogo
        
        });
        fileMenu.add(novoItem);
        JMenuItem sobreItem = new JMenuItem("Sobre");
	sobreItem.setMnemonic('S');
	fileMenu.add(sobreItem);
	sobreItem.addActionListener((ActionEvent event) -> {
            JLabel labelSobre =new JLabel(); // escrever aqui o 'sobre' do arquivo       
            JOptionPane.showMessageDialog(null, labelSobre,"Sobre",JOptionPane.INFORMATION_MESSAGE);
        });
        JMenuItem sairItem = new JMenuItem("Sair");
        sairItem.setMnemonic('X');
        fileMenu.add(sairItem);
        sairItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        
        JMenu historicoMenu = new JMenu("Histórico");
        historicoMenu.setMnemonic('H');  //fazer aqui aparecer o histórico dos pontos que serializamos
                       
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
	bar.add(fileMenu);
        bar.add(historicoMenu);
        
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
