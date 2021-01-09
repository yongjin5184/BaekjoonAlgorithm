package Leetcode;

public class MinCostClimbingStairs {
    /**
     * @description 최소비용으로 계단을 오르는 비용 구하기
     * 계단은 한 칸 or 두 칸씩 오를 수 있다.
     * 따라서, 현재 계단의 위치는 한 칸 전 계단을 오르는데 소요된 비용(dp[i-1])과 한 칸전(cost[i-1]) 비용,
     * 두 칸전 계단을 오르는데 소요된 비용(dp[i-2])과 두 칸전 비용(cost[i-2])의 최소값을 갖는다.
     */
    public static int minCostClimbingStairs(int[] cost) {
        int stairs = cost.length;
        if (stairs == 0) {
            return 0;
        }

        if (stairs == 1) {
            return cost[0];
        }

        if (stairs == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[stairs + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= stairs; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[stairs];
    }

    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs(arr);
    }
}
