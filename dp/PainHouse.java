package dp;

import java.util.*;

public class PainHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][3];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        long[][] dp = new long[n][3];

        // red color at house 1
        dp[0][0] = arr[0][0];
        // blue color at house 1
        dp[0][1] = arr[0][1];
        // green color at house 1
        dp[0][2] = arr[0][2];

        // fixed the values for house 1
        // looping through the houses
        for (int i = 1; i < arr.length; i++) {
            // ith house and red color
            // we have to check if the previous is not of the same color then add it to the
            // cost of red color for the ith house
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], dp[i - 1][0]);

        }

        long ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

        System.out.println(ans);
    }
}
