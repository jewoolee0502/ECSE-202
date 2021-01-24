import acm.program.ConsoleProgram;

/*
 * File: SignalTower.java
 * ----------------------
 * This file defines the SignalTower class.
 */

/**
 * This class defines a signal tower object that passes a message
 * to the next tower in a line.
 * 
 * HACKERY
 * 
 *    The testTower program extends ConsoleProgram and thus has
 *    access to ACM functions.  SignalTower DOES NOT.  So, we
 *    include a link to testTower solely for the purpose of
 *    having access to all its methods.  Notice that the link
 *    is of type ConsoleProgram.
 */

public class SignalTower {

/**
 * Constructs a new signal tower with the following parameters:
 * @param name The name of the tower
 * @param link A link to the next tower, or null if none exists
 */
	public SignalTower(String name, SignalTower link, ConsoleProgram cLink) {
		towerName = name;
		nextTower = link;
		myConsole = cLink;
	}

/**
 * This method represents sending a signal to this tower. The effect
 * is to light the signal fire here and to send an additional signal
 * message to the next tower in the chain, if any.
 */
	public void signal() {
		lightCurrentTower();
		if (nextTower != null) 
		{
			nextTower.signal();
		}
	}

/**
 * This method lights the signal fire for this tower. This version
 * that simply prints the name of the tower to the standard output
 * channel. If you wanted to extend this class to be part of a
 * graphical application, for example, you could override this
 * method to draw an indication of the signal fire on the display.
 */
	public void lightCurrentTower() {
		myConsole.println("Lighting " + towerName);				// Notice how we reference println
		myConsole.pause(50);									// and pause from the ConsoleProgram class.
	}

/* Private instance variables */
	private String towerName;       /* The name of this tower   */
	public SignalTower nextTower;   /* A link to the next tower */
	private ConsoleProgram myConsole;  /* link to ACM console */
}
