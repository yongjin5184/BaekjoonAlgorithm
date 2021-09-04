package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_ThreeSum {
    /**
     * description  : LeetCode 3Sum
     * solution     : 1. 주어진 Array 를 Sorting 한다.
     *                2. 3개의 index 를 가리키는 3개의 포인터를 만든다.
     *                  2-1. 첫 번째 포인터는 target, 두 번째 포인터는 배열의 마지막 값을 가리킨다.
     *                3. 두 번째와 세번째 포인터가 가리키는 값이 target과 같을 때, target 보다 클 때, target 보다 작을 때로 분기를 나눈다.
     *                  3-1. target 과 같을 때, 배열에 넣어 준다.
     *                      (같은 값을 가질 수 있기 때문에 while 문을 통해 같은 값은 건너 뛰도록 작성한다.)
     *                  3-2. target 보다 클 때, 세 번째 포인터를 왼쪽으로 옮겨준다. (sorting 이 되어있으므로)
     *                  3-3. target 보다 작을 때, 두 번째 포인터를 오른쪽으로 옮겨준다.
     * result       : O(n^3)
     */
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 1, -1, -1, -1, 1, 1, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, 4}));
        System.out.println(threeSum(new int[]{5, 1, 0, -1, 2, -2}));
        System.out.println(threeSum(new int[]{-4, -2, 1, 3}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
