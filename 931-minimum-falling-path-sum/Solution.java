public class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][Math.max(0, j - 1)], matrix[i - 1][Math.min(n - 1, j + 1)]));
            }
        }

        int minSum = Integer.MAX_VALUE;
        for (int num : matrix[n - 1]) {
            minSum = Math.min(minSum, num);
        }

        return minSum;
    }

    public static void main(String[] args) {
        // Example Usage:
        int[][] matrix = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };

        System.out.println(minFallingPathSum(matrix)); // Output: 13
    }
}
