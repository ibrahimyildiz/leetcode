import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }

        // Initialize an array to store the minimum number of perfect squares needed for each value
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // The number of perfect squares needed for 0 is 0
        dp[0] = 0;

        // Iterate through each value from 1 to n
        for (int i = 1; i <= n; i++) {
            // Iterate through perfect squares less than or equal to i
            for (int j = 1; j * j <= i; j++) {
                // Update the minimum number of perfect squares needed for the current value
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        int n = 14;
        int result = solution.numSquares(n);
        System.out.println(result); // 3 => [1, 4, 9]
    }
}