package Leetcode;

public class AddStrings {
    public static String addString(String a, String b) {
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }

        StringBuilder str = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int diff = bLen - aLen;
        int carry = 0;
        for (int i = aLen - 1; i >= 0; i--) {
            int sum = ((a.charAt(i) - '0') + (b.charAt(i + diff) - '0') + carry);
            str.append((char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        for (int i = bLen - aLen - 1; i >= 0; i--) {
            int sum = ((b.charAt(i) - '0') + carry);
            str.append((char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        if (carry > 0) {
            str.append((char) (carry + '0'));
        }

        return new StringBuilder(str.toString()).reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "12";
        String str2 = "198111";
        System.out.println(addString(str1, str2));
    }
}
