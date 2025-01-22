import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>(); // Initialize the list to store permutations
        solve(0, nums, lst); // Start solving from index 0
        return lst; // Return the list of permutations
    }

    private void solve(int idx, int[] nums, List<List<Integer>> lst) {
        if (idx == nums.length) { // If the current index is at the end of the array
            List<Integer> permutation = new ArrayList<>(); // Create a new permutation list
            for (int num : nums) {
                permutation.add(num); // Add each number to the permutation list
            }
            lst.add(permutation); // Add the permutation to the list of permutations
            return; // Return to backtrack
        }
        for (int i = idx; i < nums.length; i++) { // Iterate through the array
            swap(nums, i, idx); // Swap the current index with the loop index
            solve(idx + 1, nums, lst); // Recursively solve for the next index
            swap(nums, i, idx); // Swap back to backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int a = nums[i]; // Store the value at index i
        nums[i] = nums[j]; // Assign the value at index j to index i
        nums[j] = a; // Assign the stored value to index j
    }
}