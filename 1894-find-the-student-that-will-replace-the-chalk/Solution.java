class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        for (int amount : chalk) {
            totalChalk += amount;
        }
        
        k %= totalChalk;
        
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        
        int[] chalk = {5, 1, 5};
        int k = 27;
        
        int result = solution.chalkReplacer(chalk, k);
        
        System.out.println(result); // 1
    }
}
