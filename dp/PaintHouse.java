package dp;

import java.util.*;

// PAINTHOUSE WITH MANY COLORS

public class PaintHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no of houses
        int c = scn.nextInt(); // no. of colors

        int[][] arr = new int[n][c]; // 3 as in 3 colors red blue or green

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][c];

        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE; // second least value

        // gives the min element from the first row
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = arr[0][j]; // filling up the first row
            if (arr[0][j] <= least) {
                sleast = least;
                least = arr[0][j];

            } else if (arr[0][j] <= sleast) {
                sleast = arr[0][j];
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;
            for (int j = 0; j < dp[0].length; j++) {
                if (least == dp[i - 1][j]) {
                    // can't include the same color
                    dp[i][j] = sleast + arr[i][j];
                } else {
                    dp[i][j] = least + arr[i][j];
                }

                if (dp[i][j] <= nleast) {
                    nsleast = nleast;
                    nleast = dp[i][j];
                } else if (dp[i][j] <= nsleast) {
                    nsleast = dp[i][j];
                }

            }
            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);
    }
}
