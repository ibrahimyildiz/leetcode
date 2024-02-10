class Solution {
    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public int countSubstrings(String s) {
        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(isPalindrome(s, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Example usage:
        Solution solution = new Solution();
        String s = "abc";
        int result = solution.countSubstrings(s);
        System.out.println(result); // 3, Three palindromic strings: "a", "b", "c".
    }
}