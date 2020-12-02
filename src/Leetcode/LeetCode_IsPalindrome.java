package src.src.Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_IsPalindrome {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode isPalindrome
         * solution     : 기본 숫자를 reverse 하여 비교한다.
         * result       : O(n^2)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(isPalindrome(Integer.parseInt(br.readLine())));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int sum = 0;
        int target = x;
        while (x > 0) {
            int temp = x % 10;
            sum = sum * 10 + temp;
            x = x / 10;
        }

        return sum == target;
    }
}
