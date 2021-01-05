package Leetcode;

import java.util.Arrays;

public class FindPivotIndex {
    /**
     * @description 배열을 받아서 양쪽의 합이 같은 pivot 의 index 를 return 하는 문제
     * 1. 배열의 합을 구한다.
     * 2. 하나의 포인터를 두어 배열의 원소를 지정해 가면서 오른쪽 값은 전체 합에서 pivot 값을 빼고, 왼쪽 값은 pivot 값을 더한다.
     * 3. 왼쪽과 오른쪽이 같아지는 순간 pivot 의 index 를 반환한다.
     */
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
