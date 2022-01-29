package src.src;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TopKFrequentElements {
    /**
     * LeetCode 347. Top K Frequent Elements
     *
     * @description 배열에서 가장 빈번하게 나오는 K 개의 숫자를 반환하라
     * 1. key는 배열의 index 를 갖고 value은 index 의 카운트를 갖는 맵을 만든다.
     * 2. 맵을 k 만큼 자른 후, sorting 한다.
     * 3. 맵을 배열로 만든 후 반환한다.
     */
    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{5, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4}, 2);
        for (int num : ints) {
            System.out.println(num);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countOfNumber = getCountOfNumbers(nums);
        return getLargeValues(countOfNumber, k);
    }

    private static Map<Integer, Integer> getCountOfNumbers(int[] nums) {
        Map<Integer, Integer> countOfNumber = new HashMap<>();
        for (int num : nums) {
            int value = countOfNumber.getOrDefault(num, 0);
            countOfNumber.put(num, ++value);
        }

        return countOfNumber;
    }

    private static int[] getLargeValues(Map<Integer, Integer> countOfNumber, int k) {
        return convertLimitAndSorted(countOfNumber, k)
                .keySet().stream()
                .mapToInt(integer -> integer)
                .toArray();
    }

    private static LinkedHashMap<Integer, Integer> convertLimitAndSorted(Map<Integer, Integer> countOfNumber, int k) {
        return countOfNumber.entrySet().stream()
                .sorted(comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)
                );
    }
}
