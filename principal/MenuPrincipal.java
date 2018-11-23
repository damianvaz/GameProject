package menu.principal;
import java.net.MalformedURLException;
import javax.swing.JFrame;
public class MenuPrincipal {

    public static void main(String[] args) throws MalformedURLException {
        LabelFrame labelFrame = new LabelFrame();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.setSize(804,600);
        labelFrame.setResizable(false);
        labelFrame.setVisible(true);
    }
}
