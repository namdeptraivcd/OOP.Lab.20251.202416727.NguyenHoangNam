package lab1.exercise_6;
import java.util.Scanner;

public class exercise_6_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month, year;
        
        while (true) {
            System.out.print("Enter month: ");
            if (sc.hasNextInt()) {
                month = sc.nextInt();
                if (month >= 1 && month <= 12) break;
            } else {
                sc.next(); 
            }
            System.out.println("Invalid month. Try again");
        }

        while (true) {
            System.out.print("Enter year: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year > 0) break;
            } else {
                sc.next();
            }
            System.out.println("Invalid year. Try again");
        }

        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

        int days = daysInMonth[month - 1];

        if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            days = 29;
        }

        System.out.println("The Month " + month+" of year " +year +" has " +days + " days.");
        sc.close();
    }
}
