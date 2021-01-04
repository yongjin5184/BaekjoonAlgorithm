package Leetcode;

public class MinimumSizeSubarraySum {

    /**
     * @description Target 값과 배열을 받아서 부분합의 크기가 target 보다 크거나 같은 가장 작은 부분 배열의 길이를 return 하는 문제
     * Sliding Window 를 사용한다.
     * 1. Sum 에 right 값을 계속 더해가며 window 를 형성한다.
     * 2. Sum 이 target 값 보다 더 큰 순간이 오면 Sum 에서 윈도우의 left 값을 빼고,
     * 3. 그렇지 않다면, window 에 right 값을 늘려나간다.
     * 4. Sum 이 target 보다 크거나 같다면, Math.min 을 이용하여 부분 배열의 최소값을 측정한다.
     */
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
