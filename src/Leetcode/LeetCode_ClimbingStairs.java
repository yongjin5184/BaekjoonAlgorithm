package Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_ClimbingStairs {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Climbing Stairs
         * solution     : 대표적인 다이나믹 프로그래밍 문제
         *                1. 계단의 수 + 1 만큼의 배열을 선언하고,
         *                2. i - 2 와 i - 1 의 값을 더해서 cache[i] 의 값을 구한다.
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(climbStairs(Integer.parseInt(br.readLine())));
    }

    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }

        return cache[n];
    }
}
