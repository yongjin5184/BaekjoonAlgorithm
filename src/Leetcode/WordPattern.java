package Leetcode;

import java.util.HashMap;

public class WordPattern {

    /**
     * @description Pattern 과 String 을 받아 string 이 pattern 형식을 따르고 있는지 검사하는 문제
     * ex)  "abba", "dog cat cat dog" -> true
     * "abba", "dog dog dog dog" -> false
     * 1. Pattern 의 character 와 String 을 split 하여 pattern 에 하나의 문자가 mapping 되어있는 map 을 만든다.
     * 2. map 에 해당 character 가 없는데, 문자를 포함하고 있다면 false 를 return 한다.
     * 3. map 에 해당 character 가 맵핑 되어 있지만, 맵핑된 character 의 값과 입력된 strings[i] 가 다른 문자라면 false 를 return 한다.
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }

        if (pattern.length() == 1) {
            return true;
        }

        char[] patterns = pattern.toCharArray();
        HashMap<Character, String> patternMap = new HashMap<>();
        for (int i = 0; i < patterns.length; i++) {
            if (patternMap.get(patterns[i]) == null) {
                if (patternMap.containsValue(strings[i])) {
                    return false;
                }

                patternMap.put(patterns[i], strings[i]);
            } else {
                if (!patternMap.get(patterns[i]).equals(strings[i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));

    }
}
