import java.util.*;
public class pr10{
    void print(int s[][], int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            print(s, i, s[i][j]);
            print(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matrices: a");
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        System.out.println("Enter dimensions array:");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int L = 2; L <= n; L++) {
            for (int i = 1; i <= n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }
        System.out.println("\nM Matrix (Cost Table):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    System.out.print("0\t");
                else
                    System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\nS Matrix (Split Table):");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= j)
                    System.out.print("0\t");
                else
                    System.out.print(s[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("\nOptimal Parenthesization: ");
        mcm obj = new mcm();
        obj.print(s, 1, n);
        System.out.println("\nMinimum number of multiplications: " + m[1][n]);
    }
}
