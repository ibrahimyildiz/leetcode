public class Solution {
    private static final int MOD = 1000000007;
    private static final int[] directions = {-1, 0, 1, 0, -1};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;

        int result = 0;

        for (int moves = 1; moves <= maxMove; moves++) {
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    for (int i = 0; i < 4; i++) {
                        int newRow = row + directions[i];
                        int newCol = col + directions[i + 1];

                        if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                            // Ball is out of boundary, add the count to the result
                            result = (result + dp[moves - 1][row][col]) % MOD;
                        } else {
                            dp[moves][newRow][newCol] = (dp[moves][newRow][newCol] + dp[moves - 1][row][col]) % MOD;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example Usage
        Solution solution = new Solution();
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
        int result = solution.findPaths(m, n, maxMove, startRow, startColumn);
        System.out.println(result);  // Output: 6
    }
}
