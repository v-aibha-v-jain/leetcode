public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String text1 = "abcde";
        String text2 = "ace";
        int result = solution.longestCommonSubsequence(text1, text2);
        System.out.println("Length of Longest Common Subsequence: " + result);
    }
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Create a 2D array to store the lengths of LCS for substrings
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        
        // Iterate through text1 and text2 in reverse order
        for(int i = text1.length()-1; i >= 0; i--) {
            for(int j = text2.length()-1; j >= 0; j--) {
                // If characters match, add 1 to the LCS length of the next indices
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } 
                // Otherwise, take the maximum LCS length from the next row or column
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        // Return the LCS length for the entire strings
        return dp[0][0];
    }
}