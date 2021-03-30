package Leetcode;

public class HouseRobber {
    /**
     * @description 배열에 중복되지 않은 값을 합하여 최대값을 리턴하는 문제
     * 전형적인 DP 문제
     */
    public static void main(String[] args) {
        int rob1 = rob(new int[]{1, 2, 3, 1});
        int rob2 = rob(new int[]{2, 7, 9, 3, 1});

        System.out.println("rob1 = " + rob1);
        System.out.println("rob2 = " + rob2);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}
