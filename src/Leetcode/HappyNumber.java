package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    /**
     *
     * @description n 의 각 자리수의 값을 계속 제곱 후, 합하여서 그 값이 1이 나오면 true, 끝나지 않고 순환을 이루면 false 를 반환하는 문제
     * Input: n = 19
     * Output: true
     * Explanation:
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n > 1) {

            int m = 0;
            while (n > 0) {
                int d = n % 10;
                m += d * d;
                n /= 10;
            }

            if (set.contains(m)) {
                return false;
            }

            set.add(m);
            n = m;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("isHappy = " + isHappy(19));
        System.out.println("isHappy = " + isHappy(2));
    }
}
