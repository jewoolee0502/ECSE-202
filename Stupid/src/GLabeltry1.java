import java.awt.Color;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class GLabeltry1 extends GraphicsProgram 
{
	public void run()
	{
		GLabel label = new GLabel("Hello, World", 100, 75); //using the method GLabel, and I named it label. add a new GLabel and let it say "Hello World" at coordinates 100 and 75
		label.setFont("TimesNewRomans-36"); //setting GLabel called label's font to TimesNewRomans and size 36
		label.setColor(Color.RED); //setting GLabel called label's color red
		add(label); // adding the GLabel --> using Graphics Program; we use the method add and not println
	}

}


//GLabel label = new GLabel("hello,world", 100, 75);       
//label.setFont("SansSerif-36");       
//label.setColor(Color.RED);       
//add(label); 


//instead of using all of that, I can do the same thing with just one line shown below:
//add(new GLabel("Hello World", 100, 75));