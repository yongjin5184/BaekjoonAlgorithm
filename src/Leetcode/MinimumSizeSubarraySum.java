package Leetcode;

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            right++;

            while (sum >= s) {
                sum -= nums[left];
                min = Math.min(min, right - left);
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr1));
    }
}
