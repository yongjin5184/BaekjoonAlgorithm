import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeetCodeRemoveDuplicatesFromSortedArray {
    public static void main(String[] args) throws IOException {
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
