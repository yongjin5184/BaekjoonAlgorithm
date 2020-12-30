package Leetcode;

public class ValidPalindrome {

    /**
     * @description Palindrome 문제
     * 1. 알파벳이 아니거나, 숫자가 아닌 특수문자의 경우만 다음 인덱스로 넘어가 문자를 비교하도록 한다.
     * * 알파벳이 아니고, 숫자가 아닌 경우는 아스키코드를 사용하여 분기 처리하였음
     */
    public static boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        if (chars.length == 1) {
            return true;
        }

        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {

            if (!((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z') ||
                    (chars[i] >= '0' && chars[i] <= '9'))) { // Character.isLetterOrDigit(chars[i]) 와 동일
                i++;
                continue;
            }

            if (!((chars[j] >= 'a' && chars[j] <= 'z') || (chars[j] >= 'A' && chars[j] <= 'Z') ||
                    (chars[j] >= '0' && chars[j] <= '9'))) {
                j--;
                continue;
            }

            if (chars[i] != chars[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("0P"));
        System.out.println(isPalindrome("ab2a"));
    }
}
