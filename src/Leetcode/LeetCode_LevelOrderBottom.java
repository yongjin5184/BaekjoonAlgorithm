import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_LevelOrderBottom {
    public static void main(String[] args) {
        /**
         * description  : LeetCode Level Order Bottom
         *                이진 트리의 bottom 부터 순회하는 문제
         * solution     : 1. Queue 를 만들고, queue 에 TreeNode 의 root 를 넣는다.
         *                2. Queue 가 empty 일 동안 순회를 한다.
         *                3. Queue 에 TreeNode 의 right, left node 가 있으면 queue 에 다시 넣는다.
         *                4. 결과 list 에는 TreeNode 의 value 를 담는다.
         *                5. 결과 list 를 reverse 한 뒤, return 한다.
         */
        TreeNode treeNode1_1_p = new TreeNode(3);
        TreeNode treeNode1_2_p = new TreeNode(9);
        TreeNode treeNode1_3_p = new TreeNode(20);
        TreeNode treeNode1_4_p = new TreeNode(15);
        TreeNode treeNode1_5_p = new TreeNode(7);

        treeNode1_1_p.left = treeNode1_2_p;
        treeNode1_1_p.right = treeNode1_3_p;
        treeNode1_2_p.left = treeNode1_4_p;
        treeNode1_2_p.right = treeNode1_5_p;

        System.out.println(levelOrderBottom(treeNode1_1_p));
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()) {
            result.add(new ArrayList<>());

            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                result.get(level).add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }

                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        Collections.reverse(result);
        return result;
    }
}
