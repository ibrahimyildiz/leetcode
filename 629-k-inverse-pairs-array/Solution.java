public class Solution {
    private static final int MOD = 1000000007;

    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    for (int l = 0; l <= Math.min(j, i - 1); l++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                    }
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        // Example Usage:
        Solution solution = new Solution();
        int n = 3, k = 1;
        int result = solution.kInversePairs(n, k);
        System.out.println(result);  // Output: 2
    }
}
