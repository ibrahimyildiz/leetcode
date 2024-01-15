from collections import Counter
from typing import List

class Solution:
    def minOperations(self, nums: List[int]) -> int:
        res = 0
        counts = Counter(nums)
        for count in counts.values():
            if count == 1:
                return -1
            res += count // 3 + (1 if count % 3 else 0)
        return res 

# Example usage:
solution = Solution()    
nums1 = [2, 3, 3, 2, 2, 4, 2, 3, 4]
result1 = solution.minOperations(nums1)
print(result1) # Output: 4

nums2 = [2, 1, 2, 2, 3, 3]
result2 = solution.minOperations(nums2)
print(result2) # Output: -1