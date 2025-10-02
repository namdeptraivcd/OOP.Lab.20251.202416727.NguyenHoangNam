package lab1;

import java.util.Scanner;

public class exercise2_2_5 {
    static double sum (double x, double y){
        double res = x + y;
        
        return res;
    }

    static double difference (double x, double y){
        double res = x - y;
        return res;
    }

    static double product(double x, double y){
        double res = x * y;
        return res;
    }

    static double quotient(double x, double y){
        if (y == 0){
            System.out.println("Cann't divide");
            return Double.NaN;
        }
        double res = x/y;
        return res;

    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        double y = sc.nextDouble();


        double sum = sum(x, y);
        double difference = difference(x, y);
        double product = product(x, y);
        double quotient = quotient(x, y);


        System.out.println("Sum of " + x + " and " + y + " is " + sum);
        System.out.println("Difference of " + x + " and " + y + " is " + difference);
        System.out.println("Product of " + x + " and " + y +" is " + product);
        System.out.println("quotient of " + x + " and "+ y + " is " + quotient);


 
        sc.close();
    }
}
