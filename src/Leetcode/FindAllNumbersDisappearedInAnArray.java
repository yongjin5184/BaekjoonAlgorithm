package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    /**
     * @description N 길이의 배열에서 1~N 사이의 사라진 숫자를 구하는 문제
     * 1. N + 1 만큼의 인덱스 배열을 만든다.
     * 2. 파라미터로 넘어온 배열의 값을 인덱스로 하여 인덱스 배열에 넣는다.
     * 3. 인덱스 배열이 0 일 경우, list 에 넣어 반환한다.
     */
    public static void main(String[] args) {
        List<Integer> disappearedNumbers1 = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        List<Integer> disappearedNumbers2 = findDisappearedNumbers(new int[]{1, 1});

        System.out.println("disappearedNumbers1 = " + disappearedNumbers1);
        System.out.println("disappearedNumbers2 = " + disappearedNumbers2);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] indexedNums = new int[nums.length + 1];

        for (int num : nums) {
            indexedNums[num] = num;
        }

        List<Integer> remainedNums = new ArrayList<>();
        for (int i = 1; i < indexedNums.length; i++) {
            if (indexedNums[i] == 0) {
                remainedNums.add(i);
            }
        }

        return remainedNums;
    }
}
