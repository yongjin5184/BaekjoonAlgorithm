import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LeetCode_RemoveElement {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Remove Element
         *               배열과 숫자가 주어지고 배열에서 숫자를 제거해 남은 숫자의 갯수를 반환하는 문제
         * solution     : 배열을 돌면서 해당 숫자와 같지 않을 경우
         *                count ++ 을 하고, num[count] 자리에 해당 숫자와 같지 않은 수를 넣어준다.
         * result       : O(n)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(removeElement(nums, N));
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}
