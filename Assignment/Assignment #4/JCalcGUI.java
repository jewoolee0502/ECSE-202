import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

import acm.gui.TableLayout;
import acm.program.Program;

public class JCalcGUI extends Program {
	
	private TextField input;
	private TextField result;
	private Queue Qin = new Queue();  // Queue for input expressions  
	private postFix pf = new postFix();  // Postfix converter and interpreter   
	
	public void init() {
	
	this.resize(640,280);
	setLayout(new TableLayout(9,4));
	input = new TextField("");
	result = new TextField();
	
	add(input, "gridwidth=4");
	add(result, "gridwidth=4");
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
	
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
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
				|| cmd.equals(")")){
				
				input.setText(input.getText()+cmd);
					
				}
			
			else if (cmd.equals("C")) {
				input.setText("");
				result.setText("");
				
			}
			
			else if (cmd.equals("Quit")) System.exit(0);
			
			else if (cmd.equals("=")) {
				   
					pf.parse(input.getText(), Qin);    	// Parse    
					result.setText(Double.toString(pf.doExpression(Qin)));
					input.setText(input.getText()+cmd);
			}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_ENTER) {
			   
		pf.parse(input.getText(), Qin);    	// Parse    
		result.setText(Double.toString(pf.doExpression(Qin)));
		input.setText(input.getText()+"=");
		}
		
		else if (key == KeyEvent.VK_ESCAPE) System.exit(0);

		
		
	}
	
	
	
	
	
	
}