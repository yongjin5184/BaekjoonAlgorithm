package src.src.Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeetCode_PlusOne {

    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Plus One
         *                digit 배열에 1을 더한 벼열을 return 한다.
         * solution     : 마지막 숫자가 9보다 작다면 1을 더하고 리턴한다.
         *                마지막 숫자가 9라면 그 자리는 0이 되고, 9가 아닌 수가 나올 때 1을 더해서 리턴한다.
         *                모든 숫자가 9인 경우는 배열의 크기를 하나 늘린 후, 1 0 0 ... 으로 리턴한다.
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int[] nums = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null) {
            return null;
        }

        int digitsLen = digits.length;
        for (int i = digitsLen - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digitsLen + 1];
        result[0] = 1;
        return result;
    }
}
