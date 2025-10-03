package lab1;
import javax.swing.*;

public class exercise2_2_5 {
    static double sum(double x, double y) {
        return x + y;
    }

    static double difference(double x, double y) {
        return x - y;
    }

    static double product(double x, double y) {
        return x * y;
    }

    static double quotient(double x, double y) {
        if (y == 0) {
            JOptionPane.showMessageDialog(null, "Can't divide ");
            return Double.NaN;
        }
        return x / y;
    }

    public static void main(String[] args) {

        String X = JOptionPane.showInputDialog("Enter x:");
        double x = Double.parseDouble(X);


        String Y = JOptionPane.showInputDialog("Enter y:");
        double y = Double.parseDouble(Y);

        double sum = sum(x, y);
        double diff = difference(x, y);
        double prod = product(x, y);
        double quot = quotient(x, y);

        String result = "Sum of " + x + " and " + y + " = " + sum
                      + "\nDifference of " + x + " and " + y + " = " + diff
                      + "\nProduct of " + x + " and " + y + " = " + prod
                      + "\nQuotient of " + x + " and " + y + " = " + quot;

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}
