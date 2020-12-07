package src.src.Leetcode;


import java.util.*;


public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);

        List<Integer> combination = new ArrayList<>();
        findCombinationsToTarget(candidates, results, combination, 0, target);

        return results;
    }

    private static void findCombinationsToTarget(int[] candidates, List<List<Integer>> results,
                                                 List<Integer> combinations, int startIndex, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(combinations));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            combinations.add(candidates[i]);
            findCombinationsToTarget(candidates, results, combinations, i + 1, target - candidates[i]);
            combinations.remove(combinations.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
}
