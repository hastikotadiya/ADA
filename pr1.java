import java.util.*;

public class pr1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long start = System.nanoTime(); 

        for(int i = 0; i < n - 1; i++) {

            int min = i; 

            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

            System.out.print("Pass " + (i + 1) + ": ");
            for(int k = 0; k < n; k++) {
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }

        long end = System.nanoTime(); 

        System.out.println("Sorted Array:");
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println("\nExecution Time: " + (end - start) + " ns");
    }
}


