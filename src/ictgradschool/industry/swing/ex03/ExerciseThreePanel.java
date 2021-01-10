package ictgradschool.industry.swing.ex03;

import javax.swing.*;
import java.awt.*;

/**
 * A JPanel that draws some houses using a Graphics object.
 * <p>
 * TODO Complete this class. No hints this time :)
 */
public class ExerciseThreePanel extends JPanel {

    /**
     * All outlines should be drawn this color.
     */
    private static final Color OUTLINE_COLOR = Color.black;

    /**
     * The main "square" of the house should be drawn this color.
     */
    private static final Color MAIN_COLOR = new Color(255, 229, 204);

    /**
     * The door should be drawn this color.
     */
    private static final Color DOOR_COLOR = new Color(150, 70, 20);

    /**
     * The windows should be drawn this color.
     */
    private static final Color WINDOW_COLOR = new Color(255, 255, 153);

    /**
     * The roof should be drawn this color.
     */
    private static final Color ROOF_COLOR = new Color(255, 153, 51);

    /**
     * The chimney should be drawn this color.
     */
    private static final Color CHIMNEY_COLOR = new Color(153, 0, 0);

    /**
     * Creates a new ExerciseFourPanel.
     */
    public ExerciseThreePanel() {
        setBackground(Color.white);
    }

    /**
     * Draws eight houses, using the method that you implement for this exercise.
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawHouse(g, 125, 177, 3);
        drawHouse(g, 199, 193, 7);
        drawHouse(g, 292, 55, 5);
        drawHouse(g, 29, 110, 8);
        drawHouse(g, 379, 386, 7);
        drawHouse(g, 127, 350, 12);
        drawHouse(g, 289, 28, 2);
        drawHouse(g, 300, 150, 16);
    }

    /**
     * Draws a single house, with its top-left at the given coordinates, and with the given size multiplier.
     *
     * @param g    the {@link Graphics} object to use for drawing
     * @param left the x coordinate of the house's left side
     * @param top  the y coordinate of the top of the house's roof
     * @param size the size multipler. If 1, the house should be drawn as shown in the grid in the lab handout.
     */
    private void drawHouse(Graphics g, int left, int top, int size) {

//        body
        g.setColor(MAIN_COLOR);
        g.fillRect(left, top + 5 * size, 10 * size, 7 * size);
        g.setColor(OUTLINE_COLOR);
        g.drawRect(left, top + 5 * size, 10 * size, 7 * size);


//        CHIMNEY
        g.setColor(CHIMNEY_COLOR);
        g.fillRect(left + 7 * size, top + size, size, 2 * size);
        g.setColor(OUTLINE_COLOR);
        g.drawRect(left + 7 * size, top + size, size, 2 * size);


//        Roof
        Polygon roof = new Polygon();
        roof.addPoint(left, top + 5 * size);
        roof.addPoint(left + 5 * size, top);
        roof.addPoint(left + 10 * size, top + 5 * size);
        g.setColor(ROOF_COLOR);
        g.fillPolygon(roof);
        g.setColor(OUTLINE_COLOR);
        g.drawPolygon(roof);

//        door
        g.setColor(DOOR_COLOR);
        g.fillRect(left + 4 * size, top + 8 * size, 2 * size, 4 * size);
        g.setColor(OUTLINE_COLOR);
        g.drawRect(left + 4 * size, top + 8 * size, 2 * size, 4 * size);

//        leftWindow
        g.setColor(WINDOW_COLOR);
        g.fillRect(left + size, top + 7 * size, 2 * size, 2 * size);
        g.setColor(OUTLINE_COLOR);
        g.drawRect(left + size, top + 7 * size, 2 * size, 2 * size);

//        RightWindow
        g.setColor(WINDOW_COLOR);
        g.fillRect(left + 7 * size, top + 7 * size, 2 * size, 2 * size);
        g.setColor(OUTLINE_COLOR);
        g.drawRect(left + 7 * size, top + 7 * size, 2 * size, 2 * size);

//        leftCross
        g.drawLine(left + size, top + 8 * size, left + 3 * size, top + 8 * size);
        g.drawLine(left + 2 * size, top + 7 * size, left + 2 * size, top + 9 * size);

//        RightCross
        g.drawLine(left + 7 * size, top + 8 * size, left + 9 * size, top + 8 * size);
        g.drawLine(left + 8 * size, top + 7 * size, left + 8 * size, top + 9 * size);
        // TODO Draw a house, as shown in the lab handout.
    }
}