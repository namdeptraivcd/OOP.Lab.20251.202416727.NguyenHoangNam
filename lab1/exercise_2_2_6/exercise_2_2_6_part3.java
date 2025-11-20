package lab1.exercise_2_2_6;

import javax.swing.*;
import java.lang.Math;

public class exercise_2_2_6_part3 {
    public static void second_degree_equation(double a, double b, double c) {
        double delta = b * b - 4 * a * c;

        if (a == 0) {
            exercise_2_2_6_part1.Linear_equation(b, c);
            return;
        }

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null,
                    "The equation has two distinct solutions:\n" +
                            "x1 = " + x1 + "\n" +
                            "x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null,
                    "The equation has one double root:\n" +
                            "x = " + x);
        } else {
            JOptionPane.showMessageDialog(null,
                    "The equation has no real solutions.");
        }
    }

    public static void main(String[] args) {
        try {
            String inputA = JOptionPane.showInputDialog("Enter coefficient a:");
            double a = Double.parseDouble(inputA);

            String inputB = JOptionPane.showInputDialog("Enter coefficient b:");
            double b = Double.parseDouble(inputB);

            String inputC = JOptionPane.showInputDialog("Enter coefficient c:");
            double c = Double.parseDouble(inputC);

            second_degree_equation(a, b, c);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter numeric values.");
        }

        System.exit(0);
    }
}
