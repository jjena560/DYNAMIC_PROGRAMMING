package dp;

import java.util.*;

//  two transaction are allowed
public class BuySellStocks5 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // at evry point we will store the max profit till that point.
        // here you don't have to sell the stock on the given date only, you have to
        // sell the stock beofre or on that date.

        // at evry point what is stored
        // -> if the stock is sold on that day or before that day what is max profit
        // -> and if the stock is bought on that day or days after this day what is max
        // profit.
        int n = scn.nextInt();

        // In forward iteration -> today is selling day what is the best buying day in
        // the left.
        // In backward iteration -> today is buying day and what is your best selling
        // day in the right.
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        // from left to right
        int mpist = 0;
        int lsf = prices[0];
        int[] dpl = new int[prices.length]; // dp max profit if sold upto today
        // dp will store the max profit to the ith day
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lsf) {
                lsf = prices[i];
            }

            mpist = prices[i] - lsf;
            if (dpl[i - 1] < mpist) {
                dpl[i] = mpist;
            } else {
                dpl[i] = dpl[i - 1];
            }

        }

        // from right to left
        int mpibt = 0; // max profit if bought today
        int mat = prices[prices.length - 1]; // max after this
        int[] dpr = new int[prices.length]; // dp right
        for (int i = prices.length - 2; i >= 0; i--) {
            if (mat < prices[i]) {
                mat = prices[i];
            }

            mpibt = mat - prices[i];
            if (dpr[i + 1] < mpibt) {
                dpr[i] = mpibt;
            } else {
                dpr[i] = dpr[i + 1];
            }
        }

        int op = 0; // overll profit
        // a point which contains the best left + right profit is the answer
        for (int i = 0; i < prices.length; i++) {
            if (dpl[i] + dpr[i] > op) {
                op = dpl[i] + dpr[i];
            }
        }

        System.out.println(op);
    }
}
