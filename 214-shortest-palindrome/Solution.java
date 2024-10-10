public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        
        String reverse = new StringBuilder(s).reverse().toString();
        String newString = s + "#" + reverse;
        
        int[] lps = computeLPS(newString);
        int palindromeLength = lps[newString.length() - 1];
        String nonPalindromePart = s.substring(palindromeLength);
        return new StringBuilder(nonPalindromePart).reverse().toString() + s;
    }
    
    private int[] computeLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int length = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        
        String s1 = "aacecaaa";
        String s2 = "abcd";
        
        System.out.println(solution.shortestPalindrome(s1)); // "aaacecaaa"
        System.out.println(solution.shortestPalindrome(s2)); // "dcbabcd"
    }
}