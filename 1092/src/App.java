public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(); // length of str1
        int n = str2.length(); // length of str2
        int[][] dp = new int[m + 1][n + 1]; // DP table to store lengths of longest common subsequence

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) // characters match
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // increment length of common subsequence
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // take the maximum length from previous subsequences
            }
        }

        StringBuilder scs = new StringBuilder(); // to store the shortest common supersequence
        int i = m, j = n;

        // Build the shortest common supersequence from the DP table
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // characters match
                scs.append(str1.charAt(i - 1)); // add character to result
                i--; // move diagonally up-left in the DP table
                j--; // move diagonally up-left in the DP table
            } else if (dp[i - 1][j] > dp[i][j - 1]) { // character from str1 is part of the supersequence
                scs.append(str1.charAt(i - 1)); // add character to result
                i--; // move up in the DP table
            } else { // character from str2 is part of the supersequence
                scs.append(str2.charAt(j - 1)); // add character to result
                j--; // move left in the DP table
            }
        }

        // Add remaining characters of str1
        while (i > 0) scs.append(str1.charAt(--i)); // add remaining characters of str1 to result

        // Add remaining characters of str2
        while (j > 0) scs.append(str2.charAt(--j)); // add remaining characters of str2 to result

        return scs.reverse().toString(); // reverse the result to get the correct order
    }
}