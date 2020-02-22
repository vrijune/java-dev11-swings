package ictgradschool.industry.swing.examples.example1;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JFrame that can be initialized to a given size in its constructor, and displays a single {@link ExampleOnePanel}.
 */
public class ExampleOneFrame extends JFrame {

    /**
     * Creates a new ExampleTwoFrame
     *
     * @param title the title of the frame
     * @param x the position of the left side of the frame
     * @param y the position of the top of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public ExampleOneFrame(String title, int x, int y, int width, int height) {
        setTitle(title);
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ExampleOnePanel frameContent = new ExampleOnePanel();
        Container visibleArea = getContentPane();
        visibleArea.add(frameContent);
        frameContent.setPreferredSize(new Dimension(width, height));
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
                ExampleOneFrame frame = new ExampleOneFrame("Example One: A basic panel", 100, 100, 400, 400);
                frame.setVisible(true);
            }
        });
    }

}
