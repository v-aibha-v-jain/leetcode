import java.util.Arrays;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "abciiidef";
        int k = 3;
        System.out.println(solution.maxVowels(s, k));
    }
}
class Solution {
    public int maxVowels(String s, int k) {
        // Create a set of vowels for quick lookup
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int cnt = 0; // Initialize the count of vowels in the first window
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) // Check if the character is a vowel
            cnt++; // Increment count if it's a vowel
        }
        int maxCount = cnt; // Initialize maxCount with the count of the first window
        for (int i = k; i < s.length(); i++) {
            if (set.contains(s.charAt(i - k))) cnt--; // Remove the effect of the character sliding out of the window
            if (set.contains(s.charAt(i))) cnt++; // Add the effect of the character sliding into the window
            maxCount = Math.max(maxCount, cnt); // Update maxCount if the current count is greater
        }
        return maxCount; // Return the maximum number of vowels in any substring of length k
    }
}