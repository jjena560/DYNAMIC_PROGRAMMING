package dp;

import java.util.*;

public class CountBinaryStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // length of binary string

        // if the string ends with 0
        // int[] dp0 = new int[n + 1];
        // if the string ends with 1
        // int[] dp1 = new int[n + 1];

        // dp0[1] = 1;
        // dp1[1] = 1;

        int oczeroes = 1; // instead of taking arrays we'll take variables
        int ocones = 1;

        for (int i = 2; i <= n; i++) {
            int nczeroes = ocones;
            int ncones = oczeroes + ocones;

            oczeroes = nczeroes;
            ocones = ncones;
        }

        System.out.println(oczeroes + ocones);
    }
}
