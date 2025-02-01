public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1,-2,3,-2};
        int result = obj.maxSubarraySumCircular(nums);
        System.out.println(result);
    }
}
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        var maxSum = nums[0]; // Initialize maxSum with the first element
        var currentSum = nums[0]; // Initialize currentSum with the first element
        var total = nums[0]; // Initialize total with the first element
        var minSum = nums[0]; // Initialize minSum with the first element
        var currentMinSum = nums[0]; // Initialize currentMinSum with the first element
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]); // Update currentSum to be the maximum of current element or currentSum + current element
            currentMinSum = Math.min(nums[i], currentMinSum + nums[i]); // Update currentMinSum to be the minimum of current element or currentMinSum + current element
            minSum = Math.min(minSum, currentMinSum); // Update minSum to be the minimum of minSum or currentMinSum
            maxSum = Math.max(maxSum, currentSum); // Update maxSum to be the maximum of maxSum or currentSum
            total += nums[i]; // Add current element to total
        }
        if (maxSum < 0) return maxSum; // If all elements are negative, return maxSum
        if (minSum < 0) return Math.max(maxSum, total + (minSum * -1)); // If minSum is negative, return the maximum of maxSum or total + (minSum * -1)
        return maxSum; // Return maxSum
    }
}