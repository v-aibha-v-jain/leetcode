import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> result = sol.largestDivisibleSubset(nums); // Call the method to find the largest divisible subset
        System.out.println("Largest Divisible Subset: " + result); // Print the result
    }
}
class Solution {
    List<Integer> res; // To store the largest divisible subset
    int[] mem; // Memoization array to track the size of subsets
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // Sort the array to ensure divisibility order
        res = new ArrayList<>(); // Initialize the result list
        mem = new int[nums.length]; // Initialize the memoization array
        Arrays.fill(mem, -1); // Fill memoization array with -1
        helper(nums, 0, new ArrayList<>(), 1); // Start the recursive helper function
        return res; // Return the largest divisible subset
    }
    private void helper(int[] nums, int index, List<Integer> curr, int prev) {
        if(curr.size() > res.size()) { // Update result if current subset is larger
            res = new ArrayList<>(curr); // Copy current subset to result
        }
        for(int i = index; i < nums.length; i++) { // Iterate through the array
            if(curr.size() > mem[i] && nums[i] % prev == 0) { // Check divisibility and memoization
                mem[i] = curr.size(); // Update memoization for current index
                curr.add(nums[i]); // Add current number to the subset
                helper(nums, i + 1, curr, nums[i]); // Recurse with updated subset
                curr.remove(curr.size() - 1); // Backtrack by removing the last number
            }
        }
    }
}