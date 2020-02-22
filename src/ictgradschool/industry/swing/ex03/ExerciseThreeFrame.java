package ictgradschool.industry.swing.ex03;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JFrame that can be initialized to a given size in its constructor, and displays a single {@link ExerciseThreePanel}.
 */
public class ExerciseThreeFrame extends JFrame {

    /**
     * Creates a new ExerciseThreeFrame
     *
     * @param title the title of the frame
     * @param x the position of the left side of the frame
     * @param y the position of the top of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public ExerciseThreeFrame(String title, int x, int y, int width, int height) {
        setTitle(title);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExerciseThreePanel frameContent = new ExerciseThreePanel();
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
                ExerciseThreeFrame frame = new ExerciseThreeFrame("Exercise Three: Houses", 100, 100, 500, 500);
                frame.setVisible(true);
            }
        });
    }

}
