package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] intersection = intersection(new int[]{1, 2, 2, 1, 2, 1}, new int[]{2, 2, 1, 2});
        Arrays.stream(intersection).forEach(System.out::println);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int k : nums1) {
            map.put(k, 1);
        }
        for (int j : nums2) {
            if (map.containsKey(j) && map.get(j) == 1) {
                list.add(j);
                map.put(j, map.get(j) - 1);
            }
        }

        int n = list.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
