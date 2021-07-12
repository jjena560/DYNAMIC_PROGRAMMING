package dp;

import java.util.*;

// climbing stairs with variable jumps
public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // this will store the values of jumps which can be taken from one place
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n + 1];

        // top down approach ,,, to go from 6th stair to the 6th stair there is only one
        // path that is just stay there
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < arr[i] && i + j < dp.length; j++) {
                dp[i] = dp[i + j];
            }

        }

        System.out.println(dp[0]);

    }
}
