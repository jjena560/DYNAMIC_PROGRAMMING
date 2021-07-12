package dp;

import java.util.*;

public class BuySellStocks3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // price of the stock at these days
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int fee = scn.nextInt(); // transaction fee of selling the stock

        int obsp = -prices[0]; // old buy state profit
        int ossp = 0; // there is no selling state profit at first, first you have to buy a stock

        for (int i = 1; i < prices.length; i++) {
            int nbsp = 0;
            int nssp = 0; // new selling state profit

            if (ossp - prices[i] > obsp) {
                nbsp = ossp - prices[i];
            } else {
                nbsp = obsp;
            }

            // 10 20 30
            // 2

            // obsp = -10 ossp = 0
            // nbsp = -10 nssp = 8
            // obsp = -10 ossp =8
            // nbsp = -10 nssp = 18
            // obsp = -10 ossp = 18 -> answer

            if (prices[i] - fee + obsp > ossp) {
                nssp = prices[i] - fee + obsp;
            } else {
                nssp = ossp;
            }
            obsp = nbsp;
            ossp = nssp;
        }

        System.out.println(ossp);
    }
}
