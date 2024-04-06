import java.util.Stack;

public class Solution {
    public static String minRemoveToMakeValid(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(result.length());
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    continue;
                }
            }
            result.append(ch);
        }

        while (!stack.isEmpty()) {
            result.deleteCharAt(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s1)); // lee(t(c)o)de

        String s2 = "a)b(c)d";
        System.out.println(minRemoveToMakeValid(s2)); // ab(c)d

        String s3 = "))((";
        System.out.println(minRemoveToMakeValid(s3)); // ""

        String s4 = "(a(b(c)d)";
        System.out.println(minRemoveToMakeValid(s4)); // a(b(c)d)
    }
}
