import java.util.Arrays;

class Solution {
    public static int[] sortedSquares(int[] nums) {
        int numsLength = nums.length;
        int[] result = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        System.out.println(Arrays.toString(result)); // [0,1,9,16,100]
    }
}