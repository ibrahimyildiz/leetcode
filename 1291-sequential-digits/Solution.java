import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int num = i;
            int next = i + 1;

            while (num <= high && next <= 9) {
                num = num * 10 + next;
                if (low <= num && num <= high) {
                    result.add(num); 
                } 
                next++;
            }
        }

        result.sort(null);
        return result;
    }
    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        List<Integer> result = solution.sequentialDigits(1000, 13000);
        System.out.println(result); // [1234, 2345, 3456, 4567, 5678, 6789, 12345]
    }
}