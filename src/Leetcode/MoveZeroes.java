package Leetcode;

public class MoveZeroes {

    /**
     * @description 주어진 배열에 0 인 value 가 있으면 가장 마지막으로 이동시키는 문제
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     * <p>
     * 기본 아이디어 : 0 이 아닌 값이 나올 때, 0과 swap 한다.
     * 1. 2개의 포인터를 설정, 하나는 0을 가리키는 포인터와 배열의 원소를 순회하는 포인터를 설정
     * 2. 0 이 아닌 값이 나오면 0 과 swap 후, 0을 가리키는 포인터를 한 칸 이동한다.
     */
    public static void moveZeroes(int[] nums) {

        int zeroPointer = 0;
        for (int pointer = 0; pointer < nums.length; pointer++) {
            if (nums[pointer] != 0) {
                swap(nums, pointer, zeroPointer);
                zeroPointer++;
            }
        }

    }

    private static void swap(int[] nums, int pointer, int zeroPointer) {
        int temp;
        temp = nums[pointer];
        nums[pointer] = nums[zeroPointer];
        nums[zeroPointer] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        for (int i : arr) {
            System.out.print("i = " + i);
        }

        moveZeroes(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print("i = " + i);
        }
    }
}
