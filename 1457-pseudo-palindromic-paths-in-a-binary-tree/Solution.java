public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        // Array to track digit frequencies
        int[] count = new int[10];

        return countPaths(root, count);
    }

    private int countPaths(TreeNode node, int[] count) {
        if (node == null) {
            return 0;
        }

        // Update digit frequency for the current node
        count[node.val]++;

        // Check for pseudo-palindromic path conditions
        int paths = 0;
        if (node.left == null && node.right == null) {
            // Leaf node: Check if it forms a pseudo-palindrome
            int oddCount = 0;

            for (int c : count) {
                oddCount += c % 2;
            }

            // Pseudo-palindrome if at most one odd frequency
            paths = oddCount <= 1 ? 1 : 0;
        } else {
            // Recursively count paths in subtrees
            paths += countPaths(node.left, count) + countPaths(node.right, count);
        }

        // Decrement digit frequency for backtracking
        count[node.val]--;

        return paths;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        Solution solution = new Solution();
        int result = solution.pseudoPalindromicPaths(root);
        System.out.println(result);  // Output: 2
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}