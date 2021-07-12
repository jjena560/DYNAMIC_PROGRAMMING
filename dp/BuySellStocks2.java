package dp;

import java.util.*;

// here we can do infinite transaction
public class BuySellStocks2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // the main idea is to collect all the upstroke
        // buy after the dip and sell before the dip
        // means in a spike buy when it is at its low and sell when it at its top price

        int n = scn.nextInt(); // no. of days
        int[] prices = new int[n];

        for (int i = 0; i < prices.length; i++) {
            prices[i] = scn.nextInt();
        }

        int bd = 0;
        int sd = 0; // buying and selling date
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                // we found a dip, so collect the current profit and move bd and sd to i
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            } else {
                sd = i;
            }
        }

        // for the last stroke
        profit += prices[sd] - prices[bd];

        System.out.println(profit);
    }
}
