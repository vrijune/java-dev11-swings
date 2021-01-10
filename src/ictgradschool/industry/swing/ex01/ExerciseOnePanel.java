package ictgradschool.industry.swing.ex01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple GUI app that does BMI calculations.
 */
public class ExerciseOnePanel extends JPanel implements ActionListener {

    // TODO Declare JTextFields and JButtons as instance variables here.
    private JButton calculateBMIButton;
    private JButton calculateHealthyWeightButton;
    private JTextField calculateBMITextF;
    private JTextField calculateHealthyWeightTextF;
    private JTextField heightTextF;
    private JTextField wrightTextF;

    /**
     * Creates a new ExerciseOnePanel.
     */
    public ExerciseOnePanel() {
        setBackground(Color.white);

        // TODO Construct JTextFields and JButtons.
        // HINT: Declare them as instance variables so that other methods in this class (e.g. actionPerformed) can
        // also access them.
        calculateBMIButton = new JButton("calculateBMI");
        calculateHealthyWeightButton = new JButton("calculateHealthyWeight");

        calculateBMITextF = new JTextField(20);
        calculateHealthyWeightTextF = new JTextField(20);
        heightTextF = new JTextField(20);
        wrightTextF = new JTextField(20);


        // TODO Declare and construct JLabels
        // Note: These ones don't need to be accessed anywhere else so it makes sense just to declare them here as
        // local variables, rather than instance variables.
        JLabel label1 = new JLabel("Height in metres:");
        JLabel label2 = new JLabel("Weight in kilograms:");
        JLabel label3 = new JLabel("Your Body Mass Index (BMI) is:");
        JLabel label4 = new JLabel("Maximum Healthy Weight for your Height:");


        // TODO Add JLabels, JTextFields and JButtons to window.
        // Note: The default layout manager, FlowLayout, will be fine (but feel free to experiment with others if you want!!)
        add(label1);
        add(heightTextF);
        add(label2);
        add(wrightTextF);

        add(calculateBMIButton);
        add(label3);
        add(calculateBMITextF);

        add(calculateHealthyWeightButton);
        add(label4);
        add(calculateHealthyWeightTextF);


        // TODO Add Action Listeners for the JButtons
        calculateBMIButton.addActionListener(this);
        calculateHealthyWeightButton.addActionListener(this);
    }


    /**
     * When a button is clicked, this method should detect which button was clicked, and display either the BMI or the
     * maximum healthy weight, depending on which JButton was pressed.
     */
    public void actionPerformed(ActionEvent event) {

        // TODO Implement this method.
        // Hint #1: event.getSource() will return the button which was pressed.
        // Hint #2: JTextField's getText() method will get the value in the text box, as a String.
        // Hint #3: JTextField's setText() method will allow you to pass it a String, which will be diaplayed in the text box.

        double height = Double.parseDouble(heightTextF.getText());
        double weight = Double.parseDouble(wrightTextF.getText());
        double BMI = weight / (height * height);
        double MaxHealthyWeight = 24.9 * height * height;


        if (event.getSource() == calculateBMIButton) {
            calculateBMITextF.setText("" + roundTo2DecimalPlaces(BMI));
        } else if (event.getSource() == calculateHealthyWeightButton) {
            calculateHealthyWeightTextF.setText("" + roundTo2DecimalPlaces(MaxHealthyWeight));
        }


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