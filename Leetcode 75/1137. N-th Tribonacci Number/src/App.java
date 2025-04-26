public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 4;
        int result = solution.tribonacci(n);
        System.out.println("The " + n + "th Tribonacci number is: " + result);
    }
}
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0; // Base case: Tribonacci of 0 is 0
        }
        if (n == 1 || n == 2) {
            return 1; // Base case: Tribonacci of 1 or 2 is 1
        }
        int[] dp = new int[n + 1]; // Array to store Tribonacci values
        dp[0] = 0; // Initialize Tribonacci of 0
        dp[1] = 1; // Initialize Tribonacci of 1
        dp[2] = 1; // Initialize Tribonacci of 2
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]; // Calculate Tribonacci of i
        }
        return dp[n]; // Return Tribonacci of n
    }
}