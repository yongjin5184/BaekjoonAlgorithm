package Leetcode;

public class PartitionEqualSubsetSum {
    /**
     * @description 주어진 배열을 두 개의 subset 으로 나누어서 두 subset 의 합이 같으면  true 를 반환하는 문제
     * DP 문제
     */
    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int s = sum / 2;
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = s; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[s] != 0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 5};
        int[] arr2 = {1, 5, 11, 5};
        System.out.println("arr1 = " + canPartition(arr1));
        System.out.println("arr2 = " + canPartition(arr2));
    }
}
