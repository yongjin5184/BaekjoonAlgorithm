package src.src.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /**
         * description  : LeetCode TwoSum
         *               배열에 있는 두 수의 합을 더해 target 이 되면 그 때 새로운 배열을 리턴하는 문제
         * solution     : 기존에 생각하는 brute force 가 아니라 맵을 사용하여 target - num[i] 를 key, array 의 index 를 value 로 넣는다.
         * result       : O(n)
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int keyOfMap = target - nums[i];
            if (map.containsKey(keyOfMap)){
                return new int[]{map.get(keyOfMap), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
