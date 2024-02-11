public class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    int cherries = grid[i][j1] + (j1 != j2 ? grid[i][j2] : 0);

                    if (i != rows - 1) {
                        int maxNext = 0;
                        for (int nextJ1 = j1 - 1; nextJ1 <= j1 + 1; nextJ1++) {
                            for (int nextJ2 = j2 - 1; nextJ2 <= j2 + 1; nextJ2++) {
                                if (nextJ1 >= 0 && nextJ1 < cols && nextJ2 >= 0 && nextJ2 < cols) {
                                    maxNext = Math.max(maxNext, dp[i + 1][nextJ1][nextJ2]);
                                }
                            }
                        }
                        cherries += maxNext;
                    }

                    dp[i][j1][j2] = cherries;
                }
            }
        }

        return dp[0][0][cols - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        int result = solution.cherryPickup(grid);
        System.out.println("Maximum cherries collected: " + result); // 24
    }
}
