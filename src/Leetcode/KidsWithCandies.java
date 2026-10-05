package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> s = kidsWithCandies(candies, extraCandies);
        System.out.println(s);

        int[] candies2 = {4, 2, 1, 1, 2};
        int extraCandies2 = 1;

        List<Boolean> s2 = kidsWithCandies(candies2, extraCandies2);
        System.out.println(s2);

        int[] candies3 = {12, 1, 12};
        int extraCandies3 = 10;

        List<Boolean> s3 = kidsWithCandies(candies3, extraCandies3);
        System.out.println(s3);
    }

    /**
     * n은 아이 수(candies.length)입니다.
     * 시간 복잡도: O(n) — 최댓값 탐색 n번 + 결과 생성 n번 = 2n.
     * 두 반복문은 중첩되지 않으므로 O(n²)이 아니라 O(n)입니다.
     * 공간 복잡도: 결과 리스트를 포함하면 O(n), 결과를 제외한 보조 공간은 O(1)입니다.
     */
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 1. 원래 사탕 수의 최댓값을 구합니다.
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        // 2. 각 아이의 추가 후 사탕 수를 최댓값과 비교합니다.
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }

        return result;
    }
}
