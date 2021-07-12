package dp;

import java.util.*;

// everything same as previous but you have to give cooldown(1 day) after every complete transaction
public class BuySellStocks4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // here we can buy on cool state not after selling state
        int n = scn.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int obsp = -prices[0];
        int ossp = 0;
        int ocsp = 0;

        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0;
            int nssp = 0;
            int ncsp = 0;

            if (ocsp - prices[i] > obsp) {
                nbsp = ocsp - prices[i];
            } else {
                nbsp = obsp;
            }

            if (ossp < obsp + prices[i]) {
                nssp = obsp + prices[i];
            } else {
                nssp = ossp;
            }

            // for best cooldown state
            if (ocsp < ossp) {
                ncsp = ossp;
            } else {
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }

        System.out.println(ossp);
    }
}
