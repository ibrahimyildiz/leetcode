class Solution:
    def climbStairs(self, n: int) -> int:
        if n <= 2:
            return n

        step_one, step_two = 1, 1

        for i in range(n-1):
            temp =   step_one
            step_one = step_one + step_two
            step_two = temp
        
        return step_one

# Example usage:
n = 5
solution = Solution()
print(solution.climbStairs(n))  # Output: 8