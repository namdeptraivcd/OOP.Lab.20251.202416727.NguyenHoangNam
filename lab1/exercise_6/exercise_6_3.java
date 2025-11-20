package lab1.exercise_6;
import java.util.Scanner;
public class exercise_6_3 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i =0; i<5; i++){
            System.out.println(" ".repeat(n - i) + "*".repeat(i) + "*" + "*".repeat(i));
        }

        sc.close();
    }
    
}
