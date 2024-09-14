public class Solution {
    public int longestSubarray(int[] nums) {
        int maxValue = nums[0];
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }

        int longest = 0, currentLength = 0;
        for (int num : nums) {
            if (num == maxValue) {
                currentLength++;
            } else {
                currentLength = 0;
            }
            longest = Math.max(longest, currentLength);
        }

        return longest;
    }
    
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        
        // Example 1
        int[] nums1 = {1, 2, 3, 3, 2, 2, 3, 3};
        System.out.println(solution.longestSubarray(nums1));  // 2
        
        // Example 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(solution.longestSubarray(nums2));  // 1
        
        // Example 3
        int[] nums3 = {4, 4, 4, 4};
        System.out.println(solution.longestSubarray(nums3));  // 4
    }
}
