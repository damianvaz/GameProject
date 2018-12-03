import java.awt.Color;
import java.net.MalformedURLException;
import javax.swing.JFrame;

public class gameExecutor
{
	public static void main(String[] args) throws MalformedURLException
	{
		MainMenu frame = new MainMenu();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
	}
	
}
