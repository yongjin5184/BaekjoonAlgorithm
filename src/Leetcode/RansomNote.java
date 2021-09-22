package Leetcode;

import java.util.HashMap;

public class RansomNote {
    /**
     * @description 383. Ransom Note
     */
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> words = makeMapOfWords(magazine);
        return isAllContainCharacterInMap(ransomNote, words);
    }

    private static boolean isAllContainCharacterInMap(String ransomNote, HashMap<Character, Integer> words) {
        char[] chars = ransomNote.toCharArray();
        for (Character c : chars) {
            Integer v = words.getOrDefault(c, 0);
            if (v == 0) {
                return false;
            }
            words.put(c, v - 1);
        }
        return true;
    }

    private static HashMap<Character, Integer> makeMapOfWords(String magazine) {
        char[] chars = magazine.toCharArray();
        HashMap<Character, Integer> words = new HashMap<>();
        for (Character c : chars) {
            Integer v = words.getOrDefault(c, 0);
            if (v == 0) {
                words.put(c, 1);
            } else {
                words.put(c, v + 1);
            }
        }
        return words;
    }
}
