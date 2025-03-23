public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {0,1,1,1,0,1,1,0,1};
        int result = solution.longestSubarray(nums);
        System.out.println(result);
    }
}
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0; // left pointer for the sliding window
        int count = 0; // count of zeros in the current window
        int max = 0; // maximum length of subarray with at most one zero
        for (int right = 0; right < nums.length; right++) { // iterate through the array with the right pointer
            if (nums[right] == 0) count++; // increment count when a zero is encountered
            while (count > 1) { // shrink the window if there are more than one zero
                if (nums[left] == 0) count--; // decrement count if the left pointer points to a zero
                left++; // move the left pointer to the right
            }
            max = Math.max(max, right - left); // update the maximum length
        }
        return max; // return the maximum length of the subarray
    }
}