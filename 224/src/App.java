import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.calculate("1 + 1"));
    }
}
class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>(); // Stack to store results and signs
        int num = 0; // Current number
        int ans = 0; // Current result
        int sign = 1; // Current sign, 1 for '+' and -1 for '-'
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = 10 * num + (ch - '0'); // Accumulate the digit into num
            } else if (ch == '+') {
                ans += num * sign; // Compute current result
                sign = 1; // Update sign for next number
                num = 0; // Reset number
            } else if (ch == '-') {
                ans += num * sign;
                sign = -1;
                num = 0;
            } else if (ch == '(') {
                st.push(ans); // Save current result
                st.push(sign); // Save current sign
                ans = 0; // Reset result for sub-expression
                sign = 1; // Reset sign for sub-expression
            } else if (ch == ')') {
                ans += num * sign; // Add the last number in the sub-expression
                num = 0;
                ans *= st.pop(); // Multiply by the sign before parenthesis
                ans += st.pop(); // Add to the result before parenthesis
            }
        }
        ans += num * sign; // Add the last number (if any) to the result
        return ans;
    }
}