import java.awt.Color;

public class BaseClass {

	public String outputString;
	public int inputHeight;
	public int inputWidth;
	public Color color;
	
	public BaseClass()
	{
		System.out.println("Class Created");
	}
	
	public BaseClass(int input)
	{
		System.out.println("Class Create: " + input);
	}
	
	public BaseClass(int height, int width, Color c)
	{
		inputHeight = height;
		inputWidth = width;
		color = c;
	}
	
	public void setOutputString(String str)
	{
		outputString = str;
	}
	
	public int getArea()
	{
		return inputWidth * inputHeight;
	}
	
	public void increaseByFactor(int f)
	{
		inputHeight *= f;
		inputWidth *= f;
	}
	
	
}
