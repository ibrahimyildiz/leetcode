class TreeNode {
    constructor(val, left = null, right = null) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

function maxAncestorDiff(root) {
    if (!root) {
        return 0;
    }

    let maxDiff = 0;

    function dfs(node, minVal, maxVal) {
        if (!node) {
            return;
        }

        // Update the maximum difference using the current node's value
        maxDiff = Math.max(maxDiff, Math.abs(node.val - minVal), Math.abs(node.val - maxVal));

        // Update min and max values for the current path
        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);

        console.log("---");
        console.log(node.val);
        console.log(minVal);
        console.log(maxVal);
        console.log("---");

        // Recursively explore left and right subtrees
        dfs(node.left, minVal, maxVal);
        dfs(node.right, minVal, maxVal);
    }

    // Start DFS from the root with initial min and max values
    dfs(root, root.val, root.val);

    return maxDiff;
}

// Example usage:
// Constructing the binary tree
//        8
//       / \
//      3   10
//     / \    \
//    1   6    14
//       / \   /
//      4   7  13
const root = new TreeNode(8,
    new TreeNode(3,
        new TreeNode(1),
        new TreeNode(6, new TreeNode(4), new TreeNode(7))
    ),
    new TreeNode(10, null, new TreeNode(14, new TreeNode(13)))
);

const result = maxAncestorDiff(root);
console.log(result); // Output: 13
