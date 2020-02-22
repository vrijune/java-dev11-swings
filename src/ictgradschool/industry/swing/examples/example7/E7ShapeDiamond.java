package ictgradschool.industry.swing.examples.example7;

import java.awt.Polygon;

/**
 * Draws a Diamond; a concrete implementation of a E7Shape
 * 
 * @see example.Ex0ShapeSquare
 * 
 * @author  John Thompson, UoW, PGCInfoTech
 *
 */
public class E7ShapeDiamond extends E7Shape {

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
	public E7ShapeDiamond(int x, int y, int size) {
		super(x, y, size);
	}
	/** E7ShapeDiamond(int, int, int) => E7ShapeDiamond **/
	

	/**
	 * In this case a Diamond has four corners and is basically a Square
	 * rotated 45 degrees.
	 * 
	 * @return the points for this shape in a Polygon container	
	 */
	public Polygon getPoints() {
		Polygon points = new Polygon();
		// Each side of the diamond needs to be DIM pixels long, so there
		// is more maths this time, involving triangles and that Pythagoras
		// dude... 
		int radius = this.size * (DIM / 2);
		int hypotenuse = (int)Math.hypot(radius, radius);
		// Four points where order is important - screwing up here does
		// not produce a shape of any sort...
		points.addPoint(this.x, this.y - hypotenuse); // top
		points.addPoint(this.x - hypotenuse, this.y); // left
		points.addPoint(this.x, this.y + hypotenuse); // bottom		
		points.addPoint(this.x + hypotenuse, this.y); // right
		return points;
	}
	/** getPoints(void) => Polygon **/

}
