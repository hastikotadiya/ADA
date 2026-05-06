import java.util.*;
public class pr13{
    public static int[][] computeLCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }
    public static String buildLCS(String X, String Y, int[][] dp) {
        int i = X.length();
        int j = Y.length();
        StringBuilder lcs = new StringBuilder();
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }
    public static void printTable(int[][] dp) {
        System.out.println("\nLCS DP Table:");
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
        int[][] dp = computeLCS(X, Y);
        printTable(dp);
        String result = buildLCS(X, Y, dp);
        System.out.println("\nLCS Sequence: " + result);
        System.out.println("Length of LCS: " + dp[X.length()][Y.length()]);
    }
}
