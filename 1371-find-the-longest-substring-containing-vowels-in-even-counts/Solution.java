import java.util.HashMap;

public class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, -1);
        
        int maxLength = 0;
        int state = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'a') {
                state ^= (1 << 0);  // 0. bit -> 'a'
            } else if (c == 'e') {
                state ^= (1 << 1);  // 1. bit -> 'e'
            } else if (c == 'i') {
                state ^= (1 << 2);  // 2. bit -> 'i'
            } else if (c == 'o') {
                state ^= (1 << 3);  // 3. bit -> 'o'
            } else if (c == 'u') {
                state ^= (1 << 4);  // 4. bit -> 'u'
            }
            
            if (stateMap.containsKey(state)) {
                maxLength = Math.max(maxLength, i - stateMap.get(state));
            } else {
                stateMap.put(state, i);
            }
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        
        System.out.println(solution.findTheLongestSubstring("eleetminicoworoep")); // 13
        System.out.println(solution.findTheLongestSubstring("leetcodeisgreat")); // 5
        System.out.println(solution.findTheLongestSubstring("bcbcbc")); // 6
    }
}
