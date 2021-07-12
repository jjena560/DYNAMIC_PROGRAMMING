package dp;

import java.util.*;

public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // total nunmber of plots on both side of the road

        int ob = 1; // old building
        int os = 1; // old space

        for (int i = 2; i <= n; i++) {
            int nb = os; // new building
            int ns = ob + os; // new space

            os = ns;
            ob = nb;
        }
        // possible arrangement on one side
        int total = os + ob;

        System.out.println(total * total);
    }
}
