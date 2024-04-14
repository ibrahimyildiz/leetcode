class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        def dfs(node, is_left):
            if not node:
                return 0
            if not node.left and not node.right and is_left:
                return node.val
            left_sum = dfs(node.left, True)
            right_sum = dfs(node.right, False)
            return left_sum + right_sum
        
        return dfs(root, False)

# Example usage:
solution = Solution()
root = TreeNode(3)
root.left = TreeNode(9)
root.right = TreeNode(20)
root.right.left = TreeNode(15)
root.right.right = TreeNode(7)

print(solution.sumOfLeftLeaves(root))  # Output: 24
