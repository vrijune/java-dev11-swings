package ictgradschool.industry.swing.examples.example7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

/**
 * The JPanel class acting as a 'canvas' for the drawing of shapes. Will
 * demonstrate how to add a mouse listener that knows where a user clicked
 * and how to override the normal JVM driven paint events to draw extra
 * guff (like our squares, diamonds, triangles, and hourglasses)
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 */
public class E7CanvasJPanel extends JPanel implements ActionListener, MouseListener {

	/** All serializable classes must declare and initialize this long */
	private static final long serialVersionUID = 1L;

	/** A list of the shape the user has created */
	private List<E7Shape> shapes;

	/** A reference to the timer object used to trigger shape movements (once
	 * started using the button in the controls panel) */
	private Timer movementTimer;   
	
	/** A reference to the controls panel, so we can retrieve the values the
	 *  user has set for creating new shapes.
	 */
	private E7ControlsJPanel controls;

	/** 
	 * Constructor
	 */
	public E7CanvasJPanel() {
	
		// We'll need to store a growing list of shape objects as one is
		// created each time a user clicks on the canvas
		this.shapes = new ArrayList<E7Shape>();

		// Make it look like a blank canvas
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.BLACK, 2)); // How to add a border!
		
		// Register this component as interested in any mouse clicks on itself
		// This sounds a little weird at first, but does make sense if you
		// think about it, as that way a user can 'click' to make more shapes
		this.addMouseListener(this);
	}
	/** E7CanvasJPanel(void) => E7CanvasJPanel() **/

	
	/** 
	 * Store a reference to the JPanel containing controls for setting the
	 * shape properties.
	 *  
	 * @param controls
	 */
	public void registerControls(E7ControlsJPanel controls) {
		this.controls = controls;	
	}	
	/** registerControls(E7ControlsJPanel) => void **/

	
	/** 
	 * Clear all shapes and redraw canvas
	 */
	public void resetCanvas() {
		this.shapes.clear();
		repaint();
	}
	/** resetCanvas(void) => void **/

	
	/** 
	 * Store a reference to the given timer in this instance
	 * 
	 * @param movementTimer
	 */
	public void setMovementTimer(Timer movementTimer) {
		this.movementTimer = movementTimer;
	}
	/** setMovementTimer(Timer) => void **/
	
	
	/**
	 * Called whenever an event is triggered that this instance is interested
	 * in. In this case that is probably the timer triggering a move... but
	 * we need to test to be sure.
	 * 
	 * @param event
	 */
	public void actionPerformed(ActionEvent event) {
		// Test to see if this event originated in our timer
		if (event.getSource() == this.movementTimer) {
			// Sexy little foreach construct, telling each shape to move but
			// only within the bounds of the canvas (whatever size it may be)
			for (E7Shape shape : this.shapes) {
				shape.move(this.getSize());
			}
			// Having moved them, we now cause the JVM to trigger redrawing
			// them
			repaint();
		}
	}
	/** actionPerformed(ActionEvent) => void **/
	

	@Override
	/** We override this method to not only paint ourselves but each of the
	 *  registered shape polygons as well. FYI, be careful nothing in here
	 *  accidentally calls repaint() or else you'll get to see what painting
	 *  infinity looks like (i.e. your JFrame does that neat 'hall-of-mirrors'
	 *  effect as you drag it around the screen)
	 *  
	 *  @param graphics
	 *            the Graphics object is the context that knows how to
	 *            interact with the computer screen
	 */
	public void paintComponent(Graphics graphics) {
		// This repaints the entire canvas white... wiping out the previously
		// drawn shapes
		super.paintComponent(graphics);
		// Now we ask each of the shapes to draw themselves onto the canvas.
		// Note that I don't have to cast the shapes to their appropriate
		// concrete type because polymorphism will call the appropriate
		// methods automatically
		for (E7Shape shape : this.shapes) {
			shape.draw(graphics);
		}
	}
	/** paintComponent(Graphics) => void **/

	
	/** On each mouse click we create a new shape centered at the mouse
	 *  location and styled using the settings in the controls panel 
	 *  then ask the canvas to redraw
	 *  
	 *  @param event
	 *            a MouseEvent containing information about where the mouse
	 *            was when it was clicked (relative to this component) and
	 *            which button was clicked
	 */
	public void mouseClicked(MouseEvent event) {
		Point center_point = event.getPoint();
		E7Shape newShape;
		// If the following switch looks repetitive, it is. In the future you
		// will learn a Design Pattern called the Factory that does a much
		// better job of this
		switch(this.controls.getSelectedShape()) {
			case Triangle:
			newShape = new E7ShapeTriangle(center_point.x, center_point.y, controls.getSelectedSize());
			break;
		case Diamond:
			newShape = new E7ShapeDiamond(center_point.x, center_point.y, controls.getSelectedSize());
			break;
		case Hourglass:
			newShape = new E7ShapeHourglass(center_point.x, center_point.y, controls.getSelectedSize());
			break;
            case Square:
		default: // Everything else is squares
			newShape = new E7ShapeSquare(center_point.x, center_point.y, controls.getSelectedSize());
		}
		this.shapes.add(newShape);
		this.repaint();
	}
	/** mouseEntered(MouseEvent) => void **/
	
	
	// The methods below must be implemented due to the 'implements
	// MouseListener' above but we don't need to do anything in them

	
	/** Implemented but not required */
	public void mouseEntered(MouseEvent event) {}
	/** mouseEntered(MouseEvent) => void **/

	
	/** Implemented but not required */	
	public void mouseExited(MouseEvent e) {}
	/** mouseExited(MouseEvent) => void **/	

	
	/** Implemented but not required */		
	public void mousePressed(MouseEvent e) {}
	/** mousePressed(MouseEvent) => void **/
	

	/** Implemented but not required */		
	public void mouseReleased(MouseEvent e) {}
	/** mouseReleased(MouseEvent) => void **/
}
