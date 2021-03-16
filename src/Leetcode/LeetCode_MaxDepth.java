package Leetcode;

public class LeetCode_MaxDepth {

    public static void main(String[] args) {
        /**
         * description  : LeetCode Max Depth
         *               이진 트리의 가장 깊은 Depth 찾기
         * solution     : 1. root 가 null 이면 return 0
         *                2. root 의 left 와 root 의 right 가 null 이면 return 1
         *                3. 그렇지 않은 경우 left 와 right 를 모두 순회하면서 max depth + 1 를 하여 return
         */
        TreeNode treeNode1_1 = new TreeNode(3);
        TreeNode treeNode1_2 = new TreeNode(9);
        TreeNode treeNode1_3 = new TreeNode(20);
        TreeNode treeNode1_4 = new TreeNode(15);
        TreeNode treeNode1_5 = new TreeNode(7);
        TreeNode treeNode1_6 = new TreeNode(8);

        treeNode1_1.left = treeNode1_2;
        treeNode1_1.right = treeNode1_3;
        treeNode1_3.left = treeNode1_4;
        treeNode1_3.right = treeNode1_5;
        treeNode1_5.right = treeNode1_6;

        System.out.println(maxDepth(treeNode1_1));
    }

    private static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else if (root.left == null && root.right == null){
            return 1;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
