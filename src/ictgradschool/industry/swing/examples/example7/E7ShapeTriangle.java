package ictgradschool.industry.swing.examples.example7;

import java.awt.Polygon;

/**
 * Draws a Triangle; a concrete implementation of a E7Shape
 * 
 * @see example.Ex0ShapeSquare
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 *
 */
public class E7ShapeTriangle extends E7Shape {

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
	public E7ShapeTriangle(int x, int y, int size) {
		super(x, y, size);
	}
	/** E7ShapeTriangle(int, int, int) => E7ShapeTriangle **/

	/**
	 * In this case an equilateral Triangle has three corners and some
	 * squiggly maths to figure out where they lie (who knew there was
	 * such a thing as an apothem).
	 * 
	 * @return the points for this shape in a Polygon container	
	 */
	public Polygon getPoints() {
		Polygon points = new Polygon();
		int radius = this.size * (DIM / 2);
		// The height of the equilateral triangle of side length DIM, is
		// effectively the length of the 'opposite' side of the pythagorean
		// formula where the hypotenuse is DIM length and the adjacent is
		// half DIM length
		int height = this.size * (int)Math.sqrt(Math.pow(DIM, 2) - Math.pow((DIM / 2), 2));
		// Assuming a vertical bisector of the equilateral triangle, then the
		// apothem tells you where the center point of the triangle is (lies
		// on that vertical bisector) - so that is where our x and y is! From
		// there we can work out the maths to the three corners
		int apothem = this.size * (int)(DIM / (2 * Math.sqrt(3)));
		points.addPoint(this.x, this.y - (height - apothem)); // top
		points.addPoint(this.x - radius, this.y + apothem); // bottom left
		points.addPoint(this.x + radius, this.y + apothem); // bottom right		
		return points;
	}
	/** getPoints(void) => Polygon **/

}
