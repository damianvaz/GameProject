package principal;
import java.net.MalformedURLException;
import javax.swing.JFrame;
public class gameExecutor {

    public static void main(String[] args) throws MalformedURLException {
        mainMenu frame = new mainMenu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(804,600);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
