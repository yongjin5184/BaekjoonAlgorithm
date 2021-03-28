package Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_ImplementStrStr {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Implement StrStr
         * solution     : haystack 에서 needle 의 처음 index 를 반환한다.
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(strStr(br.readLine(), br.readLine()));
    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

