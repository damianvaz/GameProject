package BattleshipMain;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public class LoadFonts
{
	private Font titleFont;
	private Font mainFont;
	
	public LoadFonts()
	{
		// load PressStart2P-Regular Font
 		InputStream is = GameFrame.class.getResourceAsStream("PressStart2P-Regular.ttf");
 		try
 		{
 			titleFont = Font.createFont(Font.TRUETYPE_FONT, is);
 		} catch (FontFormatException e)
 		{
 			e.printStackTrace();
 		} catch (IOException e)
 		{
 			e.printStackTrace();
 		}
 		
	 	// load PressStart2P-Regular Font
		InputStream is2 = GameFrame.class.getResourceAsStream("PressStart2P-Regular.ttf");
		try
		{
			mainFont = Font.createFont(Font.TRUETYPE_FONT, is2);
		} catch (FontFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public Font getMainFont(float size)
	{
		return mainFont.deriveFont(size);
	}
	public Font getTitleFont(float size)
	{
		return titleFont.deriveFont(size);
	}
}
