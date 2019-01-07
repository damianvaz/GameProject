package BattleshipMain;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundAdapt extends JPanel
{

	private Image background;

	public BackgroundAdapt(URL path)
	{
		this.background = new ImageIcon(path).getImage();
		setOpaque(false);
		setPreferredSize(new Dimension(getWidth(), getHeight()));
	}

	BackgroundAdapt()
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