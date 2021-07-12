package dp;

import java.util.*;

// only one transaction is allowed
public class BuySellStcoks {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // number of days

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt(); // ith value represents the stock price for that day
        }

        int lsf = Integer.MAX_VALUE; // least so far, to get the lowest price of that stock in the past
        int op = 0;// overall profit
        int pist = 0; // profit if sold today

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }
            pist = prices[i] - lsf; // if a stock has to be sold today then find its lsf in the past and choose that
                                    // for the buying option so the difference bw buy and sell prices is max
            if (pist > op) {
                op = pist;
            }
        }

        System.out.println(op);
    }
}
