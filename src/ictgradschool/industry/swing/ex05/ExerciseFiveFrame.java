package ictgradschool.industry.swing.ex05;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JFrame that can be initialized to a given size in its constructor, and displays a single {@link ExerciseFivePanel}.
 */
public class ExerciseFiveFrame extends JFrame {

    /**
     * Creates a new ExerciseFiveFrame
     *
     * @param title the title of the frame
     * @param x the position of the left side of the frame
     * @param y the position of the top of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public ExerciseFiveFrame(String title, int x, int y, int width, int height) {
        setTitle(title);
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExerciseFivePanel frameContent = new ExerciseFivePanel();
        frameContent.setPreferredSize(new Dimension(width, height));
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
        pack();
    }

    /**
     * Program entry point.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExerciseFiveFrame frame = new ExerciseFiveFrame("Exercise Five: Shape Drawing App", 100, 100, 800, 800);
                frame.setVisible(true);
            }
        });
    }

}
