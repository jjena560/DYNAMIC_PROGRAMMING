package dp;

import java.util.*;

// A x mile road is given and n boards are given with the revenue of the board

// you have to plant the boards in the higway to maximize the revenue 
public class HighwayBillboard {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt(); // no. of miles of road
        int n = scn.nextInt(); // no. of boards
        int t = scn.nextInt(); // min difference between two boards

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = scn.nextInt();
        }

        int[] rev = new int[n];
        for (int j = 0; j < n; j++) {
            rev[j] = scn.nextInt();
        }

        int[] dp = new int[x];
        dp[0] = rev[0];
        int ans = 0;
        for (int i = 0; i < x; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int dist = i - j;
                if (dist > t) {
                    max = Math.max(max, dp[j]);
                }
            }
        }
    }
}
