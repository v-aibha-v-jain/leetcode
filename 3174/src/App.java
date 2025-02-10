public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "cb34";
        String res = solution.clearDigits(s);
        System.out.println(res);
    }
}
class Solution {
    public String clearDigits(String s) {
        StringBuilder res = new StringBuilder(); // Initialize a StringBuilder to store the result
        for (char c : s.toCharArray()) { // Iterate over each character in the input string
            if (Character.isDigit(c)) { // Check if the character is a digit
                if (res.length() > 0) { // If the result is not empty
                    res.deleteCharAt(res.length() - 1); // Remove the last character from the result
                }
            } else { // If the character is not a digit
            res.append(c); // Append the character to the result
            }
        }
        return res.toString(); // Return the final result as a string
    }
}