import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeetCode_SameTree {
    public static void main(String[] args) throws IOException {
        /**
         * description  : LeetCode Same Tree
         *               두 개의 트리를 주고 같은 트리인지 확인하는 문제
         * solution     : 1. 트리가 둘 다 null 인 경우는 true
         *                2. p 트리가 null 이고 q null 이 아닐 경우, p 트리가 null 이 아니고, q 트리가 null 인 경우 false
         *                3. p,q 의 val 이 다를 경우 false
         *                4. 그렇지 않을 경우 Tree Traversal
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
        TreeNode treeNode1_1_p = new TreeNode(1);
        TreeNode treeNode1_2_p = new TreeNode(2);
        TreeNode treeNode1_3_p = new TreeNode(3);

        treeNode1_1_p.left = treeNode1_2_p;
        treeNode1_2_p.right = treeNode1_3_p;

        TreeNode treeNode1_1_q = new TreeNode(1);
        TreeNode treeNode1_2_q = new TreeNode(2);
        TreeNode treeNode1_3_q = new TreeNode(3);

        treeNode1_1_q.left = treeNode1_2_q;
        treeNode1_2_q.right = treeNode1_3_q;

        System.out.println(isSameTree(treeNode1_1_p, treeNode1_1_q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if((p == null && q != null) || (p != null && q == null))
            return false;
        else if(p.val != q.val)
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }
}
