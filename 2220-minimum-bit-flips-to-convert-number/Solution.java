public class Solution {
    public int minBitFlips(int start, int goal) {
        int xorResult = start ^ goal;
        int bitFlips = 0;
        
        while (xorResult != 0) {
            bitFlips += xorResult & 1;            
            xorResult >>= 1;
        }
        
        return bitFlips;
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        
        // Example 1
        int start = 10; // 1010
        int goal = 7; // 0111
        System.out.println(solution.minBitFlips(start, goal)); // 3
        
        // Example 2
        start = 7; // 0111
        goal = 7; // 0111
        System.out.println(solution.minBitFlips(start, goal)); // 0
        
        // Example 3
        start = 0; // 0
        goal = 15; // 1111
        System.out.println(solution.minBitFlips(start, goal)); // 4
    }
}
