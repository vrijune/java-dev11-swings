package ictgradschool.industry.swing.ex01;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JFrame that can be initialized to a given size in its constructor, and displays a single {@link ExerciseOnePanel}.
 */
public class ExerciseOneFrame extends JFrame {

    /**
     * Creates a new ExerciseOneFrame
     *
     * @param title the title of the frame
     * @param x the position of the left side of the frame
     * @param y the position of the top of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public ExerciseOneFrame(String title, int x, int y, int width, int height) {
        setTitle(title);
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExerciseOnePanel frameContent = new ExerciseOnePanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
    }

    /**
     * Program entry point.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExerciseOneFrame frame = new ExerciseOneFrame("Exercise One: BMI", 100, 100, 650, 200);
                frame.setVisible(true);
            }
        });
    }

}
