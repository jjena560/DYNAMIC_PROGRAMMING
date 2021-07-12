package dp;

import java.util.*;

// given a string of digits encode the str as the following rules
// 1 -> a ....... 26 -> z
public class DecodeWays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();

        int[] dp = new int[str.length()];
        // when there is only one character in the string
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
                // if the last two are both zeroe
                dp[i] = 0;

            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
                dp[i] = dp[i - 1];

            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
                if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1; // this call can only be called if there are more than two
                                                    // characters in the string
                } else {
                    dp[i] = 0;
                }

            } else {
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1); // the last two number should be less than 26 to make
                                                                  // this call
                } else {
                    dp[i] = dp[i - 1]; // if not then it can only go as a single char e.g. -> 36 6 will go asa single
                }

            }
        }
        System.out.println(dp[str.length() - 1]);
    }
}
