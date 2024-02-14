import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> positiveNums = new ArrayList<>();
        List<Integer> negativeNums = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int positiveIndex = 0;
        int negativeIndex = 0;

        for (int num : nums) {
            if(num > 0) {
                positiveNums.add(num);
            } else {
                negativeNums.add(num);
            }
        }

        while(positiveIndex<positiveNums.size() && negativeIndex < negativeNums.size()) {
            result.add(positiveNums.get(positiveIndex));
            positiveIndex++;
            result.add(negativeNums.get(negativeIndex));
            negativeIndex++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,1,-2,-5,2,-4};
        int[] result = {};
        result = solution.rearrangeArray(nums);
        System.out.println(result); // [3,-2,1,-5,2,-4]
    }
}