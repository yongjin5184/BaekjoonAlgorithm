package Leetcode;

import java.util.Arrays;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {

        if (nums.length < 3) {
            return -1;
        }

        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();
        int pivot;
        int pastPivotNum = 0;
        for (int i = 0; i < nums.length; i++) {
            pivot = nums[i];
            rightSum = rightSum - pivot;
            leftSum = leftSum + pastPivotNum;
            if (leftSum == rightSum) {
                return i;
            }

            pastPivotNum = pivot;

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }
}
