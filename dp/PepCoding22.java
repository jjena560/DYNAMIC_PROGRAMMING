package dp;

public class PepCoding22 {
    public static void main(String[] args) {
        int[] arr = { 6, 5, 100, 10, 10, 5 };

        int inc = arr[0];
        int exc = 0;
        for (int i = 1; i < arr.length; i++) {
            // new include will be derived from the previous exclude and the current element
            int ninc = exc + arr[i];
            // new exclude will be the max of preivous inc and previous exc
            int nexc = Math.max(inc, exc);

            // make the new include as the main include
            inc = ninc;
            exc = nexc;
        }

        int ans = Math.max(inc, exc);

        System.out.println(ans);
    }
}
