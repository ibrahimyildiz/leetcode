class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root, false);
    }
    
    private int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }

        int leftSum = sumOfLeftLeaves(node.left, true);
        int rightSum = sumOfLeftLeaves(node.right, false);
        return leftSum + rightSum;
    }
    
    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solution.sumOfLeftLeaves(root)); // Output: 24
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
