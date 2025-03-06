public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(); // lengths of s1 and s2
        if (m + n != s3.length()) return false; // if combined length of s1 and s2 is not equal to s3, return false
        boolean[][] dp = new boolean[m + 1][n + 1]; // create a 2D array to store results of subproblems
        for (int i = 0; i <= m; i++) { // iterate over each character in s1
            for (int j = 0; j <= n; j++) { // iterate over each character in s2
                if (i == 0 && j == 0) dp[i][j] = true; // if both strings are empty, they interleave to form an empty string
                else if (i == 0) dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1); // if s1 is empty, check if s2 matches s3
                else if (j == 0) dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1); // if s2 is empty, check if s1 matches s3
                else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || // check if current character of s1 matches s3
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)); // check if current character of s2 matches s3
                }
            }
        }
        return dp[m][n]; // return the result for the entire strings
    }
}