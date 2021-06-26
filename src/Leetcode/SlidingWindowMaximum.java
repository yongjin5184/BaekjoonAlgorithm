package Leetcode;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 239. Sliding Window Maximum
     * @description 슬라이딩 윈도우 안에서 가장 큰 수를 찾는 문제
     * 해당 풀이 방법으로는 Time out error 가 나옴 long(n) 의 풀이 방법을 찾아야 함
     *
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int max;
        int n = nums.length;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i <= n - k; i++) {
            max = nums[i];
            for (int j = 1; j < k; j++) {
                if (nums[i + j] > max) {
                    max = nums[i + j];
                }
            }
            result[i] = max;
        }

        return result;
    }
}
