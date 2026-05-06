import java.util.*;
public class pr3{
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
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.print("Pass " + i + ": ");
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
