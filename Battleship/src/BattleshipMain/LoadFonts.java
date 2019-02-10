package BattleshipMain;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

public abstract class LoadFonts
{
	/*
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
*/
	public static Font getMainFont(float size)
	{
		// load PressStart2P-Regular Font
		Font mainFont = null;
		InputStream is = GameFrame.class.getResourceAsStream("/resources/PressStart2P-Regular.ttf");
		try
		{
			mainFont = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		 		
		return mainFont.deriveFont(size);
	}
	public static Font getTitleFont(float size)
	{
		Font titleFont = null;
		InputStream is = GameFrame.class.getResourceAsStream("/resources/PressStart2P-Regular.ttf");
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
 		
		return titleFont.deriveFont(size);
	}
}
