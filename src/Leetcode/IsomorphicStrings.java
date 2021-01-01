package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    /**
     * @description 두 개의 String 이 같은 구조로 되어있는지 확인하는 문제 ex) egg, add 는 true
     * 1. 두 개의 HashMap 을 선언하고 tMap, sMap 에는 각각 t, s 의 char 를 기준으로 Map 을 만든다.
     * 2. 각각의 맵이 비어있고, 각 맵과 배열의 char 가 다르면 false 를 반환한다.
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) {
            return true;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!sMap.containsKey(sChar) && !tMap.containsKey(tChar)) {
                sMap.put(sChar, tChar);
                tMap.put(tChar, sChar);
            } else {
                if (sMap.get(sChar) == null || tMap.get(tChar) == null
                        || sMap.get(sChar) != tChar || tMap.get(tChar) != sChar) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(isIsomorphic("egg", "add"));
//        System.out.println(isIsomorphic("foo", "bar"));
//        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
