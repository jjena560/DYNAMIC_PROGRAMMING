package dp;

import java.util.*;

public class CoinCombinations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // will store all the types of coins
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println("Enter Target sum: ");

        int tar = scn.nextInt();

        int[] dp = new int[tar + 1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            // first we'll loop through each coin in the array
            for (int j = arr[i]; j < dp.length; j++) {
                // then we'll modify the dp according to the current coin
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[tar]);

    }
}
