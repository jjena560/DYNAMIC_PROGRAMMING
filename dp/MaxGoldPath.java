package dp;

import java.util.*;

public class MaxGoldPath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] gold = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                gold[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for (int j = gold[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < gold.length; i++) {
                if (j == gold[0].length - 1) {
                    dp[i][j] = gold[i][j];
                } else if (i == 0) {
                    dp[i][j] = Math.min(gold[i][j + 1], gold[i + 1][j + 1]);
                } else if (i == gold.length - 1) {
                    dp[i][j] = Math.min(gold[i][j + 1], gold[i - 1][j + 1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j + 1], dp[i - 1][j + 1]), dp[i + 1][j + 1]);
                }
            }
        }

        int max = dp[0][0];

        for (int i = 0; i < gold.length - 1; i++) {
            if (gold[i][0] > max) {
                max = gold[i][0];
            }
        }

        System.out.println(max);
    }
}
