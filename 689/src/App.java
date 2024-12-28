import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int k = 2;
        int[] result = obj.maxSumOfThreeSubarrays(nums, k);
        System.out.println("Indices of the subarrays: " + Arrays.toString(result));
    }
}
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, sum1 = 0, sum2 = 0, sum3 = 0;
        int max1 = 0, max12 = 0, max123 = 0;
        int index1 = 0, index12_1 = 0, index12_2 = k;
        int[] ans = {0, k, 2 * k};

        // Calculate initial sums for the first k, second k, and third k elements
        for (int i = 0; i < k; i++) {
            sum1 += nums[i];
            sum2 += nums[i + k];
            sum3 += nums[i + 2 * k];
        }
        max1 = sum1; // Initialize max1 with sum1
        max12 = sum1 + sum2; // Initialize max12 with sum1 + sum2
        max123 = sum1 + sum2 + sum3; // Initialize max123 with sum1 + sum2 + sum3

        // Iterate through the array to find the maximum sums
        for (int i = 0; i <= n - 3 * k; i++) {
            if (i > 0) {
            // Update sums by sliding the window
            sum1 = sum1 - nums[i - 1] + nums[i + k - 1];
            sum2 = sum2 - nums[i + k - 1] + nums[i + 2 * k - 1];
            sum3 = sum3 - nums[i + 2 * k - 1] + nums[i + 3 * k - 1];
            }

            // Update max1 and index1 if a new max1 is found
            if (sum1 > max1) {
            max1 = sum1;
            index1 = i;
            }

            // Update max12 and indices if a new max12 is found
            if (max1 + sum2 > max12) {
            max12 = max1 + sum2;
            index12_1 = index1;
            index12_2 = i + k;
            }

            // Update max123 and ans if a new max123 is found
            if (max12 + sum3 > max123) {
            max123 = max12 + sum3;
            ans = new int[]{index12_1, index12_2, i + 2 * k};
            }
        }

        return ans; // Return the indices of the subarrays
    }
}