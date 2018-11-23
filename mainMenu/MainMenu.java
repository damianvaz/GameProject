import java.net.MalformedURLException;
import javax.swing.JFrame;
public class MainMenu 
{

    public static void main(String[] args) throws MalformedURLException 
    {
        LabelFrame labelFrame = new LabelFrame();
        labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        labelFrame.pack();;
        labelFrame.setResizable(false);
        labelFrame.setVisible(true);
    }
}
