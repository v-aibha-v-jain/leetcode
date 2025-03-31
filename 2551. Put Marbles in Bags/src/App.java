import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] w = {1, 3, 5, 1};
        int k = 2;
        System.out.println(solution.putMarbles(w, k));
    }
}
class Solution {
    public long putMarbles(int[] w, int k) {
        if (w.length == k || k == 1) return 0; // If all weights are in separate bags or only one bag, return 0
        int n = w.length; // Get the number of weights
        List<Integer> vec = new ArrayList<>(); // List to store pairwise sums of adjacent weights
        for (int i = 0; i < n - 1; i++) {
            vec.add(w[i] + w[i + 1]); // Add the sum of adjacent weights to the list
        }
        Collections.sort(vec); // Sort the list of pairwise sums
        long mini = 0, maxi = 0; // Initialize variables for minimum and maximum sums
        for (int i = 0; i < k - 1; i++) {
            mini += vec.get(i); // Add the smallest sums for the minimum calculation
            maxi += vec.get(n - 2 - i); // Add the largest sums for the maximum calculation
        }
        return maxi - mini; // Return the difference between maximum and minimum sums
    }
}