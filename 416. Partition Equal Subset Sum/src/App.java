public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartition(nums);
        System.out.println(result); // Output: true
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num; // calculate the total sum of the array
        if ((totalSum & 1) == 1) return false; // if the total sum is odd, partitioning is not possible
        int target = totalSum / 2; // target sum for each subset
        boolean[] dp = new boolean[target + 1]; // dp array to track achievable sums
        dp[0] = true; // base case: sum of 0 is always achievable
        for (int num : nums) // iterate through each number in the array
            for (int i = target; i >= num; i--) // iterate backwards to avoid overwriting
                dp[i] = dp[i] || dp[i - num]; // update dp array to include current number
        return dp[target]; // return whether the target sum is achievable
    }
}