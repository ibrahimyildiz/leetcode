public class Solution {
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (sb.length() > 0 && Math.abs(sb.charAt(sb.length() - 1) - current) == 32) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(current);
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "leEeetcode";
        System.out.println(makeGood(s1)); // leetcode
        
        String s2 = "abBAcC";
        System.out.println(makeGood(s2)); // ""
        
        String s3 = "s";
        System.out.println(makeGood(s3)); // s
    }
}
