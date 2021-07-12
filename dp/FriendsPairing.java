package dp;

import java.util.*;

// in a group of friends a friend can either stay single or can pair with one other friend
public class FriendsPairing {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // number of friends

        int[] dp = new int[n + 1];

        dp[1] = 1; // if there is only friend then it can only stay single
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // stay single + pair with evry other friend once.
            // stay single -> give me the result of all other friends can pair with.
            // pair -> a person can pair with n-1 people as it can pair with every other
            // except himself.
            dp[i] = dp[i - 1] + dp[i - 2] * (i - 1); // to avoid permutation we're starting with taking one friend at
                                                     // the base
        }

        System.out.println(dp[n]);
    }
}
