package ictgradschool.industry.swing.examples.example1;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JPanel that just draws an ellipse taking up its entire area.
 */
public class ExampleOnePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 0;
        int y = 0;
        int width = getWidth();
        int height = getHeight();

        g.drawOval(x, y, width, height);
    }
}
