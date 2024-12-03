import java.util.Stack; 

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String path = "/a/./b/../../c/";
        String result = solution.simplifyPath(path);
        System.out.println("Result: " + result);
    }
}
class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/"); // Split the path by "/"
        Stack<String> stack = new Stack<>(); // Initialize a stack to store the path components
        for(String token : tokens) {
            if(token.isEmpty() || token.equals(".")) { // Ignore empty tokens and "."
                continue;
            }
            else if(token.equals("..")) { // If token is "..", pop from stack if it's not empty
                if(!stack.empty()) {
                    stack.pop();
                }
            }
            else { // Push the token to the stack
                stack.push(token);
            }
        }
        StringBuilder sb = new StringBuilder(); // Initialize a StringBuilder to build the result path
        for(String pathName : stack) {
            sb.append("/").append(pathName); // Append each path component with "/"
        }
        return sb.length() > 0 ? sb.toString(): "/"; // Return the simplified path or "/" if empty
    }
}