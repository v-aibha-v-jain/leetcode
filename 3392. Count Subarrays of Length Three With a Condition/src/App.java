public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 1, 4, 1};
        int result = solution.countSubarrays(nums);
        System.out.println(result);
    }
}
class Solution {
    public int countSubarrays(int[] nums) {
        int res = 0; // Initialize result counter
        for (int i = 0; i < nums.length - 2; i++) { // Iterate through the array, stopping 2 elements before the end
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) { // Check if twice the middle element equals the sum of the first and third elements
                res++; // Increment the result counter if the condition is met
            }
        }
        return res; // Return the total count of valid subarrays
    }
}