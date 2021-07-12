package dp;

import java.util.*;

// k transactions are allowed here
public class BuySellStocks6 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int k = scn.nextInt(); // k transactions

        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            int max = Integer.MIN_VALUE;
            for (int d = 1; d < prices.length; d++) {
                // same transaction a day before
                if (dp[t - 1][d - 1] - prices[d - 1] > max) {
                    max = dp[t - 1][d - 1] - prices[d - 1];
                }

                if (max + prices[d] > dp[t][d - 1]) {
                    dp[t][d] = max + prices[d];

                } else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }

        // N3 method this needs to be optimized

        // for (int i = 1; i < dp.length; i++) {
        // for (int j = 1; j < dp[0].length; j++) {
        // // iff j - 1th day has completed i number of transaction
        // int max = dp[i][j - 1]; // jth day i transaction = j-1 th day i transaction

        // for (int pd = 0; pd < j; pd++) {
        // int ptillim1 = dp[i - 1][pd]; // profit till i minus 1 transaction
        // int ptih = prices[j] - prices[pd];
        // if (ptillim1 + ptih > max) {
        // max = ptillim1 + ptih;
        // }
        // }

        // dp[i][j] = max;

        // }
        // }

        System.out.println(dp[k][n - 1]);
    }
}
