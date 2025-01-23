import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> ans = solution.combinationSum(candidates, target);
        for (List<Integer> comb : ans) {
            for (int num : comb) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // Initialize the list to store the results

        combination(candidates, target, 0, new ArrayList<>(), 0, ans); // Start the combination process

        return ans; // Return the list of combinations
    }

    private void combination(int[] candidates, int target, int idx, List<Integer> comb, int total,
            List<List<Integer>> ans) {
        if (total == target) { // If the current total equals the target
            ans.add(new ArrayList<>(comb)); // Add the current combination to the results
            return; // Exit the function
        }

        if (total > target || idx >= candidates.length) // If the total exceeds the target or index is out of bounds
            return; // Exit the function

        comb.add(candidates[idx]); // Add the current candidate to the combination
        combination(candidates, target, idx, comb, total + candidates[idx], ans); // Recurse with the same index

        comb.remove(comb.size() - 1); // Remove the last added candidate
        combination(candidates, target, idx + 1, comb, total, ans); // Recurse with the next index
    }
}