import java.util.*;

public class pr12{
    public static int[][] computeSCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1]
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;

        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }
    public static String buildSCS(String X, String Y, int[][] dp) {
        int i = X.length();
        int j = Y.length();
        StringBuilder scs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] <= dp[i][j - 1]) {
                scs.append(X.charAt(i - 1));
                i--;
            } else {
                scs.append(Y.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }
        return scs.reverse().toString();
    }
    public static void printTable(int[][] dp) {
        System.out.println("\nSCS DP Table:");
        for (int[] row : dp) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String X = sc.nextLine();
        System.out.print("Enter second string: ");
        String Y = sc.nextLine();
        int[][] dp = computeSCS(X, Y);
        printTable(dp);
        String result = buildSCS(X, Y, dp);
        System.out.println("\nSCS Sequence: " + result);
        System.out.println("Length of SCS: " + dp[X.length()][Y.length()]);
    }
}
