package ictgradschool.industry.swing.examples.example2;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JPanel that just draws an ellipse taking up its entire area.
 */
public class ExampleTwoPanel extends JPanel {

    /**
     * Creates a new ExampleTwoPanel, which contains a bunch of basic Swing widgets.
     */
    public ExampleTwoPanel() {

        // Make the components be laid out vertically.
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);

        this.add(Box.createVerticalStrut(10));

        JButton button = new JButton("Click me!");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(button);

        this.add(Box.createVerticalStrut(10));

        JCheckBox checkbox = new JCheckBox("Check me!");
        checkbox.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(checkbox);

        this.add(Box.createVerticalStrut(10));

        JLabel label = new JLabel("A label");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(label);

        this.add(Box.createVerticalStrut(10));

        JTextField textField = new JTextField(30);
        this.add(textField);

        this.add(Box.createVerticalStrut(10));

        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(100, 50));
        this.add(textArea);

        this.add(Box.createVerticalStrut(10));

    }
}
