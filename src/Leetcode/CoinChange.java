package Leetcode;

import java.util.Arrays;

public class CoinChange {
    /**
     * @description  Coin 의 value 로 amount 를 만들 수 있는 가장 적은 갯수를 구하는 문제
     * Input: coins = [1,2,5], amount = 11
     * Output: 3
     * Explanation: 11 = 5 + 5 + 1
     */
    public static int coinChange(int[] coins, int amount) {
        int MAX = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        int[] coins2 = {2};
        System.out.println(coinChange(coins1, 11));
        System.out.println(coinChange(coins2, 3));
    }
}
