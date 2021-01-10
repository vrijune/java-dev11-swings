package ictgradschool.industry.swing.ex02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple JPanel that allows users to add or subtract numbers.
 * <p>
 * TODO Complete this class. No hints this time :)
 */
public class ExerciseTwoPanel extends JPanel implements ActionListener {
    private JButton Add, Subtract;
    private JTextField Text1, Text2, ResultTextF;

    /**
     * Creates a new ExerciseFivePanel.
     */
    public ExerciseTwoPanel() {
        setBackground(Color.white);


        Add = new JButton("Add");
        Subtract = new JButton("Subtract");

        Text1 = new JTextField(10);
        Text2 = new JTextField(10);
        ResultTextF = new JTextField(20);

        JLabel label1 = new JLabel("Result:");


        add(Text1);
        add(Text2);
        add(Add);
        add(Subtract);
        add(label1);
        add(ResultTextF);

Add.addActionListener(this);
Subtract.addActionListener(this);

    }

    public void actionPerformed(ActionEvent event) {
        double FirstNumber = Double.parseDouble(Text1.getText());
        double SecondNumber = Double.parseDouble(Text2.getText());
        double Result1 = FirstNumber + SecondNumber;
        double Result2 = FirstNumber - SecondNumber;

        if (event.getSource() == Add) {
            ResultTextF.setText("" + roundTo2DecimalPlaces(Result1));
        } else if (event.getSource() == Subtract) {
            ResultTextF.setText("" + roundTo2DecimalPlaces(Result2));
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