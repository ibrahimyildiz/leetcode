import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public static int[] findErrorNums(int[] nums) {
        int length = nums.length;

        HashSet<Integer> set = new HashSet<>();
        
        int rep = 0;
        int loss = 0;

        for (int num : nums) {
            if(!set.add(num)) {
                rep = num;
            }
        }

        for (int i = 1; i<=length; i++) {
            if(!set.contains(i)) {
                loss = i;
                break;
            }
        }

        return new int[]{rep, loss};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(findErrorNums(nums))); // Output: [2, 3]
    }
}