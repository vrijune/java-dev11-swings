package ictgradschool.industry.swing.ex05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

/**
 * Allows the user to draw rectangles on the screen.
 */
public class ExerciseFivePanel extends JPanel implements MouseListener, MouseMotionListener {

    /** A list of all shapes the user has drawn */
    private List<Rectangle> shapes = new ArrayList<>();

    /** The location where the user pressed their mouse, if any */
    private Point mouseDownPoint1 = null;

    /** The current location of the user's pressed mouse, if any */
    private Point mouseDownPoint2 = null;


    /**
     * Creates a new ExerciseFivePanel.
     */
    public ExerciseFivePanel() {
        setBackground(Color.white);

        // TODO Add this panel as a mouse listener and mouse motion listener to itself.
    }

    /**
     * TODO When the user presses their mouse down on the panel, record the location of that mouse press.
     * TODO Then, repaint the screen.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * TODO When the user releases their mouse down on the panel, record the location of that mouse release.
     * TODO Then, call the createRectangle method appropriately to create a Rectangle, and add it to the shapes list.
     * TODO Then, repaint the screen.
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * TODO When the user drags the mouse (moves it while it's pressed), record the current location of that mouse drag,
     * TODO and repaint the screen.
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    /**
     * Draws any shapes we have inside this panel, in the shapes ArrayList. Also will draw a Rectangle in red,
     * showing the rectangle we're currently drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw everything in the shapes list
        for(Rectangle r : shapes) {
            r.draw(g);
        }

        // TODO If we're currently dragging out a new rectangle, draw its current size in red.
        // Hint: You can just use the createRectangle method, and draw the rectangle that you get back from it.

    }

    /**
     * Creates a {@link Rectangle}, given the two points. This method is smart enough to deal with any two valid points,
     * regardless of where one is in relation to the other.
     *
     * @param p1 the first point
     * @param p2 the second point
     * @param color the color
     * @return a {@link Rectangle}
     */
    private Rectangle createRectangle(Point p1, Point p2, Color color) {
        int x1 = (int) p1.getX();
        int y1 = (int) p1.getY();
        int x2 = (int) p2.getX();
        int y2 = (int) p2.getY();

        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.max(x1, x2) - Math.min(x1, x2);
        int height = Math.max(y1, y2) - Math.min(y1, y2);

        return new Rectangle(x, y, width, height, color);
    }

    /** Unused but required by MouseListener interface. */
    @Override
    public void mouseEntered(MouseEvent e) { }

    /** Unused but required by MouseListener interface. */
    @Override
    public void mouseExited(MouseEvent e) { }

    /** Unused but required by MouseListener interface. */
    @Override
    public void mouseClicked(MouseEvent e) { }

    /** Unused but required by MouseMotionListener interface. */
    @Override
    public void mouseMoved(MouseEvent e) { }
}