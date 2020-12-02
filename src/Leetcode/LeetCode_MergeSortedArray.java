package src.src.Leetcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeetCode_MergeSortedArray {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Merge Sorted Array
         *               두 개의 오름 차순으로 정렬된 Array 오름 차순 정렬로 합치는 문제
         * solution     : discuss 참고, 잘 이해 안되서 추후 살펴봐야 할 듯
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int[] nums1 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] nums2 = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(br.readLine());

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m = m - 1;
        n = n - 1;
        while(m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[index--] = nums1[m--];
            } else {
                nums1[index--] = nums2[n--];
            }
        }

        while(n >= 0) {
            nums1[index--] = nums2[n--];
        }

        System.out.println(Arrays.toString(nums1));
    }
}
