import java.util.Arrays;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int numsLen = nums.length;
        int[][] result = new int[numsLen/3][3];

        if (numsLen % 3 != 0) {
            return new int[][]{};
        }

        Arrays.sort(nums);

        for (int i = 0; i < numsLen - 2; i = i + 3) {
            if (nums[i+2] - nums[i] > k) {
                return new int[][]{};
            }
        }

        int key = 0;
        for (int i = 0; i < numsLen/3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = nums[key];
                key++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        int[] nums1 = {1,3,4,8,7,9,3,5,1}; 
        int k1 = 2;
        int[] nums2 = {1,3,3,2,7,3};
        int k2 = 3;
        int[][] result1 = solution.divideArray(nums1, k1);
        int[][] result2 = solution.divideArray(nums2, k2);
        System.out.println(Arrays.deepToString(result1)); // [[1,1,3],[3,4,5],[7,8,9]]
        System.out.println(Arrays.deepToString(result2)); // []
    }
}