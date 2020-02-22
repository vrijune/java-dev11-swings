package ictgradschool.industry.swing.ex02;

import javax.swing.*;
import java.awt.*;

/**
 * A simple JPanel that allows users to add or subtract numbers.
 *
 * TODO Complete this class. No hints this time :)
 */
public class ExerciseTwoPanel extends JPanel {

    /**
     * Creates a new ExerciseFivePanel.
     */
    public ExerciseTwoPanel() {
        setBackground(Color.white);

    }

    /**
     * A library method that rounds a double to 2dp
     *
     * @param amount to round as a double
     * @return the amount rounded to 2dp
     */
    private double roundTo2DecimalPlaces(double amount) {
        return ((double) Math.round(amount * 100)) / 100;
    }

}