from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        n = len(height)
        left, right = 0, n - 1
        max_left, max_right = height[left], height[right]
        water_trapped = 0
        
        while left < right:
            if height[left] < height[right]:
                max_left = max(max_left, height[left])
                water_trapped += max_left - height[left]
                left += 1
            else:
                max_right = max(max_right, height[right])
                water_trapped += max_right - height[right]
                right -= 1
        
        return water_trapped

# Example usage
solution = Solution()
height = [0,1,0,2,1,0,1,3,2,1,2,1]
print(solution.trap(height))  # Output: 6
