public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] cost = {10, 15, 20};
        int result = solution.minCostClimbingStairs(cost);
        System.out.println("Minimum cost to climb the stairs: " + result);
    }
}
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length; // Get the length of the cost array
        int[] dp = new int[n + 1]; // Create a dp array to store minimum costs up to each step
        for (int i = 2; i <= n; i++) { // Start from step 2 as step 0 and 1 have no cost to reach
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]); // Calculate the minimum cost to reach step i
        }
        return dp[n]; // Return the minimum cost to reach the top of the stairs
    }
}