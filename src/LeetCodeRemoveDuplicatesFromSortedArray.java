import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeetCodeRemoveDuplicatesFromSortedArray {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Remove Duplicates from Sorted Array
         *                정렬된 배열에서 중복되는 숫자는 제거하고 갯수를 구해서 리턴하는 문제
         * solution     : 1. 배열을 돌면서 큰 숫자가 나오면 그 때  count++ 하여 return
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        String[] test1 = {"0","0","1","1","1","2","2","3","3","4"};
        String[] test2 = {"1","1","2"};

        System.out.println(removeDuplicates(Arrays.asList(test1).stream().mapToInt(Integer::parseInt).toArray()));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 0) return 0;
        int count = 1;
        int num = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(num < nums[i]) {
                nums[count] = nums[i];
                count++;
                num = nums[i];
            }
        }

        return count;
    }
}
