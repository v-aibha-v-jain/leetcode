public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {3, 1, 2, 2, 2, 1, 3};
        int k = 2;
        int result = solution.countPairs(nums, k);
        System.out.println("Number of valid pairs: " + result);
    }
}
class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0; // Initialize count to store the number of valid pairs
        int n = nums.length; // Get the length of the array
        for (int i = 0; i < n - 1; i++) { // Iterate through the array
            for (int j = i + 1; j < n; j++) { // Iterate through the remaining elements after i
                if (nums[i] == nums[j] && ((long)i * j) % k == 0) { 
                    // Check if the elements are equal and the product of indices is divisible by k
                    count++; // Increment count when the condition is satisfied
                }
            }
        }
        return count; // Return the total count of valid pairs
    }
}