import java.awt.Color;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class GProgram extends GraphicsProgram {
	public void run()
	{	
		this.setSize(700,700);
		GLabel label = new GLabel("Hello World");
		label.setFont("Arial-Italic-35");
		label.setColor(Color.RED);
		label.setLocation(100,200); // or the location can be set as ("Hello World", 100, 200):
		add(label);
	}

}
