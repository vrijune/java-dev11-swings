package ictgradschool.industry.swing.examples.example7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * A container to hold all of the various controls for configuring shape
 * properties, plus some instructions. This will demonstrate how you can read
 * and write from JTextFields, get click events from buttons and figure out
 * which button was clicked and a start and stop timers. Plus the general
 * stuff like adding components into containers of varying layout.
 * 
 * @author John Thompson, UoW, PGCInfoTech
 *
 */
public class E7ControlsJPanel extends JPanel implements ActionListener {

	/** Version number all serializable objects need */
	private static final long serialVersionUID = 1L;

	// We need to declare JTextField and JButton instance variables here, at
	// the instance-level scope, so they can be seen within the constructor
	// and in any other methods in this class where they will interacted with
	// (for example, in button click event handler).
	/** A field for capturing the selected shape; this could be any text but
	 * only Square, Diamond, Triangle, and Hourglass are valid */
    JTextField shapeField;
    /** A field for capturing the selected scale factor [1-9] */
    JTextField sizeField;
    /** Click this button to clear all shapes and reset the canvas */
    JButton clearButton;
    /** Click this button to start the shapes moving, or stop them if they are
     * already moving */
    JButton moveButton;
    /** Click this button to cycle forwards through the valid shapes */
    JButton nextShapeButton;
    /** Click this button to cycle backwards through the valid shapes */
    JButton prevShapeButton;

    /** A reference to the canvas so we can ask to clear it */
    private E7CanvasJPanel canvas;
    
	/** A reference to the timer used to trigger shape movements (once enabled) */
	private Timer movementTimer;    

	/** Keeps track of the index into the E7ShapeType enum (i.e. what shape we'll create next). */
	private int currentShapeIndex = 0;
	
