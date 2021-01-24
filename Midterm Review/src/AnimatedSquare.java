import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class AnimatedSquare extends GraphicsProgram {
	public void run()
	{
		GRect square = new GRect(0, 0, 50, 50);
		square.setFilled(true);
		square.setFillColor(Color.RED);
		add(square);
		
		double dx = (getWidth() - 50) / 100;
		double dy = (getHeight() - 50) / 100;
		for (int i = 0; i < 100; i++)
		{
			square.move(dx, dy);
			pause(100);
		}
	}

}
