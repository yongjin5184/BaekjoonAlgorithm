public class LeetCode_ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        /**
         * description  : LeetCode Convert Sorted Array to Binary Search Tree
         *                Sorted Array 를 Binary search Tree 로 변경하는 문제
         * solution     : leetcode disscuss 참고
         */

        int[] arr = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(arr).toString());
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int startIndex = 0;
        int endIndex = nums.length - 1;

        TreeNode root = createNode(nums, startIndex, endIndex);
        addNode(root, nums, startIndex, endIndex);

        return root;
    }

    private static void addNode(TreeNode root, int[] nums, int startIndex, int endIndex) {
        if (root != null) {
            int median = (startIndex + endIndex) / 2;

            root.left = createNode(nums, startIndex, median - 1);
            root.right = createNode(nums,  median + 1, endIndex);

            addNode(root.left, nums, startIndex, median - 1);
            addNode(root.right, nums, median + 1, endIndex);
        }
    }

    private static TreeNode createNode(int[] nums, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        return new TreeNode(nums[(startIndex + endIndex) / 2]);
    }
}