	/**
	 * Constructor; this panel will hold a number of controls for configuring
	 * the shapes produced on the canvas
	 */
    public E7ControlsJPanel() {
    	// nice and neutral
        this.setBackground(Color.LIGHT_GRAY);
        // there will be a 'header' and controls to the NORTH then some
        // instructions in the CENTER (which will expand vertically to fill
        // the available space) - so we'll use a border layout
        this.setLayout(new BorderLayout());
        // Nest a container to hold all the components for the 'north' part
        // of the controls
        JPanel headerPanel = new JPanel();
        // A BoxLayout allows us to 'stack' components vertically (as compared
        // to the default FlowLayouts horizontal layout) but is a little
        // different to other layout managers in that it needs a reference to
        // the container (JPanel in this case) it will be laying out
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        // 1. Header Text - set the 'gravity' of the label to center, so
        //    BoxLayout lines up centers properly
        JLabel controlHeader = new JLabel("CONFIGURE SHAPES", JLabel.LEFT);
        controlHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
        headerPanel.add(controlHeader);
        // 2. The controls all nicely laid out in a grid two columns wide by
        //    4 rows tall
        JPanel gridPanel = new JPanel(new GridLayout(4, 2));
        JLabel shapeLabel = new JLabel("Shape to draw:"); // label
        gridPanel.add(shapeLabel);
        this.shapeField = new JTextField(E7ShapeType.values()[this.currentShapeIndex].toString()); // control
        gridPanel.add(this.shapeField);
        this.prevShapeButton = new JButton("Prev"); // button
        this.prevShapeButton.addActionListener(this);
        gridPanel.add(this.prevShapeButton);
        this.nextShapeButton = new JButton("Next"); // button
        this.nextShapeButton.addActionListener(this);
        gridPanel.add(this.nextShapeButton);
        JLabel sizeLabel = new JLabel("Shape scale [1-9]:"); // label
        gridPanel.add(sizeLabel);
        this.sizeField = new JTextField("1"); // control
        gridPanel.add(this.sizeField);
        this.moveButton = new JButton("Start"); // button
        this.moveButton.addActionListener(this);
        gridPanel.add(this.moveButton);
        this.clearButton = new JButton("Reset"); // button
        this.clearButton.addActionListener(this);
        gridPanel.add(this.clearButton);        
        headerPanel.add(gridPanel);
        this.add(headerPanel, BorderLayout.NORTH); // add to top jpanel
        // 3. Instructions - there are a bunch of things here you don't need
        //    to worry about too much. There are a couple of configurations
        //    regarding word wrapping specific to JTextAreas. I then do a
        //    couple of changes to make it look less like a control that I
        //    want a user to write into (editable=false, opaque=false).
        JTextArea instructionsLabel = new JTextArea("Click on canvas to add shapes.  " +
        "Shapes have random colour and movement speed.  " + 
        "Type in a shape name or click \"next\" and \"prev\" button to select shape type - unrecognized shapes will assumed to be squares.  " +
        "Enter a scale factor (1 to 9) to alter shape size - non-numeric values will be ignored.  " +
        "Click \"Start\" to move the shapes randomly and \"Stop\" to stop them moving.  " +
        "Finally, click \"Reset\" to clear the canvas.");
        instructionsLabel.setMargin(new Insets(10, 10, 0, 10));
        instructionsLabel.setColumns(20);
        instructionsLabel.setOpaque(false);
        instructionsLabel.setEditable(false);
        instructionsLabel.setLineWrap(true);
        instructionsLabel.setWrapStyleWord(true);
        this.add(instructionsLabel, BorderLayout.CENTER); // add to top jpanel
    }
    /** E7ControlsJPanel(void) => E7ControlsJPanel **/

    
	/** Store a reference to the given timer in this instance
	 * 
	 * @param movementTimer
	 */
	public void setMovementTimer(Timer movementTimer) {
		this.movementTimer = movementTimer;
	}
	/** setMovementTimer(Timer) => void **/

	
	/** Store a reference to the canvas, so we can interact with it
	 * 
	 * @param canvas
	 */
	public void registerCanvas(E7CanvasJPanel canvas) {
		this.canvas = canvas;
	} 
	/** registerCanvas(E7CanvasJPanel) => void **/
    
    
	/**
	 * ActionListeners need to implement this methods 'called back' whenever
	 * a button is clicked (or some other 'action event' thrown). In our
	 * example this is almost certainly one of our buttons being clicked, but
	 * will still can't be sure. It is safest (and best practice) to test for
	 * which button was the source of the event, and this also happens to
	 * line up well with doing different things depending on which button it
	 * was.
	 * 
	 * @param event
	 *           an ActionEvent containing information about the action that
	 *           triggered the event
	 */
    public void actionPerformed(ActionEvent event) {
        // Ascertain which button the user has pressed
    	Object eventSource = event.getSource();
    	// You may be surprised by the use of double equals (equality) in the
    	// following conditional, as all the way through I've warned you that
    	// it was *probably* not what you wanted to do. Remember that
    	// references to class instances (objects) are actually integer
    	// numbers pointing off into memory. So in this case what we really
    	// want to do is see if the reference from the event (an int) is the
    	// same value as our reference to a certain button (also an int). If
    	// the ints are the same, they are pointing at the same object. Yay!
    	
    	// Handle clicks on the "next" button...
        if (eventSource == this.nextShapeButton) {

            this.currentShapeIndex = (this.currentShapeIndex + 1) % E7ShapeType.values().length;
            this.shapeField.setText(E7ShapeType.values()[this.currentShapeIndex].toString());
        }
        // ...and the "prev" one
        else if (eventSource == this.prevShapeButton) {

            this.currentShapeIndex = (this.currentShapeIndex - 1 + E7ShapeType.values().length) % E7ShapeType.values().length;
            this.shapeField.setText(E7ShapeType.values()[this.currentShapeIndex].toString());

        }
        // Deal with clicks on the start/stop toggle button
        else if (eventSource == this.moveButton) {
        	if (this.movementTimer.isRunning()) {
        		this.moveButton.setText("Start");
        		this.movementTimer.stop();
        	}
        	else {
        		this.moveButton.setText("Stop");
        		this.movementTimer.start();
        	}
        }
        // And finally, clicks on the "reset" button
        else if (eventSource == this.clearButton) {
        	this.canvas.resetCanvas();
        }
    }
    /** actionPerformed(ActionEvent) => void **/
    

    /** Retrieve the integer that represents the currently entered shape (or
     *  SQUARE if the field's content isn't recognized).
     *  
     * @return an int representing the E7Shape to create
     */
	public E7ShapeType getSelectedShape() {
		// Get whatever text is in the field, with the first character uppercase
        // then the rest lowercase.
		String shapeName = shapeField.getText().toLowerCase();
		shapeName = shapeName.toUpperCase().charAt(0) + shapeName.substring(1);

        try {
            // Test for the kinds of shapes we recognize
            return E7ShapeType.valueOf(shapeName);

        } catch (IllegalArgumentException e) {

            // If the user typed rubbish, default to s square.
            return E7ShapeType.Square;
        }
	}
	/** getSelectedShape(void) => int **/


	/**
	 * Try to parse out the scale factor from whatever text is in the matching
	 * field. On error, scale is assumed to be 1.
	 * 
	 * @return the scale factor as an int
	 */
	public int getSelectedSize() {
		int size = 1;
		String sizeStr = this.sizeField.getText();
		// Simple little try-catch, and we know exactly how to recover from any error
		try {
			size = Integer.parseInt(sizeStr);
			if (1 > size || 9 < size) {
				size = 1;
			}
		}
		catch (NumberFormatException nfe) {
			System.err.println(nfe.toString());
			
		}
		// Update size field with whatever scale we are about to use.
		// setText() only takes Strings, so we use the Integer library to
		// convert the int to String
		this.sizeField.setText(Integer.toString(size));
		// all done!
		return size;
	}
	/** getSelectedSize(void) => int **/
}