public class Solution {
    public static int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        
        return maxDepth;
    }

    public static void main(String[] args) {
        String s1 = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s1)); // 3
        
        String s2 = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s2)); // 3
        
        String s3 = "1+(2*3)/(2-1)";
        System.out.println(maxDepth(s3)); // 1
    }
}
