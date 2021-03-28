package Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_Sqrt {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode sqrt(x)
         * solution     : 이진 탐색으로 sqrt 값을 구한다.
         * result       : O(log2n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(mySqrt(Integer.parseInt(br.readLine())));
    }

    public static int mySqrt(int x) {
        if (x == 0)
            return 0;

        long left = 1;
        long right = x;

        while (true) {
            long mid = (left + right) / 2;

            if (mid * mid > x) {
                right = mid - 1;
            } else {

                if ((mid + 1) * (mid + 1) > x)
                    return (int) mid;

                left = mid + 1;
            }
        }
    }
}
