package lab1.exercise_2_2_6;

import javax.swing.*;

public class exercise_2_2_6_part1 {
    public static void Linear_equation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "There are infinite roots.");
            } else {
                JOptionPane.showMessageDialog(null, "There is no real root.");
            }
        } else {
            double root = -b / a;
            JOptionPane.showMessageDialog(null, "Root of the equation " + a + "x + " + b + " = 0 is: " + root);
        }
    }

    public static void main(String[] args) {
        String inputA = JOptionPane.showInputDialog("Enter coefficient a:");
        double a = Double.parseDouble(inputA);

        String inputB = JOptionPane.showInputDialog("Enter coefficient b:");
        double b = Double.parseDouble(inputB);

        Linear_equation(a, b);

        System.exit(0);
    }
}
