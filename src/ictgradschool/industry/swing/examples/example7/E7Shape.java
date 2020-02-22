package ictgradschool.industry.swing.examples.example7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 * An abstract class representing a Shape
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 *
 */
public abstract class E7Shape {

	// Default size (before multiplier)
	protected static final int DIM = 10;

	/** The x coordinate of the center point of the shape */
	protected int x;
	/** The y coordinate of the center point of the shape */
	protected int y;
	/** The size scale factor of the shape */
	protected int size;
	/** The 'speed' of movement given in pixels */
	private int speed;
	/** The random colour of the shape (not too light) */
	private Color colour;


	/**
	 * Constructor
	 * 
	 * @param x
	 *           the horizontal pixel position of the center as an int
	 * @param y
	 *           the vertical pixel position of the center as an int
	 * @param size
	 *           a scaling factor as an int
	 */
	public E7Shape(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		// The speed of movement is random for each new shape...
		this.speed = (int) (Math.random() * 10 + 1);
		// ...as is colour
		int red = (int) (Math.random() * 256);
		int green = (int) (Math.random() * 256);
		int blue = (int) (Math.random() * 256);
		// Can't see almost white shapes on background... paint it black
		if (red + green + blue > 700) {
			red = 0;
			green = 0;
			blue = 0;
		}
		this.colour = new Color(red, green, blue);
	}
	/** E7Shape(int, int) => E7Shape **/

	
	/**
	 * Draw the shape. The graphics context is the object that is used to
	 * draw things to the user's screen, and comes with a plethora of methods
	 * for drawing shapes and text and filling them in. Conceptually, the
	 * context has a current 'pen', with a defined colour and thickness and
	 * opacity and all those other good artsy terms, that you then perform
	 * some sort of drawing action with (draw a point, draw a line, draw a
	 * circle etc). This lies behind all of the GUI stuff in java (and indeed
	 * Windows itself really).
	 * 
	 * @param graphicsContext
	 *           the Graphics object used for painting to the screen
	 */
	public void draw(Graphics graphicsContext) {
		// Retrieve the shape specific points, stored in a polygon container
		// for ease of use
		Polygon points = getPoints();
		// Fill in the shape first
		graphicsContext.setColor(colour);
		graphicsContext.fillPolygon(points);
		// Then draw a crisp black border around it
		graphicsContext.setColor(Color.BLACK);
		graphicsContext.drawPolygon(points);
	}
	/** draw(Graphics) => void **/	


	/**
	 * Move the face in the current direction
	 * 
	 * @param canvasSize
	 *           a Dimension used to bound the area in which shapes move
	 */
	public void move(Dimension canvasSize) {
		// 1. Pick a random direction
		E7Direction direction = E7Direction.values()[(int)(Math.random() * E7Direction.values().length)];

		// 2. Then apply the 'speed' to that 'direction'
		switch (direction) {
			case Up:
				y -= speed;
				break;
			case Down:
				y += speed;
				break;
			case Left:
				x -= speed;
				break;
			case Right:
				x += speed;
				break;
		}

		// 3. If our center is now out of the bounds of the canvas, teleport
		// back to the middle
		if (0 > x || 0 > y || x > canvasSize.getWidth() || y > canvasSize.getHeight()) {
			x = (int) (canvasSize.getWidth() / 2);
			y = (int) (canvasSize.getHeight() / 2);
		}
	}
	/** move(void) => void **/

	
	/* ************************ ABSTRACT METHODS ************************** */

	
	/**
	 * We need to calculate the points for each type of shape based upon the x
	 * and y (as they may occasionally change via the move() method) and size
	 * scale
	 * 
	 * @return a Polygon containing the list of points for the shape
	 */
	public abstract Polygon getPoints();
	/** getPoints(void) => Polygon **/
}
