public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 3;
        int result = solution.numTilings(n);
        System.out.println("Number of ways to tile a board of length " + n + ": " + result);
    }
}
class Solution {
    public int numTilings(int n) {
        long[] dp = new long[n + 3]; // Array to store the number of ways to tile up to each length
        dp[0] = 1; // Base case: 1 way to tile a board of length 0
        dp[1] = 2; // Base case: 2 ways to tile a board of length 1
        dp[2] = 5; // Base case: 5 ways to tile a board of length 2
        for (int i = 3; i < n; i++) // Iterate from length 3 to n-1
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007; // Calculate ways using recurrence relation
        return (int) dp[n - 1]; // Return the result for the given length
    }
}