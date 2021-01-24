import java.awt.Color;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GRectPlusGOval extends GraphicsProgram {
	public void run()
	{
		this.setSize(700, 700);
		
		GRect rect = new GRect(100, 100, 50, 50);
		rect.setFilled(true);
		rect.setFillColor(Color.RED);
		add(rect);
		
		GOval oval = new GOval(100, 100, 50, 50);
		oval.setFilled(true);
		oval.setFillColor(Color.GREEN);
		add(oval);
		
		GLabel label = new GLabel("Rectangle plus Oval", 100, 200);
		label.setColor(Color.BLACK);
		label.setFont("Arial-BOLD-30");
		add(label);
	}

}
