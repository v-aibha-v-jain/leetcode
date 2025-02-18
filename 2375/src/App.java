public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        String pattern = "IIIDIDDD";
        String result = obj.smallestNumber(pattern);
        System.out.println(result);
    }
}
class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length(); // Get the length of the pattern
        char[] res = new char[n + 1]; // Create a result array of size n+1
        for (int i = 0; i <= n; i++) {
            res[i] = (char) ((i + 1) + '0'); // Initialize the result array with characters '1' to 'n+1'
        }
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j >= 0 && pattern.charAt(j) == 'D') { // While the current character is 'D'
                swap(res, j, j + 1); // Swap the characters at positions j and j+1
                j--; // Move to the previous character
            }
        }
        return new String(res); // Convert the result array to a string and return it
    }

    private void swap(char[] res, int j, int i) {
        char temp = res[i]; // Store the character at position i in a temporary variable
        res[i] = res[j]; // Assign the character at position j to position i
        res[j] = temp; // Assign the temporary variable to position j
    }
}