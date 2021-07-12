package dp;

import java.util.*;

public class MinCostPath {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // row and cols of the grid
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                // divide the problem into 4 phases
                // 1 -> if the cell is the last cell
                // 2 -> if it is the last row then just add the value of the curr cell to the
                // value of the cell before it in the same row
                // 3-> if it is the last col then it can only go down so add the value of the
                // curr cell to the
                // value of the cell below it
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + arr[i][j];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + arr[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
