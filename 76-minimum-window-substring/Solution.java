import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            targetMap.put(ch, targetMap.getOrDefault(ch, 0) + 1);
        }

        int requiredChars = targetMap.size();
        int left = 0, right = 0;
        int formedChars = 0;

        HashMap<Character, Integer> windowMap = new HashMap<>();
        int[] result = {-1, 0, 0}; // length, left, right

        while (right < s.length()) {
            char rightChar = s.charAt(right);

            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0) + 1);

            if (targetMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() == targetMap.get(rightChar).intValue()) {
                formedChars++;
            }

            while (formedChars == requiredChars) {
                int currentLength = right - left + 1;
                if (result[0] == -1 || currentLength < result[0]) {
                    result[0] = currentLength;
                    result[1] = left;
                    result[2] = right + 1;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formedChars--;
                }

                left++;
            }

            right++;
        }

        return result[0] == -1 ? "" : s.substring(result[1], result[2]);
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = solution.minWindow(s, t);
        System.out.println(result); // "BANC"
    }
}
