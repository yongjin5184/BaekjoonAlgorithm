package Leetcode;

public class BinarySearch {
    public static int search(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }

    private static int binarySearch(int[] A, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (target == A[mid]) {
            return mid;
        } else if (target < A[mid]) {
            return binarySearch(A, start, mid - 1, target);
        } else {
            return binarySearch(A, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        System.out.println("arr = " + search(arr1, target1));

        int[] arr2 = {-1, 0, 3, 5, 9};
        int target2 = 2;

        System.out.println("arr = " + search(arr2, target2));
    }
}
