public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {10,20,30,5,10,50};
        int result = obj.maxAscendingSum(nums);
        System.out.println(result);
    }
}
class Solution {
    public int maxAscendingSum(int[] nums) {
        int curr = nums[0], ans = nums[0]; // Initialize current and answer with the first element
        for (int i = 1; i < nums.length; i++) { // Loop through the array starting from the second element
            curr = nums[i] > nums[i - 1] ? curr + nums[i] : nums[i]; // If current element is greater than previous, add to current sum, otherwise reset current sum
            ans = Math.max(ans, curr); // Update answer with the maximum of current sum and answer
        }
        return ans; // Return the maximum ascending sum
    }
}