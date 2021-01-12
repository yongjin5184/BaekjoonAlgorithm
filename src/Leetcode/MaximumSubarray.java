package Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSubarray {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Maximum Subarray
         *               부분 배열의 합에서 큰 값을 찾는 문제
         * solution     : (이전 부분합 + i의 합), i 중  Max 값을 구해서 부분합이 가장 클 때를 구한다.
         * result       : O(n)
         */

        /**
         * Input: [-2,1,-3,4,-1,2,1,-5,4],
         * Output: 6
         * Explanation: [4,-1,2,1] has the largest sum = 6.
         *
         * 로직
         * max = -2
         *
         * max(-2 + 1, 1) -> 1
         * max = 1
         *
         * max( 1 - 3, -3) -> -2
         * max = 1
         *
         * max(-2 + 4, 4) -> 4
         * max = 4
         *
         * max(4  + -1, -1) -> 3
         * max = 4
         *
         * max(3 + 2, 2) -> 5
         * max = 5
         *
         * max(5 + 1, 1) -> 6
         * max = 6
         *
         * max(6 + -5, -5) -> 1
         * max = 6
         *
         * max(1 + 4, 4) -> 5
         * max = 6
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int[] nums = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSubarray = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxSubarray = Math.max(maxSubarray + nums[i], nums[i]);
            if(maxSubarray > max){
                max = maxSubarray;
            }
        }

        return max;
    }
}
