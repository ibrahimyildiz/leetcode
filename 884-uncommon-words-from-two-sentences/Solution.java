import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> wordCounts = new HashMap<>();
         
        for(String word : s1.split(" ")) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
        
        for(String word : s2.split(" ")) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) +1);
        }
        
        List<String> uniqueWords = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if(entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }
        
        return uniqueWords.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();

        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        
        System.out.println(Arrays.toString(solution.uncommonFromSentences(s1, s2))); // [sweet, sour]
    }
}