public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1,3,8,48,10};
        int ans = solution.longestNiceSubarray(nums);
        System.out.println(ans);
    }
}
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int temp = 0; // to store the bitwise OR of the current subarray
        int start = 0; // starting index of the current subarray
        int ans = 1; // to store the maximum length of a nice subarray
        for(int i = 0; i < nums.length; i++) {
            // shrink the window until the current number can be added without conflict
            while((nums[i] & temp) != 0) {
                temp ^= nums[start]; // remove the effect of nums[start] from temp
                start++; // move the start pointer forward
            }
            temp |= nums[i]; // add the current number to the subarray
            ans = Math.max(ans, i - start + 1); // update the maximum length
        }
        return ans; // return the maximum length of the nice subarray
    }
}