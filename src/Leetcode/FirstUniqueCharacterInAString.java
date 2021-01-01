package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (char aChar : chars) {
            int count = characterCountMap.getOrDefault(aChar, 0) + 1;
            characterCountMap.put(aChar, count);
        }

        for (int i = 0; i < chars.length; i++) {
            if (characterCountMap.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
