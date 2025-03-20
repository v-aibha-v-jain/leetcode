public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double result = solution.findMaxAverage(nums, k);
        System.out.println(result);
    }
}
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max, sum = 0; // Initialize variables for max average and current sum
        for (int j = 0; j < k; j++) { // Calculate the sum of the first 'k' elements
            sum += nums[j];
        }
        sum = sum / k; // Calculate the average of the first 'k' elements
        max = sum; // Set the initial max average to the first average
        int i = 1; // Start sliding window from the second element
        while (i <= nums.length - k) { // Loop until the end of the array
            sum = (k * sum - nums[i - 1] + nums[i + k - 1]) / k; // Update the average by sliding the window
            if (sum > max) max = sum; // Update max if the new average is greater
            i++; // Move the window forward
        }
        return max; // Return the maximum average found
    }
}