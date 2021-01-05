package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval {

    /**
     * @description intervals[i] = [start, end] 각각의 intervals 를 merge 하여 겹치지 않는 intervals 를 return 하는 문제
     * 1. Intervals 배열을 0 번 인덱스을 기준으로 sorting 한다.
     * 2. 리턴할 배열을 add 시킬 LinkedList 를 선언한다.
     * 3. 반복문을 돌면서 LinkedList 가 비어있거나 LinkedList 의 마지막 값보다 현재 배열이 더 큰 경우, 즉 겹치지 않는다면 LinkedList 에 add 한다.
     * 4. 그렇지 않은 경우, 즉 겹치는 경우가 있다면 LinkedList 의 마지막 값의 1번 인덱스와 현재 배열의 1번 인덱스 중 더 큰 값으로 마지막 배열의 값을 교체한다.
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergeIntervals = merge(intervals);
        for (int[] mergeInterval : mergeIntervals) {
            for (int i : mergeInterval) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

}

