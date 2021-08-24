package Leetcode;

import java.util.Arrays;

/**
 * 1710. Maximum Units on a Truck
 * Greedy 트럭에 가장 많은 유닛을 싣는 문제 (박스에 유닛이 담겨 있음 {박스, 유닛})
 * 1. 배열을 유닛 갯수로 정렬한다.
 * 2. 트럭 사이즈 만큼 유닛 갯수를 싣는다.
 */
public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        int[][] boxTypes1 = {{1, 3}, {2, 2}, {3, 1}};
        System.out.println(maximumUnits(boxTypes1, 4));
        int[][] boxTypes2 = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(maximumUnits(boxTypes2, 10));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int units = 0;
        for (int[] box : boxTypes) {
            if (truckSize < box[0]) {
                units += truckSize * box[1];
                return units;
            }

            units += box[0] * box[1];
            truckSize -= box[0];
        }
        return units;
    }
}
