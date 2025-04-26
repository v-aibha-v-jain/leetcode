public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 2, 7, 5};
        int minK = 1;
        int maxK = 5;
        long result = solution.countSubarrays(nums, minK, maxK);
        System.out.println("Count of subarrays: " + result);
    }
}
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMin = -1, lastMax = -1, lastInvalid = -1; // Initialize indices for minK, maxK, and invalid elements
        long count = 0; // Initialize the count of valid subarrays
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) { // Check if the current element is invalid
                lastInvalid = i; // Update the last invalid index
            }
            if (nums[i] == minK) { // Check if the current element equals minK
                lastMin = i; // Update the last index of minK
            }
            if (nums[i] == maxK) { // Check if the current element equals maxK
                lastMax = i; // Update the last index of maxK
            }
            int minLast = Math.min(lastMin, lastMax); // Find the smaller index between lastMin and lastMax
            if (minLast > lastInvalid) { // Check if the subarray is valid
                count += minLast - lastInvalid; // Add the number of valid subarrays ending at the current index
            }
        }
        return count; // Return the total count of valid subarrays
    }
}