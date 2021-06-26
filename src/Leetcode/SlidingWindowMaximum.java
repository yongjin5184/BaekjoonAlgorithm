package Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    /**
     * 239. Sliding Window Maximum
     *
     * @description 슬라이딩 윈도우 안에서 가장 큰 수를 찾는 문제
     */
    public static void main(String[] args) {
        int[] ints = maxSlidingWindowOfQueue(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    /**
     * 풀이 1) Time out error 가 나옴 O(n^2) 풀이
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

    /**
     * 풀이 2) Time out error 가 나옴 O(n) 풀이
     */
    public static int[] maxSlidingWindowOfQueue(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        final int N = nums.length;
        if (k == 1) {
            return Arrays.copyOf(nums, N);
        }
        int[] res = new int[N - k + 1];
        int idx = 0;
        Deque<Integer> deq = new ArrayDeque<>(k);
        for (int i = 0; i < N; i++) {
            if (!deq.isEmpty() && i - deq.getFirst() == k) {
                deq.removeFirst();
            }
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.removeLast();
            }
            deq.addLast(i);
            if (i >= k - 1) {
                res[idx++] = nums[deq.getFirst()];
            }
        }
        return res;
    }
}
