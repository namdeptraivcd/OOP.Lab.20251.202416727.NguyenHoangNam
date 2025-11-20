package lab1.exercise_6;
import java.util.Scanner;

public class exercise_6_2 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("What's your name ?");
        String name = sc.nextLine();

        System.out.println("How old are you ?");
        int age = sc.nextInt();
        
        System.out.println("How tall are you ?");
        double height = sc.nextDouble();


        System.out.println(" Mr/Ms " + name + " is " + age + ". Your height is " + height);


        sc.close();
    }
}
