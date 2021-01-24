import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Demo extends GraphicsProgram{
	
	public void run()
	{
//		BaseClass cl = new BaseClass();
//		
//		int x = 1;
//		BaseClass cl2 = new BaseClass(x);
//		
//		cl2.setOutputString("Hello World");
//		
//		System.out.println(cl2.outputString);
//		
//		cl2.inputHeight = 50;
//		cl2.inputWidth = 75;
//		
//		System.out.println(cl2.getArea());
		
		BaseClass circle = new BaseClass(50, 75, Color.red);
		
		this.resize(600,600);
		
		GOval ball = new GOval(100, 100, circle.inputWidth, circle.inputHeight);
		
		ball.setFilled(true);
		ball.setColor(circle.color);
		
		add(ball);
		
		circle.increaseByFactor(3);
		
		GRect r = new GRect(300, 300, circle.inputWidth, circle.inputHeight);
		
		add(r);
	}

}
