class Solution {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
              if (word.equals(new StringBuilder(word).reverse().toString())) {
                return word;
              }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abc","car","ada","racecar","cool"};
        String result = solution.firstPalindrome(words);
        System.out.println(result); // "ada"
    }
}