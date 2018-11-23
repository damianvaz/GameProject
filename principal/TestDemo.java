import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class TestDemo extends JPanel implements ActionListener{
    private JPanel lButton, rButton, textPan, turnPan;
    private JRadioButton turnC, turnP;
    private JTextArea jta;
    private static JMenuBar menuBar;
    private JRadioButton jrb;
    private static int SIZE = 10;
    private JButton[][] left, right;
    private int rand1, rand2;
    private int turnIndicator; //Allows the swap method to switch between player turn and computer turn 0 = player turn, 1 = computer turn
    public TestDemo(){
        setLayout(new FlowLayout(FlowLayout.CENTER));

        /** Buttons + Button Panels */
        lButton = new JPanel();
        lButton.setLayout(new GridLayout(SIZE,SIZE));
        rButton = new JPanel();
        rButton.setLayout(new GridLayout(SIZE,SIZE));
        left = new JButton[SIZE][SIZE];
        right = new JButton[SIZE][SIZE];
        turnIndicator = 0; 
        for (char row = 'A'; row <= 'J'; row++) 
            for (int col = 1, i = 0, j = 0; col <= 10 && i < SIZE && j < SIZE; col++, i++, j++) {
                left[i][j] = new JButton("" + row + col);
                right[i][j] = new JButton(""+row+col);
                left[i][j].setMargin(new Insets(0, 0, 0, 0));
                left[i][j].setPreferredSize(new Dimension(40, 40));
                right[i][j].setMargin(new Insets(0, 0, 0, 0));
                right[i][j].setPreferredSize(new Dimension(40, 40));
                left[i][j].addActionListener(this);
                right[i][j].addActionListener(this);
                lButton.add(left[i][j]);
                rButton.add(right[i][j]);
            }//end for
        /** End of Buttons + Button panels */

        /** Text Area */
        jta = new JTextArea(5,25);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setEditable(false);
        jta.setVisible(true);
        textPan = new JPanel();
        textPan.setLayout(new FlowLayout(FlowLayout.CENTER));
        textPan.add(new JScrollPane(jta));
        /** End of Text Area */

        /** Turn radio button */
        turnC = new JRadioButton("Computer");
        turnC.addActionListener(this);
        turnC.setEnabled(false);
        turnP = new JRadioButton("Player");
        turnP.addActionListener(this);
        turnP.setEnabled(false);
        ButtonGroup group = new ButtonGroup();
        group.add(turnC);
        group.add(turnP);
        turnP.setSelected(true);
        turnPan = new JPanel();
        turnPan.setLayout(new BorderLayout());
        turnPan.add(turnC, BorderLayout.LINE_START);
        turnPan.add(turnP, BorderLayout.LINE_END);
        /** End turn radio button and label */

        /** Menu setup */
        menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        JMenuItem newGame = new JMenuItem("New Game"); newGame.addActionListener(this);
        JMenuItem exit = new JMenuItem("Exit"); exit.addActionListener(new exitApp());
        newGame.setMnemonic(KeyEvent.VK_N); exit.setMnemonic(KeyEvent.VK_E);
        newGame.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        menuBar.add(file);
        file.add(newGame); file.add(exit);
        /** End Menu setup */

        JPanel gameTest = new JPanel();
        gameTest.setLayout(new BorderLayout());
        gameTest.add(lButton, BorderLayout.LINE_START);
        gameTest.add(rButton, BorderLayout.LINE_END);
        gameTest.add(textPan, BorderLayout.PAGE_END);
        gameTest.add(turnPan, BorderLayout.CENTER);
        add(gameTest);  
    }//end TestDemo

public static void main(String[] args) {
    JFrame frame = new JFrame();
    TestDemo td = new TestDemo();
    frame.add(td);
    frame.setVisible(true);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setJMenuBar(menuBar);
}//end main

public void actionPerformed(ActionEvent e)
{
    JButton pressed = (JButton) e.getSource();
    if(turnIndicator == 0)
    {

    turnP.setSelected(true);
    (pressed).setEnabled(false);
    jta.append("Shot fired at : " + (pressed).getActionCommand() + '\n' );
    turnIndicator = 1;
    } 
    turnC.setSelected(true);
    swap(); //Throwing an error

}//end actionPerformed

public void compAttk()
{
    ArrayList<Integer> key1 = new ArrayList<Integer>(100);
    ArrayList<Integer> key2 = new ArrayList<Integer>(100);
    rand1 = (int) ((Math.random() * 10) + 1);
    rand2 = (int) ((Math.random() * 10) + 1);
    if(key1.contains(rand1) || key2.contains(rand2))/** Checks if the coords are already pressed*/
    {
        rand1 = (int) ((Math.random() * 10) + 1);
        rand2 = (int) ((Math.random() * 10) + 1);
        right[rand1][rand2].setEnabled(false); //I'm sure will also throw an error
    }
    right[rand1][rand2].setEnabled(false); //Throwing an error
    key1.add(rand1);
    key2.add(rand2);
    turnIndicator = 0;
}//end compAttk

public void swap() //Once user presses a button, turnIndicator will initialize to 1, then this method handles what happens afterwards.
{
    if(turnIndicator == 1)
    {
        compAttk(); //Throwing an error
        turnIndicator = 0;
    }
    else
       JOptionPane.showMessageDialog(null, "Your turn");
}//end swap
static class exitApp implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
}//end exitApp
}//end TestDemo class