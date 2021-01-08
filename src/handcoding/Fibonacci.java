package handcoding;

public class Fibonacci {

    public static long fibonacciDp(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("fibonacciDp(10) = " + fibonacciDp(10));
    }
}
