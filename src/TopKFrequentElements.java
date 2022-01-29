package src.src;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class TopKFrequentElements {
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
