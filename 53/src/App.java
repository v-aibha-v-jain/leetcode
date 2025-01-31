public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(obj.maxSubArray(nums));
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0]; // Initialize maxsum with the first element of the array
        int currsum = nums[0]; // Initialize currsum with the first element of the array
        int n = nums.length; // Get the length of the array
        for(int i=1; i<n; i++) { // Iterate through the array starting from the second element
            currsum = Math.max(nums[i], currsum + nums[i]); // Update currsum to be the maximum of the current element or the sum of currsum and the current element
            maxsum = Math.max(maxsum, currsum); // Update maxsum to be the maximum of maxsum or currsum
        }
        return maxsum; // Return the maximum subarray sum
    }
}