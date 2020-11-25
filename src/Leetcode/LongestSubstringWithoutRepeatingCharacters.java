package Leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

  public static int lengthOfLongestSubstring(String s) {
    int startPointer = 0;
    int endPointer = 0;
    int max = 0;

    HashSet<Character> hs = new HashSet<>();
    while(endPointer < s.length()) {
      if(!hs.contains(s.charAt(endPointer))) {
        hs.add(s.charAt(endPointer));
        endPointer++;
        max = Math.max(hs.size(), max);
      } else {
        hs.remove(s.charAt(startPointer));
        startPointer++;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    String str1 = "abcabccc";
    String str2 = "bbbbbbb";
    String str3 = "pwwkew";

    System.out.println(lengthOfLongestSubstring(str1));
    System.out.println(lengthOfLongestSubstring(str2));
    System.out.println(lengthOfLongestSubstring(str3));
  }
}
