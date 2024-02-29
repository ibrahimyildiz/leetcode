import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int prevValue = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if ((level % 2 == 0 && (current.val % 2 == 0 || current.val <= prevValue)) ||
                    (level % 2 == 1 && (current.val % 2 == 1 || current.val >= prevValue))) {
                    return false;
                }

                prevValue = current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            level++;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(9);

        boolean result = solution.isEvenOddTree(root);

        System.out.println(result); // true
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