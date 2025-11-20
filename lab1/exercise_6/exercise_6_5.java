package lab1.exercise_6;

import java.util.Scanner;
public class exercise_6_5 {
    static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static int partition(int left, int right, int a[]){
        int i = left;
        int j = right + 1;
        int pivot = a[left];
        while (true) {
            i = i +1;
            j = j -1;
            while (i <= right && a[i] < pivot){
                i++;
            }
            while (j > left && pivot < a[j]){
                j = j-1;
            }
            if (i > j) break;
                swap(a, i, j);
            
        }
        swap (a, left, j);
        return j;
    
    

    }
    public static void quick_sort (int left, int right, int a []){
        if (left < right){
            int pivot_index = partition(left, right, a);
            quick_sort(left, pivot_index -1 , a);
            quick_sort(pivot_index +1, right, a);
        }
    
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();

        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        quick_sort(0, n-1, a);
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        
        sc.close();
    }
}
