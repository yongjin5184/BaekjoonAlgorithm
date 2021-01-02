package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidateAnagram {

    public static boolean isImproveAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] charCounts = new char[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (char charCount : charCounts) {
            if (charCount != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (char sChar : sChars) {
            countMap.put(sChar, countMap.getOrDefault(sChar, 0) + 1);
        }

        for (char tChar : tChars) {
            if (!countMap.containsKey(tChar)) {
                return false;
            }

            if (countMap.get(tChar) == 1) {
                countMap.remove(tChar);
                continue;
            }

            countMap.put(tChar, countMap.get(tChar) - 1);
        }

        return countMap.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isImproveAnagram("anagram", "nagaram"));
        System.out.println(isImproveAnagram("rat", "car"));
    }
}
