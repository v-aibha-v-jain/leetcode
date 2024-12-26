public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(obj.findTargetSumWays(nums, target));
    }
}
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length; // length of the nums array
        int sum = 0; // initialize sum to 0
        for (int i = 0; i < n; i++) {
            sum += nums[i]; // calculate the sum of all elements in nums
        }
        if (((sum - target) % 2 == 1) || (target > sum)) {
            return 0; // if the difference is odd or target is greater than sum, return 0
        }
        int ans = (sum - target) / 2; // calculate the required sum for one subset
        int[][] dp = new int[n + 1][ans + 1]; // create a dp array
        for(int i=0;i<=n;i++){
            dp[i][0]=1; // there's one way to get sum 0, by choosing no elements
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= ans; j++) {
            if (nums[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]; // include or exclude the current element
            } else {
                dp[i][j] = dp[i - 1][j]; // exclude the current element
            }
            }
        }
        return dp[n][ans]; // return the number of ways to get the target sum
    }
}