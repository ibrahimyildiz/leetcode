import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int findLeftmostValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftmostValue = -1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (i == 0) {
                    leftmostValue = current.val;
                }

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return leftmostValue;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        int result = solution.findLeftmostValue(root);

        System.out.println(result); // 4
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}