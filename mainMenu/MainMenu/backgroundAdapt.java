package MainMenu;
import java.awt.*;
import java.net.*;
import javax.swing.*;

public class backgroundAdapt extends JPanel
{

	private Image background;

	public backgroundAdapt(URL path)
	{
		this.background = new ImageIcon(path).getImage();
		setOpaque(false);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
	}

	backgroundAdapt()
	{
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																	   // Tools | Templates.
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, this);
		super.paintComponent(g);
	}

	@Override
	public int getWidth()
	{
		return background.getWidth(this);
	}

	@Override
	public int getHeight()
	{
		return background.getHeight(this);
	}
}