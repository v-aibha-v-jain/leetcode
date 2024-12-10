import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "abcaba";
        int result = solution.maximumLength(s);
        System.out.println(result);
    }
}
class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> strimap = new HashMap<>(); // Map to store substrings and their counts
        int maxLength = -1; // Initialize maxLength to -1
        for (int i = 0; i < s.length(); i++) { // Iterate over each character in the string
            char currentChar = s.charAt(i); // Get the current character
            StringBuilder specialSubstring = new StringBuilder(); // Initialize a new StringBuilder for the substring
            for (int j = i; j < s.length(); j++) { // Iterate from the current character to the end of the string
                if (s.charAt(j) == currentChar) { // Check if the character matches the current character
                    specialSubstring.append(currentChar); // Append the current character to the substring
                    String substring = specialSubstring.toString(); // Convert StringBuilder to String
                    strimap.put(substring, strimap.getOrDefault(substring, 0) + 1); // Update the count of the substring in the map
                } else {
                    break; // Break the loop if the character does not match
                }
            }
        }
        for (Map.Entry<String, Integer> entry : strimap.entrySet()) { // Iterate over the entries in the map
            if (entry.getValue() >= 3) { // Check if the substring appears at least 3 times
                maxLength = Math.max(maxLength, entry.getKey().length()); // Update maxLength if the current substring is longer
            }
        }
        return maxLength; // Return the maximum length of the substring that appears at least 3 times
    }
}