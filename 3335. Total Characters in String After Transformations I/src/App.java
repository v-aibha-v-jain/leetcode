public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s = "abcyy";
        int t = 2;
        int result = solution.lengthAfterTransformations(s, t);
        System.out.println("Result: " + result);
    }
}
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007; // Modulo to prevent overflow
        long[] count = new long[26]; // Array to store frequency of each character
        for (char c : s.toCharArray()) {
            count[c - 'a']++; // Increment count for the corresponding character
        }
        for (int i = 0; i < t; i++) {
            long[] newCount = new long[26]; // Temporary array for the next transformation
            for (int j = 0; j < 26; j++) {
                if (count[j] == 0) continue; // Skip if no characters of this type
                if (j == 25) { // If character is 'z'
                    newCount[0] = (newCount[0] + count[j]) % MOD; // Add to 'a'
                    newCount[1] = (newCount[1] + count[j]) % MOD; // Add to 'b'
                } else {
                    newCount[j + 1] = (newCount[j + 1] + count[j]) % MOD; // Shift to the next character
                }
            }
            count = newCount; // Update count for the next iteration
        }
        long result = 0; // Variable to store the final result
        for (int i = 0; i < 26; i++) {
            result = (result + count[i]) % MOD; // Sum up all character counts
        }
        return (int) result; // Return the result as an integer
    }
}
