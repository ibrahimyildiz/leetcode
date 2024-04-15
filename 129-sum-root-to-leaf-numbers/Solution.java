class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) {
            return 0;
        }
        current = current * 10 + node.val;

        if (node.left == null && node.right == null) {
            return current;
        }

        int leftSum = dfs(node.left, current);
        int rightSum = dfs(node.right, current);

        return leftSum + rightSum;
    }

    // Example usage:
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution solution = new Solution();
        System.out.println(solution.sumNumbers(root)); // Output: 25
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
