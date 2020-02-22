package ictgradschool.industry.swing.examples.example7;

import javax.swing.*;

/**
 * A Swing Application that demonstrates most of the functionality needed to
 * complete the lab exercises. This application provides a user with a canvas on
 * which to draw shapes. Each click will produce a new shape as defined by a
 * series of controls on the left of the window. These controls include shape
 * type and scale size (as text fields). There are also buttons for cycling
 * through the available shapes (Square, Diamond, Triangle, Hourglass) and for
 * clearing the canvas. Finally, there is a button to start and stop the
 * animation of the canvas (where the shapes will randomly move about, 'jumping'
 * back to the center of the canvas if they ever 'fall off' the edge).
 * 
 * This example code demonstrates:
 * 1. Text field entry, value getting and setting
 * 2. Capturing button clicks and determining click source (multiple buttons)
 * 3. Drawing shapes (and other graphics activities) onto a JPanel
 * 4. Capturing mouse click locations
 * 5. Triggering events on a timer, and starting and stopping timers
 * 
 * Important aspects to understand:
 * - You create and nest JPanels (or other containers), and use different
 *   LayoutManagers (Border, Grid, Box, Group, GridBag etc) to layout GUI
 * - You then add other components (Fields, Labels, Buttons) into the
 *   JPanels to provide functionality
 * - One of the trickiest and most important things to get right is variable
 *   scope. To be able to test which button triggered an event, the button
 *   reference must be visible down in "ActionPerformed()" not just in the
 *   constructor, and thus needs to be an instance-level variable (field).
 *   In contrast, labels aren't needed anywhere else, so can be declared only
 *   in the constructor
 * - Similar to above, inter-JPanel communication can get complex, but
 *   typically involves either: a) creating a component first and passing
 *   or registering it with both panels, or b) one panel, or both, holding
 *   references to the other. We have an example of the former in the Timer an
 *   example of the later in the registerCanvas()/clearCanvas() methods
 * - A lot of interaction involves timing... you need components to be
 *   displayed or have default values before you try and interact with them
 *   (you will invariably, do this at some stage and get a bunch of unexpected
 *   NullPointerExceptions). An example of where this could go wrong is with
 *   the Timer; what would happen if its first event triggered before the
 *   JPanel serving as a canvas had been added to a container to be drawn on
 *   screen? What is the graphics context at that point?
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 *
 */
public class ExampleSevenMain {

	/**
	 * JVM entry point to the application.
	 * 
	 * @param args
	 *            any arguments given to the application as a String[]
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Pretty much every GUI project ever has a statement like this to
				// create the frame (commonly known as the window). This is the bit
				// that has the title/menu bar, and the minimize/maximize,
				// windowize/restore, and destroy buttons to the top-right. Frames
				// are also resizable (by default) allowing you to 'drag' the edges.
				// This frame will (attempt to) open 100 pixels from the top and the
				// right (top right is the origin, i.e. 0,0, like in JavaScript)
				E7JFrame gui = new E7JFrame("Complete Example", 100, 100, 640, 480);
				// We could do this in the constructor for E7JFrame, of course, but
				// if we do it here Eclipse doesn't complain about us never using the
				// gui variable
				gui.setVisible(true);
			}
		});

	}
	/** main(String[]) => void **/
}
