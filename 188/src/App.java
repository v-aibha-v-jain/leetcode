public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] prices = {3,2,6,5,0,3};
        int k = 7;
        System.out.println(obj.maxProfit(k, prices));
    }
}
class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][prices.length]; // Create a 2D array to store the maximum profit
        for (int i = 1; i < dp.length; i++) { // Iterate over the number of transactions
            for (int j = 1; j < dp[0].length; j++) { // Iterate over the days
                int max = 0; // Initialize max profit for the current transaction and day
                for (int l = 0; l < j; l++) { // Iterate over the previous days
                    max = Math.max(max, (prices[j] - prices[l] + dp[i - 1][l])); // Calculate max profit by comparing current and previous profits
                } 
                dp[i][j] = Math.max(max, dp[i][j - 1]); // Store the maximum profit for the current transaction and day
            }
        }
        return dp[k][dp[0].length - 1]; // Return the maximum profit after k transactions
    }
}