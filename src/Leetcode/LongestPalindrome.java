package Leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }

    public static int longestPalindrome(String s) {
        final int len = s.length();

        final int size = 128;
        final int[] counts = new int[size];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            result += (counts[i] / 2 * 2);
        }
        return result == len? result: result + 1;
    }
}
