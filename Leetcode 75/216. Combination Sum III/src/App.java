import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int k = 3;
        int n = 7;
        List<List<Integer>> result = sol.combinationSum3(k, n);
        System.out.println("Combinations of " + k + " numbers that sum to " + n + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>(); // Result list to store all valid combinations
        findcomb(k, n, res, 1, new ArrayList<>()); // Start finding combinations from 1
        return res; // Return the result list
    }

    private static void findcomb(int k, int target, List<List<Integer>> res, int start, List<Integer> comb) {
        if (target < 0 || comb.size() > k) return; // If target is negative or combination size exceeds k, stop
        if (target == 0 && comb.size() == k) { // If target is 0 and combination size equals k
            res.add(new ArrayList<>(comb)); // Add the current combination to the result list
            return;
        }
        for (int i = start; i <= 9; i++) { // Loop through numbers from start to 9
            comb.add(i); // Add the current number to the combination
            findcomb(k, target - i, res, i + 1, comb); // Recurse with updated target and next start number
            comb.remove(comb.size() - 1); // Backtrack by removing the last added number
        }
    }
}