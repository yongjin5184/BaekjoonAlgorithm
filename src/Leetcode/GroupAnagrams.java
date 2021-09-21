package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    /**
     * @description 49. Group Anagrams
     */
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> items = new ArrayList();
        int k = 0;
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = new String(strChars);
            if (map.get(key) == null) {
                map.put(key, k++);
                ArrayList<String> item = new ArrayList<>();
                item.add(str);
                items.add(item);
            } else {
                int n = map.get(key);
                List<String> item = items.get(n);
                item.add(str);
                items.set(n, item);
            }
        }
        return items;
    }
}
