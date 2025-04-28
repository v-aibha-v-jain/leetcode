public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        long k = 10;
        long result = solution.countSubarrays(nums, k);
        System.out.println("Count of subarrays with score less than " + k + ": " + result);
    }
}
class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length; // length of the input array
        long result = 0; // to store the count of valid subarrays
        long sum = 0; // to store the sum of the current subarray
        int i = 0; // left pointer of the sliding window
        int j = 0; // right pointer of the sliding window
        while (j < n) { // iterate through the array
            sum += nums[j]; // add the current element to the sum
            while (i <= j && sum * (j - i + 1) >= k) { // check if the score is >= k
                sum -= nums[i]; // shrink the window from the left
                i++; // move the left pointer
            }
            result += (j - i + 1); // add the count of valid subarrays ending at j
            j++; // move the right pointer
        }
        return result; // return the total count of valid subarrays
    }
}