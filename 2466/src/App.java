public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int result = solution.countGoodStrings(3, 3, 1, 1);
        System.out.println(result);
    }
}
class Solution {
    int m = 1000*1000*1000+7; // Modulo value
    public int countGoodStrings(int low, int high, int zero, int one) {
        Integer dp[] = new Integer[high+1]; // DP array to store results
        return solve(0, low, high, zero, one, dp); // Start solving from length 0
    }
    int solve(int len, int l, int h, int z, int o, Integer dp[]) {
        if(len > h) return 0; // If length exceeds high, return 0
        if(dp[len] != null) return dp[len]; // Return cached result if available
        int x = 0;
        if(len >= l && len <= h) x = 1; // If length is within range, count it as a good string
        int addOne = solve(len + o, l, h, z, o, dp); // Add 'one' and solve recursively
        int addZero = solve(len + z, l, h, z, o, dp); // Add 'zero' and solve recursively
        return dp[len] = (addOne + addZero + x) % m; // Store result in dp array and return
    }
}