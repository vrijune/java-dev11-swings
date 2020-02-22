package ictgradschool.industry.swing.examples.example7;

import java.awt.Polygon;

/**
 * Draws an Hourglass; a concrete implementation of a E7Shape
 * 
 * @see example.Ex0ShapeSquare
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 *
 */
public class E7ShapeHourglass extends E7Shape {

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
	public E7ShapeHourglass(int x, int y, int size) {
		super(x, y, size);
	}
	/** E7ShapeHourglass(int, int, int) => E7ShapeHourglass **/


	/**
	 * I'd like to say I designed the Hourglass shape on purpose but actually 
	 * I screwed up the order of points on a Square, got this shape, and
	 * thought "close enough, that's a shape too".
	 * 
	 * @return the points for this shape in a Polygon container	
	 */
	public Polygon getPoints() {
		Polygon points = new Polygon();
		int radius = this.size * (DIM / 2);
		// Like a square but in the wrong order...
		points.addPoint(this.x - radius, this.y - radius); // top left
		points.addPoint(this.x + radius, this.y - radius); // top right
		points.addPoint(this.x - radius, this.y + radius); // bottom left
		points.addPoint(this.x + radius, this.y + radius); // bottom right		
		return points;
	}
	/** getPoints(void) => Polygon **/
}
