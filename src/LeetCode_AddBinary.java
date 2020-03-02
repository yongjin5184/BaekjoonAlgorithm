import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_AddBinary {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Add Binary
         *                이진수 덧셈 ex) 1 + 11 = 100
         * solution     : 1. i, j 는 문자의 마지막 부터 i, j 가 0 보다 크거나 작을때까지 while loop 를 돌린다.
         *                2. 더한 수의 %2 는 문자에 append 되고 /2 는 올림 처리를 한다.
         *                3. 문자의 reverse 를 하여 최종 덧셈 값을 구한다.
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(addBinary(br.readLine(), br.readLine()));
    }

    public static String addBinary(String a, String b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0 && a.charAt(i) == '1') {
                sum++;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                sum++;
            }
            int digit = sum % 2;
            carry = sum / 2;
            sb.append(digit);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}
