import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Demo2 extends GraphicsProgram {

	public void run()
	{
		BaseClass2 cl = new BaseClass2(100, 50);
		
		BaseClass2 cl2 = new BaseClass2(50, 60);
		
		cl2.inputHeight = 50;
		cl2.inputWidth = 60;
		
		System.out.println(cl2.inputHeight);
		
		cl.inputColor = Color.red;
		cl2.inputColor = Color.blue;
		
		this.resize(500, 500);
		
		GOval ball = new GOval(100, 100, cl.inputWidth, cl.inputHeight);
		ball.setColor(cl.inputColor);
		
		cl.inputHeight = 200;
		
		add(ball);
		
		GRect rect = new GRect(300, 300, cl2.inputWidth, cl2.inputHeight);
		rect.setColor(cl2.inputColor);
		
		add(rect);
		
	}
	
}
