import java.util.Stack;

public class Solution {
    public static boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            if (leftStack.pop() > starStack.pop()) {
                return false;
            }
        }

        return leftStack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println(checkValidString(s1)); // true

        String s2 = "(*)";
        System.out.println(checkValidString(s2)); // true

        String s3 = "(*))";
        System.out.println(checkValidString(s3)); // true
    }
}
