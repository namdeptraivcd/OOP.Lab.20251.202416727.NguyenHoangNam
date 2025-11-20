package lab1.exercise_6;
import java.util.Scanner;
public class exercise_6_6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of column");
        int column_size = sc.nextInt();
        System.out.println("Enter size of row");
        int row_size = sc.nextInt();

        //init matrix
        double A[][] = new double[column_size][row_size];
        double B[][] = new double[column_size][row_size];
        double C[][] = new double[column_size][row_size];
        
        //Matrix A
        System.out.println("Enter matrix A");
        for (int i=0; i< column_size; i++){
            for (int j= 0; j < row_size; j++){
                A[i][j] = sc.nextDouble();
            }
        }


        //Matrix B
        System.out.println("Enter matrix B");
        for (int i=0; i< column_size; i++){
            for (int j= 0; j < row_size; j++){
                B[i][j] = sc.nextDouble();

    }
}
        //Add
        for (int i=0; i< column_size; i++){
            for (int j= 0; j < row_size; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
    }
        //Print
        System.out.println();
        System.out.println("The final matrix: ");
        
        for (int i=0; i< column_size; i++){
            for (int j= 0; j < row_size; j++){
                System.out.print(C[i][j] + " ");
            }
            System.out.println();

        }

}
}
