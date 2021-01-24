import java.awt.Color;

public class BaseClass2 
{

	private String inputString;
	public int inputHeight;
	public int inputWidth;
	public Color inputColor;
	
	
	public BaseClass2(int height, int width)
	{
		inputHeight = height;
		inputWidth = width;
	}
	
	
	public String getInputString()
	{
		return inputString;
	}
	
	public void setInputString(String str)
	{
		inputString = str;
	}
	
	public int getArea()
	{
		return (inputHeight * inputWidth);
	}
}
