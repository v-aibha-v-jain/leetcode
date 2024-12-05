import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens));
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                if(tokens[i].equals("+")) {
                    int x = stack.pop(); // pop the top element
                    int y = stack.pop(); // pop the next element
                    stack.push(x + y); // push the result of addition
                }
                if(tokens[i].equals("-")) {
                    int x = stack.pop(); // pop the top element
                    int y = stack.pop(); // pop the next element
                    stack.push(y - x); // push the result of subtraction
                }
                if(tokens[i].equals("/")) {
                    int x = stack.pop(); // pop the top element
                    int y = stack.pop(); // pop the next element
                    stack.push(y / x); // push the result of division
                }
                if(tokens[i].equals("*")) {
                    int x = stack.pop(); // pop the top element
                    int y = stack.pop(); // pop the next element
                    stack.push(x * y); // push the result of multiplication
                }
            } else {
                stack.push(Integer.parseInt(tokens[i])); // push the number onto the stack
            }
        }
        return stack.pop(); // return the final result
    }
}