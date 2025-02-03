public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 4, 3, 3, 2};
        System.out.println(obj.longestMonotonicSubarray(nums));
    }
}
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1; // Initialize increasing subarray length
        int dec = 1; // Initialize decreasing subarray length
        int max = 1; // Initialize maximum subarray length
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) { // If current element is greater than previous
                inc++; // Increase length of increasing subarray
                dec = 1; // Reset length of decreasing subarray
            } else if (nums[i] < nums[i - 1]) { // If current element is less than previous
                dec++; // Increase length of decreasing subarray
                inc = 1; // Reset length of increasing subarray
            } else { // If current element is equal to previous
                inc = 1; // Reset length of increasing subarray
                dec = 1; // Reset length of decreasing subarray
            }
            max = (int) Math.max(max, Math.max(inc, dec)); // Update maximum subarray length
        }
        return max; // Return the maximum length of monotonic subarray
    }
}