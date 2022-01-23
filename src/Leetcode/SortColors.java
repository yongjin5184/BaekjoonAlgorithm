package Leetcode;

public class SortColors {

    /**
     * 239. Sort Colors
     *
     * @description 구성요소가 0, 1, 2 인 배열을 0, 1, 2 순으로 정렬하는 문제
     * 1. 조건에 따르면 num 배열의 구성요소는 0, 1, 2 로만 구성됩니다.
     * 2. 따라서, 0, 1, 2 가 몇번씩 나오는지 (Count) 를 구합니다.
     * 3. 각 숫자의 Count 만큼 loop 를 돌면서 각 숫자(0, 1, 2) 를 배열에 넣어주면 Sort 된 Array 를 얻을 수 있습니다.
     */
    public static void main(String[] args) {
        sortColors(new int[]{0, 0, 1, 1, 2, 2});
        sortColors(new int[]{2, 0, 1});
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public static void sortColors(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;

        for (int num : nums) {
            if (num == 0) {
                redCount++;
            } else if (num == 1) {
                whiteCount++;
            } else {
                blueCount++;
            }
        }

        int index = 0;
        while (redCount > 0) {
            redCount--;
            nums[index] = 0;
            index++;
        }

        while (whiteCount > 0) {
            whiteCount--;
            nums[index] = 1;
            index++;
        }

        while (blueCount > 0) {
            blueCount--;
            nums[index] = 2;
            index++;
        }
    }
}
