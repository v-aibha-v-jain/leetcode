public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1,-3,2,3,-4};
        int result = obj.maxAbsoluteSum(nums);
        System.out.println(result);
    }
}
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, maxSoFar = 0, minSoFar = 0; // Initialize variables
        for (int num : nums) { // Iterate through each number in the array
            maxSoFar = Math.max(num, maxSoFar + num); // Update maxSoFar to be the maximum of the current number or the sum of maxSoFar and the current number
            minSoFar = Math.min(num, minSoFar + num); // Update minSoFar to be the minimum of the current number or the sum of minSoFar and the current number
            maxSum = Math.max(maxSum, maxSoFar); // Update maxSum to be the maximum of maxSum or maxSoFar
            minSum = Math.min(minSum, minSoFar); // Update minSum to be the minimum of minSum or minSoFar
        }
        return Math.max(maxSum, Math.abs(minSum)); // Return the maximum of maxSum or the absolute value of minSum
    }
}