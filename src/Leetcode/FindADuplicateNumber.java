package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindADuplicateNumber {

    /**
     * @description Array 에서 중복되는 수를 찾아서 return 하는 문제
     * 1. map 에 값을 넣어서 중복되는 값이 나오면 return 하는 방법
     * 2. 같은 배열을 만들고 해당 배열의 인덱스 값으로 배열의 값을 옮기면서 해당 인덱스가 차있으면 return 하는 방법
     * 3. 하나의 배열에서 값을 옮기는데, 옮긴 값은 음수 처리, 음수인 경우 해당 값은 중복되었다고 생각하고 return 하는 방법
     */
    public static int findDuplicate3(int[] nums) {
        int first = nums[0];
        int second;
        int i = 0;
        while (i < nums.length) {
            if (nums[first] < 0) {
                return -nums[first];
            }
            second = nums[first];
            nums[first] = -first;
            first = second;
            i++;
        }

        return -1;
    }


    public static int findDuplicate2(int[] nums) {
        int[] newNums = new int[nums.length];

        for (int num : nums) {
            if (newNums[num] != 0) {
                return num;
            }
            newNums[num] = num;
        }
        return -1;
    }

    public static int findDuplicate1(int[] nums) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int num : nums) {
            Integer value = numberMap.get(num);
            if (value != null) {
                return num;
            }
            numberMap.put(num, num);
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate3(nums));
    }
}
