class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    int maxDiff = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root, root.val, root.val);
        return maxDiff;
    }

    private void dfs(TreeNode node, int minVal, int maxVal) {
        if (node == null) {
            return;
        }

        // Update the maximum difference using the current node's value
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(node.val - minVal), Math.abs(node.val - maxVal)));

        // Update min and max values for the current path
        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);

        // Recursively explore left and right subtrees
        dfs(node.left, minVal, maxVal);
        dfs(node.right, minVal, maxVal);
    }

    public static void main(String[] args) {
        // Example usage:
        // Constructing the binary tree
        //        8
        //       / \
        //      3   10
        //     / \    \
        //    1   6    14
        //       / \   /
        //      4   7  13
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);

        Solution solution = new Solution();
        int result = solution.maxAncestorDiff(root);
        System.out.println(result); // Output: 13
    }
}
