package Leetcode;

public class SingleNumbers {

    /**
     * @description 배열의 모든 수는 2번씩 나타나고 딱 한 값만 한 번 나타난다. 한 번 나타나는 수를 찾는 문제
     * XOR 연산자를 사용하는 문제
     * ex) a ^ 0 = a
     * ex) a ^ a = 0
     * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr1));
    }
}
