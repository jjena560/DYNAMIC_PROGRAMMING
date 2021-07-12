package dp;

import java.util.*;

public class UnboundKnapSack {
    // duplicates are allowed here
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] vals = new int[n];

        for (int i = 0; i < n; i++) {
            vals[i] = scn.nextInt();
        }

        int[] wts = new int[n];

        for (int j = 0; j < n; j++) {
            wts[j] = scn.nextInt();
        }

        int cap = scn.nextInt();

        int[] dp = new int[cap + 1];
        dp[0] = 0;

        for (int bagc = 1; bagc <= cap; bagc++) {
            int max = 0;
            for (int val = 0; val < n; val++) {

                if (wts[val] <= bagc) {
                    int rbagc = bagc - wts[val];
                    int rbagv = dp[rbagc];
                    int tbagv = rbagv + vals[val]; // remaining bag value + the value of current weight
                    if (max < tbagv) {
                        max = tbagv;
                    }
                }
            }
            dp[bagc] = max;
        }

        System.out.println(dp[cap]);

    }
}
