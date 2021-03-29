package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {
        int majorityElement1 = majorityElement1(new int[]{3, 2, 3});
        System.out.println("majorityElement1 = " + majorityElement1);

        int majorityElement2 = majorityElement1(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println("majorityElement2 = " + majorityElement2);
    }

    /**
     * HashMap 사용하여 해당 값을 키로 하여 갯수를 구한다.
     */
    public static int majorityElement1(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int length = nums.length / 2;
        for (int num : nums) {
            int value = hm.getOrDefault(num, 0) + 1;
            if(length < value) {
                return num;
            }
            hm.put(num, value);
        }

        return -1;
    }

    /**
     * Sorting 하여 배열의 중간 값을 구한다
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * Boyer-Moore Voting Algorithm
     * Majority element 이면 +1 그렇지 않으면 -1 하여 Majority 를 구한다.
     */
    public static int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
