package src.src.programmers;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class SumOfTwoNumber {
    public static int[] solution(int[] numbers) {
        SortedSet<Integer> set = new TreeSet();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};
        Arrays.stream(solution(numbers1)).forEach(System.out::println);
        Arrays.stream(solution(numbers2)).forEach(System.out::println);
    }
}
