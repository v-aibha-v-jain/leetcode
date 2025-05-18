import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int m = 1; // Number of rows
        int n = 1; // Number of columns
        int result = solution.colorTheGrid(m, n); // Call the method
        System.out.println(result); // Print the result
    }
}
class Solution {
    private static final int MOD = 1_000_000_007; // Modulo for large numbers

    public int colorTheGrid(int m, int n) {
        List<int[]> states = new ArrayList<>(); // All valid colorings for one column
        generateStates(m, new int[m], 0, states); // Generate all valid states
        Map<String, List<String>> transitions = new HashMap<>(); // Valid transitions between states
        for (int[] a : states) {
            String keyA = Arrays.toString(a); // Convert state to string key
            transitions.putIfAbsent(keyA, new ArrayList<>());
            for (int[] b : states) {
                if (isCompatible(a, b)) { // Check if two columns are compatible
                    transitions.get(keyA).add(Arrays.toString(b)); // Add valid transition
                }
            }
        }
        Map<String, Integer> dp = new HashMap<>(); // DP map: state -> count
        for (int[] state : states) {
            dp.put(Arrays.toString(state), 1); // Initialize with 1 way for each state
        }
        for (int col = 1; col < n; col++) { // For each column
            Map<String, Integer> newDp = new HashMap<>();
            for (String prev : dp.keySet()) {
                int count = dp.get(prev); // Number of ways to reach prev state
                for (String next : transitions.get(prev)) {
                    newDp.put(next, (newDp.getOrDefault(next, 0) + count) % MOD); // Update ways for next state
                }
            }
            dp = newDp; // Move to next column
        }
        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % MOD; // Sum all ways
        }
        return result; // Return total ways
    }
    private void generateStates(int m, int[] current, int row, List<int[]> states) {
        if (row == m) {
            states.add(Arrays.copyOf(current, m)); // Add valid state
            return;
        }
        
        for (int color = 1; color <= 3; color++) { // Try all 3 colors
            if (row > 0 && current[row - 1] == color){
                continue; // Skip if same as previous row
            } 
            current[row] = color; // Assign color
            generateStates(m, current, row + 1, states); // Recurse to next row
        }
    }
    private boolean isCompatible(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]){
                return false; // Same color in same row, not compatible
            } 
        }
        return true; // Compatible columns
    }
}