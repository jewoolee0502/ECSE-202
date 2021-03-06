
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import acm.gui.TableLayout;
import acm.program.Program;

/** JCalcGUI class for Assignment #4
 * 
 * @author Jewoo Lee (260910789)
 *
 */

public class JCalcGUI extends Program {

	private TextField input;
	private TextField result;
	private Queue Qin = new Queue();  				// Queue for input expressions  
	private postFix pf = new postFix();  			// Postfix converter and interpreter   

	/** 
	 * Adding each and every buttons to make it look like a calculator
	 */
	
	public void init() 								//making buttons on the calculator
	{
		this.resize(500,400);						//specific size for the calculator
		setLayout(new TableLayout(9,4));
		
		input = new TextField("");
		result = new TextField();

		add(input, "gridwidth = 4");
		add(result, "gridwidth = 4");
		add(new JButton("C"));
		add(new JButton(""));
		add(new JButton(""));
		add(new JButton("/"));
		add(new JButton("7"));
		add(new JButton("8"));
		add(new JButton("9"));
		add(new JButton("*"));
		add(new JButton("4"));
		add(new JButton("5"));
		add(new JButton("6"));
		add(new JButton("-"));
		add(new JButton("1"));
		add(new JButton("2"));
		add(new JButton("3"));
		add(new JButton("+"));
		add(new JButton("0"));
		add(new JButton("."));
		add(new JButton("^"));
		add(new JButton("="));
		add(new JButton("("));
		add(new JButton(")"));
		add(new JButton(""));
		add(new JButton(""));
		add(new JButton(""));
		add(new JButton(""));
		add(new JButton(""));
		add(new JButton("Quit"));

		addActionListeners();
		input.addKeyListener(this);
	}

	/**
	 * adding commands to each buttons
	 */
	
	public void actionPerformed(ActionEvent a) 		//what happens when the button is pressed
	{
		String cmd = a.getActionCommand();
		if (cmd.equals("0")
				|| cmd.equals("1")
				|| cmd.equals("2")
				|| cmd.equals("3")
				|| cmd.equals("4")
				|| cmd.equals("5")
				|| cmd.equals("6")
				|| cmd.equals("7")
				|| cmd.equals("8")	
				|| cmd.equals("9")
				|| cmd.equals("+")
				|| cmd.equals("-")
				|| cmd.equals("*")
				|| cmd.equals("/")
				|| cmd.equals(".")
				|| cmd.equals("(")
				|| cmd.equals(")"))
		{
			input.setText(input.getText() + cmd);
		}

		else if(cmd.equals("C")) 
		{
			input.setText("");
			result.setText("");
		}

		else if(cmd.equals("Quit")) 
			System.exit(0);

		else if (cmd.equals("=")) 
		{
			pf.parse(input.getText(), Qin);    	// Parse    
			result.setText(Double.toString(pf.doExpression(Qin)));
			input.setText(input.getText() + cmd);
		}
	}

	/**
	 * directing what happens when the button is pressed
	 */
	
	public void keyPressed(KeyEvent b) 
	{
		int key = b.getKeyCode();
		
		if (key == KeyEvent.VK_ENTER) 
		{
			pf.parse(input.getText(), Qin);    	// Parse    
			result.setText(Double.toString(pf.doExpression(Qin)));
			input.setText(input.getText() + "=");
		}
		
		else if(key == KeyEvent.VK_ESCAPE) 
			System.exit(0);
	}
}