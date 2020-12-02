package src.src.Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LeetCode_PascalsTriangle {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Pascals's Triangle
         *                1
         *                1 1
         *                1 2 1
         *                1 3 3 1
         *                1 4 6 4 1
         *                1 5 10 10 5 1
         * solution     : 1. 이중 루프를 돌면서 이전 list 의 j 와 j + 1 을 더하여, 하나의 레코드를 완성
         *                2. 완성된 레코드를 가장 상위의 List 에 add 하여 Pascals's Triangle 을 완성
         * result       : O(n^2)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int N = Integer.parseInt(br.readLine());

        System.out.println(generate(N));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        if (numRows == 0) return pascalsTriangle;

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        pascalsTriangle.add(temp);

        for (int i = 1; i < numRows; i++) {
            List<Integer> newRecord = new ArrayList<>();
            newRecord.add(1);
            List<Integer> preRecord = pascalsTriangle.get(i - 1);
            for (int j = 0; j < preRecord.size() - 1; j++) {
                newRecord.add(preRecord.get(j) + preRecord.get(j + 1));
            }
            newRecord.add(1);
            pascalsTriangle.add(newRecord);
        }

        return pascalsTriangle;
    }
}
