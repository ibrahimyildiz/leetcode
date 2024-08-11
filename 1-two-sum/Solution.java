import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer mapIndex = map.get(nums[i]);
            
            if(mapIndex != null) {
                return new int[]{i, mapIndex};
            }
            
            map.put(target-nums[i], i);
        }
        
        return nums;
    }
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = solution.twoSum(nums, target);
        
        System.out.println(result[0] + ", " + result[1]); // 1, 0
    }
}