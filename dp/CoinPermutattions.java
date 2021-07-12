package dp;

import java.util.*;

public class CoinPermutattions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // no. of coins

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = scn.nextInt();
        }

        int tar = scn.nextInt();

        int[] dp = new int[tar + 1];
        dp[0] = 1;

        for (int amt = 1; amt < dp.length; amt++) {
            for (int coin : coins) {
                int ramt = amt - coin;
                dp[amt] += dp[ramt];

            }
        }

        System.out.println(dp[tar]);
    }
}
