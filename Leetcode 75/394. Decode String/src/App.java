import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "3[a]2[bc]";
        System.out.println(solution.decodeString(s));
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>(); // Stack to store characters
        for (char c : s.toCharArray()) { // Iterate through each character in the string
            if (c != ']') stack.push(c); // Push character to stack until ']' is encountered
            else {
                StringBuilder sb = new StringBuilder(); // To store the substring inside brackets
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) // Collect letters
                    sb.insert(0, stack.pop()); // Build the substring
                String sub = sb.toString(); // Store the substring
                stack.pop(); // Remove the '[' from the stack
                sb = new StringBuilder(); // To store the number before the brackets
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) // Collect digits
                    sb.insert(0, stack.pop()); // Build the number
                int count = Integer.valueOf(sb.toString()); // Convert the number to an integer
                while (count > 0) { // Repeat the substring 'count' times
                    for (char ch : sub.toCharArray())  
                        stack.push(ch); // Push the repeated substring back to the stack
                    count--; // Decrease the count
                }
            }
        }
        StringBuilder retv = new StringBuilder(); // To store the final decoded string
        while (!stack.isEmpty()) // Collect all characters from the stack
            retv.insert(0, stack.pop()); // Build the final string

        return retv.toString(); // Return the decoded string
    }
}