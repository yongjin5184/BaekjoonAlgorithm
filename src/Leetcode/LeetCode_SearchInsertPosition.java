package Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeetCode_SearchInsertPosition {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Implement Search Insert Position
         * solution     : 배열에서 target이  insert 될 위치를 찾는 문제
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int[] nums = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(searchInsert(nums, Integer.parseInt(br.readLine())));
    }

    static public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(target <= nums[i]){
                return i;
            }
        }

        return nums.length;
    }
}
