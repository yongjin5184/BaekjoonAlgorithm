package src.Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_LongestCommonPrefix {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode LongestCommonPrefix
         *                배열에서 공통으로 가장 긴 Prefix 를 찾는 문제
         * solution     : 1. 배열의 첫 번째 value 를 기준으로 prefix 를 구한다.
         *                2. prefix 의 길이를 1 부터 시작하여 모든 원소를 돌면서 String startWith method 를 사용한다.
         * result       : O(n^2)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        for(int i = 0; i < N; i++) {
            strs[i] = br.readLine();
        }

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return String.join("", strs);

        String prefix = "";
        String longestCommonPrefix = "";
        char[] charsOfFirstStr = strs[0].toCharArray();
        int i = 0;
        while(i < charsOfFirstStr.length){
            prefix += String.valueOf(charsOfFirstStr[i]);
            for(int j = 1; j < strs.length; j++) {
                if(!strs[j].startsWith(prefix)){
                    return longestCommonPrefix;
                }

                if(j == strs.length - 1) {
                    longestCommonPrefix = prefix;
                }
            }
            i++;
        }

        return longestCommonPrefix;
    }
}
