import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (n + m);
        
        int knownSum = 0;
        for (int roll : rolls) {
            knownSum += roll;
        }
        
        int missingSum = totalSum - knownSum;
        
        if (missingSum < n || missingSum > 6 * n) {
            return new int[0]; 
        }
        
        int[] result = new int[n];
        Arrays.fill(result, missingSum / n);
        int remainder = missingSum % n;
        
        for (int i = 0; i < remainder; i++) {
            result[i]++;
        }
        
        return result;
    }
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        
        int[] rolls = {3, 2, 4, 3};
        int mean = 4;
        int n = 2;
        
        int[] result = solution.missingRolls(rolls, mean, n);
        System.out.println(Arrays.toString(result));  // [6, 6]
    }
}
