package Leetcode;

import java.util.Arrays;


public class ThreeSumCloset {
    /***
     *
     * @description int array 와 target 을 받아 target 에 가장 가까운 배열 Three value 의 합을 구하는 문제
     * 1. 배열을 sorting 한다.
     * 2. 첫 번째 value 를 기준으로 두고, j (두 번째 value 부터 가르키는 값) k (array 의 마지막 을 가리키는 값)
     * 3. 첫 번째 value 를 기준으로 두는 루프를 설정 i 가 배열의 길이 -2 (three sum 이므로) 보다 크면 루프를 돌지 않는다.
     * 4. 두 번째 루프에서는 minimum closet 값을 구하는 데, 이는 떨어진 거리의 값이므로 abs 로 절대값을 구한다.
     * 5. three sum 을 구하고 three sum 이 target 보다 작을 경우는 j++ (sorted 되었기 때문에 arr[j] 을 큰 값으로 변경)
     * 6. three sum 이 target 보다 큰 경우는 k-- (sorted 되었기 때문에 arr[k] 을 작은 값으로 변경)
     * 7. 거리가 가장 적게 떨어져있는 minimum closet 을 찾을 때의 three sum 값을 구해 반환한다.
     */
    public static int threeSumCloset(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        int[] sortedArr = Arrays.stream(nums).sorted().toArray();

        int i = 0;
        int tmpOfMinimumCloset = Integer.MAX_VALUE;
        int resultOfMinimumCloset = 0;
        while (i < sortedArr.length - 2) {
            int index = sortedArr[i];
            int j = i + 1;
            int k = sortedArr.length - 1;
            while (j < k) {
                int threeSum = index + sortedArr[j] + sortedArr[k];
                int minimumCloset = Math.abs(target - threeSum);
                if (tmpOfMinimumCloset > minimumCloset) {
                    resultOfMinimumCloset = threeSum;
                    tmpOfMinimumCloset = minimumCloset;
                }

                if (threeSum < target) {
                    j++;
                } else if (threeSum > target) {
                    k--;
                } else {
                    return threeSum;
                }
            }
            i++;
        }

        return resultOfMinimumCloset;
    }

    public static void main(String[] args) {

        int[] arr1 = {-1, 2, 1, -4};
        int[] arr2 = {1, 1, 1, 0};
        System.out.println(threeSumCloset(arr1, 1));
        System.out.println(threeSumCloset(arr2, -100));
    }
}
