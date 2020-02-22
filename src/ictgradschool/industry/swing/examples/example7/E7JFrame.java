package ictgradschool.industry.swing.examples.example7;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * The window in which our application will appear
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 *
 */
public class E7JFrame extends JFrame {
    
	/** All Java GUI components are 'serializable' (they can be written to
	 *  file or across a network socket - for remote desktop/applications)
	 *  and any serializable object needs this version number (given as a
	 *  long integer - I don't think you've seen this primitive before) so
	 *  that, later on, if it is reading this object out of a file it can
	 *  figure out what version of the class it is (or complain if it is
	 *  the wrong version for this class... more commonly). Anyhow, not
	 *  having this is only a warning... but I dislike squiggly lines
	 *  whether they be red or yellow!
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor - typically a frame will need information about the title
	 * text (String), the position and width/height, what to do when people
	 * click on the destroy icon (maybe you need to do tidyup before closing
	 * down). You also tend to create the main JPanel(s) that will serve as
	 * your GUI.  By default the contentPane of the JFrame is set to a
	 * BorderLayout manager - the CENTER expands to take up all space that
	 * isn't otherwise used by the NORTH, WEST, EAST, and SOUTH areas.
	 *  
	 * @param title
	 *           the text for the title bar as a String
	 * @param x
	 *           where the left of the window should be as an int in pixels
	 * @param y
	 *           where the top of the window should be
	 * @param width
	 *           the desired width of the windows in pixels 
	 * @param height
	 *           the desired height of the window in pixels
	 */
	public E7JFrame(String title, int x, int y, int width, int height) {
        
		// The title displayed at the top of the frame (window)
        setTitle(title);
        // We ask the JVM to try and put our window where we ask with the
        // dimensions we want, but there is no guarantee that is possible.
        // For example a small screen device might not allow 640 pixels
        // wide. Or maybe (on Windows 8+) 100px from top would mean it
        // was trying to write over the top of an important Widget
        setBounds(x, y, width, height);
        // Most of the time this is what you want to do
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // We will create one top-level container to hold all of the controls        
        E7ControlsJPanel controlsContent = new E7ControlsJPanel();
        // and a second to be the canvas (we'll override its painting event
        // to draw in our shapes)
        E7CanvasJPanel canvasContent = new E7CanvasJPanel();
        
        // For inter-panel communications a naive approach is to have each
        // panel hold a reference to the other panel.
        controlsContent.registerCanvas(canvasContent);
        canvasContent.registerControls(controlsContent);
        
		// This timer will, once started, trigger an event every 1/10th of a
		// second. When we create a Timer we must register some component as
        // being interested in the timer events. To do so this component must
        // be an ActionListener, and must implement the method
        // actionPerformed()
		Timer movementTimer = new Timer(100, canvasContent);
		// ...and then 'register' this timer with both of the panels
		// The controls need a reference so it can start/stop the timer
		controlsContent.setMovementTimer(movementTimer);
		// Canvas needs a reference so it can test where events came from
		canvasContent.setMovementTimer(movementTimer);
        
		// By default, the container within a JFrame (called as the
		// ContentPane) uses a BorderLayout manager. This means we can align
		// components within to the NORTH, WEST, SOUTH, EAST, or CENTER. The
		// CENTER automatically expands to fill space not already taken by the
		// other regions. So what we'll do is add our canvas to the center (so
		// resizing the screen resizes the canvas) and our controls will have
		// a fixed size on the left (WEST).
		this.getContentPane().add(controlsContent, BorderLayout.WEST);
		this.getContentPane().add(canvasContent, BorderLayout.CENTER);

		// The other option to specifying a total size for the window, is to
		// specify sizes for all the components within, and then let JVM do
		// the layout and figure out how big the frame needs to be to fit. We
		// can trigger this using the pack() method, which you may see in some
		// of the other exercises.
        //this.pack();

		// Put the caret somewhere in the controls panel, just in case the
		// layout/pack moved it somewhere else
        controlsContent.requestFocusInWindow();
    }
	/** E7JFrame(String, int, int, int, int) => E7JFrame **/
}