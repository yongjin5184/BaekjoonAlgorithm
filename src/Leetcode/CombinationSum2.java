package src.src.Leetcode;


import java.util.*;


public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> results = new LinkedList<>();
        LinkedList<Integer> work = new LinkedList<>();

        Arrays.sort(candidates);

        for (int i = 0, len = candidates.length; i < len; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            dfs(candidates, i, target, work, results);
        }

        return results;
    }

    private static void dfs(int[] candidates, int index, int target, LinkedList<Integer> work, List<List<Integer>> results) {

        if (candidates[index] > target) {
            return;
        } else if (candidates[index] == target) {
            work.addLast(candidates[index]);
            results.add(new ArrayList<>(work));
            work.removeLast();
            return;
        }
        work.addLast(candidates[index]);
        for (int i = index + 1, len = candidates.length; i < len; i++) {
            if (i > index + 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] <= target - candidates[index]) {
                dfs(candidates, i, target - candidates[index], work, results);
            }
        }
        work.removeLast();
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(combinationSum2(candidates, 8));
    }
}
