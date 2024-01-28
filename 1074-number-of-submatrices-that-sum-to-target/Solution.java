import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int count = 0;

        // Prefix sums for each row
        int[][] prefixSum = new int[rows][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
            }
        }

        // Iterate through all possible top-left corners
        for (int top = 0; top < rows; top++) {
            for (int bottom = top; bottom < rows; bottom++) {
                Map<Integer, Integer> rightSumCount = new HashMap<>();
                rightSumCount.put(0, 1); // Base case: empty submatrix

                for (int right = 0; right < cols; right++) {
                    // Calculate running sum for the current submatrix
                    int currentSum = 0;
                    for (int i = top; i <= bottom; i++) {
                        currentSum += prefixSum[i][right + 1] - prefixSum[i][0];
                    }

                    // Check if a previous submatrix with the required complement exists
                    int complement = currentSum - target;
                    count += rightSumCount.getOrDefault(complement, 0);

                    // Update the count for the current sum
                    rightSumCount.put(currentSum, rightSumCount.getOrDefault(currentSum, 0) + 1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,-1}, {-1, 1}};
        int target = 0;
        int result = solution.numSubmatrixSumTarget(matrix, target);
        System.out.println(result);  // Output: 5
    }
}