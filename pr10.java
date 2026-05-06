import java.util.*;
public class pr10{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of objects (n): ");
        int n = sc.nextInt();
        int[] w = new int[n + 1];   
        int[] v = new int[n + 1];   
        System.out.println("Enter weights of objects:");
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }
        System.out.println("Enter values of objects:");
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
        }
        System.out.print("Enter capacity of knapsack (W): ");
        int W = sc.nextInt();
        int[][] p = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {

                if (w[i] > j) {
                    p[i][j] = p[i - 1][j];
                } 
                else {
                    p[i][j] = Math.max(
                            p[i - 1][j],
                            p[i - 1][j - w[i]] + v[i]
                    );
                }
            }
        }
        System.out.println("\nProfit Matrix P[n][W]:");
        System.out.print("n\\W\t");
        for (int j = 0; j <= W; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.print(i + "\t");
            for (int j = 0; j <= W; j++) {
                System.out.print(p[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nMaximum Profit = " + p[n][W]);
        System.out.print("Objects selected: ");
        int i = n;
        int j = W;
        while (i > 0 && j > 0) {
            if (p[i][j] != p[i - 1][j]) {
                System.out.print(i + " ");
                j -= w[i];
            }
            i--;
        }
    }
}
