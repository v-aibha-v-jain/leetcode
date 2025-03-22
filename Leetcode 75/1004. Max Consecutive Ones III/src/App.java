public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();  
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = obj.longestOnes(nums, k);
        System.out.println(result);
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0; // initialize left and right pointers
        int zeros = 0; // count of zeros in the current window
        int maxlen = 0; // maximum length of subarray with at most k zeros

        while (r < n) { // iterate through the array with the right pointer
            if (nums[r] == 0) zeros++; // increment zero count if current element is 0

            // shrink the window from the left if zeros exceed k
            while (zeros > k) {
                if (nums[l] == 0) zeros--; // decrement zero count if left element is 0
                l++; // move the left pointer to the right
            }

            // update the maximum length of the valid window
            if (zeros <= k) maxlen = Math.max(maxlen, r - l + 1);
            r++; // move the right pointer to the right
        }
        return maxlen; // return the maximum length found
    }
}