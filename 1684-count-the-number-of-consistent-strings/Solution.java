import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }
        
        int consistentCount = 0;
        for (String word : words) {
            if (isConsistent(word, allowedSet)) {
                consistentCount++;
            }
        }
        
        return consistentCount;
    }

    private boolean isConsistent(String word, Set<Character> allowedSet) {
        for (char c : word.toCharArray()) {
            if (!allowedSet.contains(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String allowed = "abc";
        String[] words = {"a", "b", "c", "ab", "ac", "bc", "abc", "abcd"};
        
        int result = solution.countConsistentStrings(allowed, words);
        System.out.println(result);
    }
}
