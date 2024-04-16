import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (currentDepth == depth - 1) {
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);

                    left.left = node.left;
                    right.right = node.right;
                    node.left = left;
                    node.right = right;
                } else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            currentDepth++;

            if (currentDepth == depth) {
                break;
            }
        }

        return root;
    }

    // Example usage:
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        Solution solution = new Solution();

        TreeNode newRoot = solution.addOneRow(root, 1, 2);

        System.out.println("New root value: " + newRoot.val); // Output: 4
        System.out.println("New left child value: " + newRoot.left.val); // Output: 1
        System.out.println("New right child value: " + newRoot.right.val); // Output: 1
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
