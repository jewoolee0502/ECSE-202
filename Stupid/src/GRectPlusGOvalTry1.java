import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class GRectPlusGOvalTry1 extends GraphicsProgram {
	public void run()
	{
		GRect rect = new GRect(100, 50, 125, 60);
		rect.setFilled(true);
		rect.setColor(Color.RED);
		add(rect);
		GOval oval = new GOval(100, 50, 125, 60);
		oval.setFilled(true);
		oval.setColor(Color.GREEN);
		add(oval);
	}

}
