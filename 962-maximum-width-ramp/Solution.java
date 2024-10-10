import java.util.*;

public class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        
        Integer[] indices = new Integer[n];
        
        for(int i=0; i<n; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (a,b) -> Integer.compare(nums[a], nums[b])); 
        
        int minIndex = n;
        int maxWidth = 0;
        
        for(int i: indices) {
            maxWidth = Math.max(maxWidth, i-minIndex);
            minIndex = Math.min(minIndex, i);
        }
        
        return maxWidth;
    }
    
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        
        int[] nums1 = {6, 0, 8, 2, 1, 5};
        int[] nums2 = {9, 8, 1, 0, 1, 9, 4, 0, 4, 1};
        
        System.out.println(solution.maxWidthRamp(nums1)); // 4
        System.out.println(solution.maxWidthRamp(nums2)); // 7
    }
}