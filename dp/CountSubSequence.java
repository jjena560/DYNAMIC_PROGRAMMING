package dp;

import java.util.*;

// we want a+b+c+ (+1 or more )

public class CountSubSequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.next();

        int[][] dp = new int[3][str.length()];

        // in the starting there is nothing
        int a = 0; // this is a+
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                // a new a can either get added or not and it can also start its own substring
                a = 2 * a + 1;
            } else if (str.charAt(i) == 'b') {
                // b can get added or not to the previous -> a+b+
                // new b can also be added to the previous -> a+ but it cannot start it own
                // substring as the substring
                // should always start with a -> b -> c
                ab = 2 * ab + a;
            } else if (str.charAt(i) == 'c') {
                // the new c can be added or not to the previous -> a+b+
                // the new c can also be added to the previous -> a+b+
                abc = 2 * abc + ab;
            }
        }

        System.out.println(abc);

    }
}
