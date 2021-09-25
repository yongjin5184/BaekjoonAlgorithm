package Leetcode;

public class LongestPalindromeSubstring {

    public static boolean dp[][];

    public static void main(String[] args) {
//    System.out.println(longestPalindrome("racecar"));
        System.out.println(longestPalindromeSubstring2("abb"));
        System.out.println(longestPalindromeSubstring2("babad"));
        System.out.println(longestPalindromeSubstring2("eeeeeeeeeee"));
    }

    public static String longestPalindromeSubstring2(String s) {
        int length = s.length();
        dp = new boolean[length][length];
        if (length == 1) {
            return s;
        }

        int longestCount = 0;
        String longestSubstring = "";

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isPalindrome(s, i, j)) {
                    int count = j - i + 1;
                    if (count > longestCount) {
                        longestCount = count;
                        longestSubstring = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestSubstring;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (dp[start][end]) {
            return true;
        }

        boolean ret = false;
        if (s.charAt(start) == s.charAt(end)) {
            ret = isPalindrome(s, start + 1, end - 1);
        }

        dp[start][end] = ret;
        return ret;
    }
}
