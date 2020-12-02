package src.src.Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_CountAndSay {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Implement countAndSay
         *                ex ) 1 -> 1개의 1
         *                     1 1 - > 2개의 1
         *                     2 1 -> 1개의 2 2개의 1
         *                     1 2 1 1
         * solution     : Discuss 참조
         * result       : O(n^2)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        System.out.println(countAndSay(Integer.parseInt(br.readLine())));
    }

    public static String countAndSay(int n) {
        int count = 1;
        String s = "1";
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n ; i++){
            sb.setLength(0);
            count = 1;
            for(int j = 1; j < s.length(); j++){
                if(s.charAt(j) != s.charAt(j-1)){
                    sb.append(count);
                    sb.append(s.charAt(j-1));
                    count = 0;
                }
                count++;
            }
            if(count > 0){
                sb.append(count);
                sb.append(s.charAt(s.length()-1));
            }
            s = sb.toString();
        }
        return s;
    }
}
