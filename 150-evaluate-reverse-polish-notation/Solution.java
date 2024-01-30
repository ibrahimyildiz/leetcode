import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int token2 = Integer.parseInt(stack.pop());
                int token1 = Integer.parseInt(stack.pop());
                int result = 0;
                
                switch (token) {
                    case "+":
                        result = token1 + token2;
                        break;
                    case "-":
                        result = token1 - token2;
                        break;
                    case "*":
                        result = token1 * token2;
                        break;
                    case "/":
                        result = token1 / token2;
                        break;
                    default:
                        break;
                }
                
                stack.push(Integer.toString(result));
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        // Example Usage:
        // String[] tokens = {"2","1","+","3","*"};
        String[] tokens =  {"4","13","5","/","+"};
        Solution solution = new Solution();
        int result = solution.evalRPN(tokens);
        System.out.println(result); // 9
    }
}