import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_SymmetricTree {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Same Tree
         *                이진 트리가 대칭되어있는지 확인하는 문제
         * solution     : 1. Tree 가 각각 왼쪽/오른쪽 부터 순회하도록 만든 후, 값이 같다면 true 를 출력한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        TreeNode treeNode1_1_p = new TreeNode(1);
        TreeNode treeNode1_2_p = new TreeNode(2);
        TreeNode treeNode1_3_p = new TreeNode(2);
        TreeNode treeNode1_4_p = new TreeNode(3);
        TreeNode treeNode1_5_p = new TreeNode(4);
        TreeNode treeNode1_6_p = new TreeNode(4);
        TreeNode treeNode1_7_p = new TreeNode(3);

        treeNode1_1_p.left = treeNode1_2_p;
        treeNode1_1_p.right = treeNode1_3_p;
        treeNode1_2_p.left = treeNode1_4_p;
        treeNode1_2_p.right = treeNode1_5_p;
        treeNode1_3_p.left = treeNode1_6_p;
        treeNode1_3_p.right = treeNode1_7_p;

        System.out.println(isSymmetric(treeNode1_1_p));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }
    }
}
