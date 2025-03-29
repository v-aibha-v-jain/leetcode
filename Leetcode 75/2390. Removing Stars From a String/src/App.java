public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution(); // Create an instance of the Solution class
        String s = "leet**cod*e"; // Example input string
        String result = solution.removeStars(s); // Call the removeStars method with the input string
        System.out.println(result); // Print the result
    }
}
class Solution {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder(); // StringBuilder to store the result
        for (char c : s.toCharArray()) // Iterate through each character in the string
            if (c == '*') ans.setLength(ans.length() - 1); // Remove the last character if '*' is encountered
            else ans.append(c); // Append the character if it's not '*'
        return ans.toString(); // Convert StringBuilder to String and return
    }
}