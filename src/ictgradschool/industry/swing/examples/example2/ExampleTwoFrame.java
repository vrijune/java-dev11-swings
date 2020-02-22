package ictgradschool.industry.swing.examples.example2;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JFrame that can be initialized to a given size in its constructor, and displays a single {@link ExampleTwoPanel}.
 */
public class ExampleTwoFrame extends JFrame {

    /**
     * Creates a new ExampleTwoFrame
     *
     * @param title the title of the frame
     * @param x the position of the left side of the frame
     * @param y the position of the top of the frame
     */
    public ExampleTwoFrame(String title, int x, int y) {
        setTitle(title);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExampleTwoPanel frameContent = new ExampleTwoPanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
        pack();
        frameContent.requestFocusInWindow();
    }

    /**
     * Program entry point.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExampleTwoFrame frame = new ExampleTwoFrame("Example Two: Some simple widgets", 100, 100);
                frame.setVisible(true);
            }
        });
    }

}
