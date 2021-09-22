package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /**
     * @description 217. Contains Duplicate
     */
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    /**
     * HashMap 을 사용한 풀이법
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> containsSet = new HashSet<>();
        for (int num : nums) {
            if (!containsSet.add(num)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Array 을 사용한 풀이법
     */
    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        return false;
    }

}
