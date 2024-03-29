package dp;

import java.util.*;

public class TilingFloor2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // length of the floor
        int m = scn.nextInt(); // width of the floor

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }

        System.out.println(dp[n]);
    }
}
