public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String s = "abaacbcbb";
        System.out.println(obj.minimumLength(s));
    }
}
class Solution {
    public int minimumLength(String s) {
        int removedCharacter = 0; // Initialize the count of removed characters
        int n = s.length(); // Get the length of the string
        int[] countOfCharacter = new int[26]; // Array to count occurrences of each character

        for (char ch : s.toCharArray()) {
            countOfCharacter[ch - 'a']++; // Count each character in the string
        }

        for (int i = 0; i < 26; i++) {
            int k = countOfCharacter[i]; // Get the count of the current character
            if (k > 2) {
                if (k % 2 == 0) {
                    removedCharacter += k - 2; // Remove characters if count is even
                } else {
                    removedCharacter += k - 1; // Remove characters if count is odd
                }
            }
        }

        return n - removedCharacter; // Return the minimum length of the string
    }
}