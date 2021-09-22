package Leetcode;

public class ReverseString {

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'q', 'l', 'o', 'p'});
        reverseString(new char[]{'h', 'e', 'q', 'l', 'o'});
    }

    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        char temp;
        while(i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
