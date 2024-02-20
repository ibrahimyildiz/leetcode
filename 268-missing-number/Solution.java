import java.util.Arrays;

class Solution {
    public int missingNumber(int[] nums) {
        int numsLength = nums.length;
        int total = numsLength*(numsLength+1)/2;
        int numsTotal = Arrays.stream(nums).sum();
        return total - numsTotal;
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        int[] nums = {3,0,1};
        int result = solution.missingNumber(nums);
        System.out.println(result); // 2
    }
}