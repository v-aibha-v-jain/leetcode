import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String word1 = "abc";
        String word2 = "bca";
        boolean result = obj.closeStrings(word1, word2);
        System.out.println(result);
    }
}
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) { // If lengths are not equal, return false
            return false;
        }
        int[] w1 = new int[26]; // Frequency array for word1
        int[] w2 = new int[26]; // Frequency array for word2
        for (int i = 0; i < word1.length(); i++) {
            w1[word1.charAt(i) - 'a']++; // Count frequency of each character in word1
            w2[word2.charAt(i) - 'a']++; // Count frequency of each character in word2
        }
        for (int i = 0; i < 26; i++) {
            if ((w1[i] == 0 && w2[i] != 0) || (w1[i] != 0 && w2[i] == 0)) { // Check if one word has a character the other doesn't
                return false;
            }
        }
        Arrays.sort(w1); // Sort frequency array of word1
        Arrays.sort(w2); // Sort frequency array of word2
        for (int i = 0; i < 26; i++) {
            if (w1[i] != w2[i]) { // Compare sorted frequency arrays
                return false;
            }
        }
        return true; // Words are close if all checks pass
    }
}