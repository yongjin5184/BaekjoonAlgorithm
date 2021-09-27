package Leetcode;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    public static int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int result = 0;
        while(i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                result++;
                i++;
            }
            j++;
        }

        return result;
    }
}
