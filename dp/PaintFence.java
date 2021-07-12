package dp;

import java.util.*;

// no more than two consecutive fences can have the same color

public class PaintFence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt(); // no. of fences
        int k = scn.nextInt(); // no. of colors

        int same = k * 1; // last two fences have the same color ( i - 1 have the color k and '*1' means
                          // the next fence have the same color)

        int diff = k * (k - 1); // i-1 have the color k and k-1 means i will have any color other than k
        int total = same + diff;
        // above are for two fences

        for (int i = 3; i <= n; i++) {
            same = diff * 1; // all the fences i which have different color than i-1 can have the same color
            diff = total * (k - 1); // all the fences i can have any color except the color which i-1 have
            total = same + diff;
        }

        System.out.println(total);

    }
}
