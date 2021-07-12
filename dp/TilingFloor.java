package dp;

import java.util.*;

// similar to source to destination problem 
// source here is the untiled floor and the destination is the completely tiled floor
public class TilingFloor {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // length of the floor which is 2m wide

        int[] dp = new int[n + 1];
        dp[1] = 1; // length of 1m and tile is of length 1m so only one tile can be fixed
                   // vertucally
        dp[2] = 2; // both vertically both horizonatlly sp 2 ways in which the floor can be tiled

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
