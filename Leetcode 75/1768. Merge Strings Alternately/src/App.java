public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String word1 = "abc";
        String word2 = "pqr";
        String result = solution.mergeAlternately(word1, word2);
        System.out.println(result);
    }
}
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder(); // Create a StringBuilder to store the merged string
        int i = 0, j = 0; // Initialize pointers for both words
        int len1 = word1.length(), len2 = word2.length(); // Get the lengths of both words
        
        while (i < len1 || j < len2) { // Loop until both pointers reach the end of their respective words
            if (i < len1) { // If there are remaining characters in word1
                merged.append(word1.charAt(i)); // Append the current character from word1
                i++; // Move the pointer in word1
            }
            if (j < len2) { // If there are remaining characters in word2
                merged.append(word2.charAt(j)); // Append the current character from word2
                j++; // Move the pointer in word2
            }
        }
        return merged.toString(); // Convert the StringBuilder to a String and return it
    }
}