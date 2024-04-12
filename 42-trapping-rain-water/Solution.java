class Solution {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int n = height.length;
        int left = 0, right = n - 1;
        int maxLeft = height[left], maxRight = height[right];
        int waterTrapped = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left]);
                waterTrapped += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                waterTrapped += maxRight - height[right];
                right--;
            }
        }
        
        return waterTrapped;
    }
    
    // Example usage
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height)); // Output: 6
    }
}