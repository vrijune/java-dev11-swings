package ictgradschool.industry.swing.examples.example7;

import java.awt.Polygon;

/**
 * Draws a Square; a concrete implementation of a E7Shape
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 *
 */
public class E7ShapeSquare extends E7Shape {

	/**
	 * Constructor - sigh. So, you should all know what a default constructor
	 * look like by now, i.e. if I had no constructor for this class I could
	 * call "E7ShapeSquare()" and Java would have added that for me. However
	 * with inheritance being used (extends) that would then try to call the
	 * default constructor on the superclass, i.e. "E7Shape()" - and there is
	 * no such method.  Instead, you end up having to write a constructor like
	 * this, that does nothing except call the superclasses constructor with
	 * the appropriate arguments. There are plenty of complaints about this.
	 * 
	 * @param x
	 *           the horizontal pixel position of the center as an int
	 * @param y
	 *           the vertical pixel position of the center as an int
	 * @param size
	 *           a scaling factor as an int
	 */
	public E7ShapeSquare(int x, int y, int size) {
		super(x, y, size);
	}
	/** E7ShapeSquare(int, int, int) => E7ShapeSquare **/


	/**
	 * Perform the maths to figure out where the current corners of this shape
	 * are (changes over time due to x and y changing, and is influenced by
	 * the scale factor), and then produce a list of these points.
	 * 
	 * In this case a Square, unsurprisingly, has four corners.
	 * 
	 * @return the points for this shape in a Polygon container	
	 */
	public Polygon getPoints() {
		// A polygon provides a convenient container for points, as the
		// graphics context knows how to process polygons		
		Polygon points = new Polygon();
		// Not really a radius, but this is as good a name as any
		int radius = this.size * (DIM / 2);
		// Calculating the points in a square is straightforward. Just watch
		// the order or you'll generate an hourglass!
		points.addPoint(this.x - radius, this.y - radius); // top left
		points.addPoint(this.x + radius, this.y - radius); // top right
		points.addPoint(this.x + radius, this.y + radius); // bottom right
		points.addPoint(this.x - radius, this.y + radius); // bottom left
		return points;
	}
	/** getPoints(void) => Polygon **/
}
