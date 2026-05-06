import java.util.*;
public class pr9{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coin types (n): ");
        int n = sc.nextInt();
        System.out.print("Enter amount to make change for (N): ");
        int N = sc.nextInt();
        int d[] = new int[n + 1];
        System.out.println("Enter coin denominations:");
        for (int i = 1; i <= n; i++) {
            d[i] = sc.nextInt();
        }
        Arrays.sort(d, 1, n + 1);
        int c[][] = new int[n + 1][N + 1];
        for (int i = 1; i <= n; i++) {
            c[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1 && j < d[i]) {
                    c[i][j] = Integer.MAX_VALUE / 2;
                }
                else if (i == 1) {
                    c[i][j] = 1 + c[i][j - d[i]];
                }
                else if (j < d[i]) {
                    c[i][j] = c[i - 1][j];
                }
                else {
                    c[i][j] = Math.min(c[i - 1][j], 1 + c[i][j - d[i]]);
                }
            }
        }
        System.out.println("\nMaking Change Table:");
        System.out.print("Coin\\Amt\t");

        for (int j = 0; j <= N; j++) {
            System.out.print(j + "\t");
        }
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.print(d[i] + "\t\t");
            for (int j = 0; j <= N; j++) {
                if (c[i][j] >= Integer.MAX_VALUE / 2)
                    System.out.print("∞\t");
                else
                    System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
        if (c[n][N] >= Integer.MAX_VALUE / 2) {
            System.out.println("\nChange cannot be made with given coins.");
        } else {
            System.out.println("\nMinimum coins required = " + c[n][N]);
        }
    }
}
