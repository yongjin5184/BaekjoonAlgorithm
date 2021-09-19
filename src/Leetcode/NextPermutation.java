package Leetcode;

public class NextPermutation {

    /**
     * @description 31. Next Permutation 다음 수열을 찾는 문제, 수열을 큰 수로 정렬한다고 할 때, 바로 다음 큰 수의 값을 갖는 배열을 구하라
     * 단, 이러한 배열이 불가능할 경우, 가능한 가장 작은 값을 값을 갖는 배열을 구하라
     *
     * 풀이방법
     * 1.값이 커지는 가장 마지막 인덱스를 찾는다.
     * 2.기준 인덱스를 기준으로 오른쪽에 값 중,
     *   2-1) 기준 인덱스의 값보다 큰 값이면서
     *   2-2) 가장 작은 값을 찾아서 swap 한다.
     * 3. 기준 인덱스를 기준으로 오른쪽 값과 배열의 끝 값을 전부 reverse 한다.
     *
     * 1)
     * input: 1, 6, 9, 5, 4, 2, 1
     * output: 1, 9, 1, 2, 4, 5, 6
     *
     * 1번 진행 후, 기준 인덱스: 6
     * 2번 진행 후, 1, 9, 6, 5, 4, 2, 1
     * 3번 진행 후, 1, 9, 1, 2, 4, 5, 6
     *
     * 2)
     * input: 1, 1, 5
     * output: 1, 5, 1
     *
     * 1번 진행 후, 기준 인덱스: 1
     * 2번 진행 후, 1, 5, 1
     * 3번 진행 필요 없음
     *
     * 3)
     * input: 3, 2, 1
     * output: 1, 2, 3
     *
     * 1번 진행 후, 기준 인덱스가 존재하지 않는다.
     * 따라서, 3번 과정 reverse 만 진행
     * 3번 진행 후,  1, 2, 3
     *
     * 4)
     * input: 1, 2, 5, 4, 3
     * output: 1, 3, 2, 4, 5
     *
     * 1번 진행 후, 기준 인덱스: 1
     * 2번 진행 후, 1, 3, 5, 4, 2
     * 3번 진행 후, 1, 3, 2, 4, 5
     *
     *
     * 5)
     * input: 1, 6, 7, 5, 4, 8, 1
     * output: 1, 6, 7, 5, 8, 1, 4
     *
     * 1번 진행 후, 기준 인덱스: 4
     * 2번 진행 후, 1, 6, 7, 5, 8, 4, 1
     * 3번 진행 후, 1, 6, 7, 5, 8, 1, 4
     *
     * 6)
     * input: 1, 6, 7, 5, 4, 5, 6
     * output: 1, 6, 7, 5, 4, 5, 6
     *
     * 1번 진행 후, 기준 인덱스: 5
     * 2번 진행 후, 1, 6, 7, 5, 4, 6, 5
     * 3번 진행 필요 없음
     */
    public static void main(String[] args) {
        nextPermutation(new int[]{1, 6, 9, 5, 4, 2, 1});
        nextPermutation(new int[]{1, 1, 5});
        nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{1, 2, 5, 4, 3});
        nextPermutation(new int[]{1, 6, 7, 5, 4, 8, 1});
        nextPermutation(new int[]{1, 6, 7, 5, 4, 5, 6});
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int standardIdx = nums.length - 2;
        while (standardIdx >= 0 && nums[standardIdx] >= nums[standardIdx + 1]) {
            standardIdx--;
        }
        if (standardIdx >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[standardIdx]) {
                j--;
            }
            swap(nums, standardIdx, j);
        }
        reverse(nums, standardIdx + 1, nums.length - 1);

        for (int num : nums) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void swap(int[] nums, int start, int change) {
        int temp = nums[start];
        nums[start] = nums[change];
        nums[change] = temp;
    }

    public static void reverse(int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }
}
