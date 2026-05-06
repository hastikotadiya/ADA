import java.util.*;
public class pr6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        long start1 = System.nanoTime();
        int pos1 = -1;
        for(int i = 0; i < n; i++) {
            if(arr[i] == key) {
                pos1 = i;
                break;
            }
        }
        long end1 = System.nanoTime();
        if(pos1 != -1)
            System.out.println("Linear Search: Element found at position " + (pos1 + 1));
        else
            System.out.println("Linear Search: Element not found");

        System.out.println("Linear Search Time: " + (end1 - start1) + " ns");

       
        Arrays.sort(arr); 
        System.out.print("Sorted Array: ");
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
        long start2 = System.nanoTime();
        int low = 0, high = n - 1, pos2 = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[mid] == key) {
                pos2 = mid;
                break;
            } else if(arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        long end2 = System.nanoTime();
        if(pos2 != -1)
            System.out.println("Binary Search: Element found at position " + (pos2 + 1));
        else
            System.out.println("Binary Search: Element not found");
        System.out.println("Binary Search Time: " + (end2 - start2) + " ns");
    }
}
