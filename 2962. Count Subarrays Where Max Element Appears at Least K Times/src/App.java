public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1,3,2,3,3};
        int k = 2;
        long result = solution.countSubarrays(nums, k);
        System.out.println("Count of subarrays where max element appears at least " + k + " times: " + result);
    }
}
class Solution {
    public long countSubarrays(int[] nums, int k) {
        long maxNum = 0, count = 0; // initialize maxNum and count
        long left = 0, right = 0, ans = 0; // initialize pointers and result
        for (int num : nums) maxNum = Math.max(maxNum, num); // find the maximum number in the array

        while (right < nums.length || left > right) { // iterate through the array
            if (nums[(int)right] == maxNum) count++; // increment count if current number is maxNum
            while (count >= k) { // check if maxNum appears at least k times
                if (nums[(int)left] == maxNum) count--; // decrement count if left pointer is at maxNum
                left++; // move the left pointer
                ans += nums.length - right; // add valid subarrays to the result
            }
            right++; // move the right pointer
        }
        return ans; // return the total count of valid subarrays
    }
}