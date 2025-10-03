package lab1.exercise_2_2_6;

import javax.swing.*;

public class exercise_2_2_6_part2 {
    public static void linear_system(double a[][], double b[]) {
        // Tính định thức
        double D = a[0][0] * a[1][1] - a[0][1] * a[1][0];
        double D0 = b[0] * a[1][1] - b[1] * a[0][1];
        double D1 = a[0][0] * b[1] - a[1][0] * b[0];

        // Cramer
        if (D != 0) {
            double x0 = D0 / D;
            double x1 = D1 / D;
            JOptionPane.showMessageDialog(null,
                    "Roots of the system are:\n" + "x0 = " + x0 + ", x1 = " + x1);
        } else {
            if (D0 == 0 && D1 == 0) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions");
            } else {
                JOptionPane.showMessageDialog(null, "The system has no solution");
            }
        }
    }

    public static void main(String[] args) {
        double a[][] = new double[2][2];
        double b[] = new double[2];

        try {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    String input = JOptionPane.showInputDialog("Enter a[" + i + "][" + j + "]:");
                    a[i][j] = Double.parseDouble(input);
                }
                String inputB = JOptionPane.showInputDialog("Enter b[" + i + "]:");
                b[i] = Double.parseDouble(inputB);
            }
            linear_system(a, b);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter numeric values.");
        }

        System.exit(0);
    }
}
