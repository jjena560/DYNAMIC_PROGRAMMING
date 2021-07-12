package dp;

import java.util.*;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] vals = new int[n];
        int[] wts = new int[n];

        for (int i = 0; i < n; i++) {
            vals[i] = scn.nextInt();
        }

        for (int j = 0; j < n; j++) {
            wts[j] = scn.nextInt();
        }

        // cpacity of the bag
        int cap = scn.nextInt();

        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j]; // when i doesn't bat
                if (j >= wts[i - 1]) {
                    int rCap = j - wts[i - 1];
                    dp[i][j] = Math.max(dp[i - 1][rCap] + vals[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        System.out.println(dp[n][cap]);
    }
}
