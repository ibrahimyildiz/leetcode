class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxInPartition = 0;

            for (int j = 1; j <= k && i - j >= 0; j++) {
                maxInPartition = Math.max(maxInPartition, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + maxInPartition * j);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        int[] arr1 = {1,15,7,9,2,5,10};
        int k1 = 3;

        int[] arr2 = {1,4,1,5,7,3,6,1,9,9,3}; 
        int k2 = 4;
        
        int result1 = solution.maxSumAfterPartitioning(arr1, k1); // 84
        System.out.println(result1);
        int result2 = solution.maxSumAfterPartitioning(arr2, k2); // 83
        System.out.println(result2);
    }
}