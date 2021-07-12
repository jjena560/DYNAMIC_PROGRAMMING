package dp;

import java.util.*;

public class PartitionSubsets {

    // divide n number of players in k teams
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no. of players
        int k = scn.nextInt(); // no. of teams

        int[][] dp = new int[k + 1][n + 1];

        // number of players can't be less than no. of teams
        if (n == 0 || k == 0 || n < k) {
            System.out.println(0);
            return;
        }

        for (int t = 1; t <= k; t++) {
            for (int p = 1; p <= n; p++) {
                if (p < t) {
                    // 0 ways if numbers of players are less than no. of teams
                    dp[t][p] = 0;
                } else if (p == t) {
                    // 3 == 3 then in every team there can only be one player so only one way
                    dp[t][p] = 1;
                } else {
                    dp[t][p] = dp[t][p - 1] * t + dp[t - 1][p - 1];
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
