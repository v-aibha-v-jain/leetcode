import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        int lower = 2;
        int upper = 5;
        long result = solution.countFairPairs(nums, lower, upper);
        System.out.println(result);
    }
}
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums); // Sort the array to use binary search
        long total = 0; // Initialize total count of fair pairs
        for(int i = 0; i < nums.length; i++){
            int upperBound = upperBound(nums, i + 1, nums.length, (upper - nums[i])); // Find the upper bound index
            int lowerBound = lowerBound(nums, i + 1, nums.length, (lower - nums[i])); // Find the lower bound index
            total += (upperBound - lowerBound); // Add the count of fair pairs for current element
        }
        return total;
    }

    private int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2; // Calculate mid index
            if (nums[mid] < target) start = mid + 1; // Move start to mid + 1 if mid element is less than target
            else end = mid; // Move end to mid if mid element is greater than or equal to target
        }
        return start;
    }

    private int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2; // Calculate mid index
            if (nums[mid] <= target) start = mid + 1; // Move start to mid + 1 if mid element is less than or equal to target
            else end = mid; // Move end to mid if mid element is greater than target
        }
        return start;
    }
}