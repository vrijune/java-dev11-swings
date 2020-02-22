package ictgradschool.industry.swing.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Displays an animated balloon.
 */
public class ExerciseFourPanel extends JPanel implements ActionListener {

    private  Balloon balloon;
    private  JButton moveButton;

    /**
     * Creates a new ExerciseFourPanel.
     */
    public ExerciseFourPanel() {
        setBackground(Color.white);

        this.balloon = new Balloon(30, 60);

        this.moveButton = new JButton("Move balloon");
        this.moveButton.addActionListener(this);
        this.add(moveButton);

    }

    /**
     * Moves the balloon and calls repaint() to tell Swing we need to redraw ourselves.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        balloon.move();

        // Sets focus to the panel itself, rather than the JButton. This way, the panel can continue to generate key
        // events even after we've clicked the button.
        requestFocusInWindow();

        repaint();
    }

    /**
     * Draws any balloons we have inside this panel.
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        balloon.draw(g);
        
        // Sets focus outside of actionPerformed so key presses work without pressing the button
        requestFocusInWindow();
    }
}