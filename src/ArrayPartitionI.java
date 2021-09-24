import java.util.Arrays;

public class ArrayPartitionI {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }

    public static int arrayPairSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            result += nums[i];
        }

        return result;
    }
}
