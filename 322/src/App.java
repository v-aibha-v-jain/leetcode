import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(obj.coinChange(coins, amount));
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // Create an array to store the minimum coins needed for each amount
        Arrays.fill(dp, amount + 1); // Initialize the array with a value greater than the maximum possible amount
        dp[0] = 0; // Base case: no coins are needed to make amount 0
        for (int coin : coins) // Iterate over each coin
            for (int i = coin; i <= amount; i++) // Update the dp array for each amount from coin to the target amount
                dp[i] = Math.min(dp[i], dp[i - coin] + 1); // Choose the minimum coins needed by including the current coin
        return dp[amount] > amount ? -1 : dp[amount]; // If the target amount is not reachable, return -1; otherwise, return the minimum coins needed
    }
}