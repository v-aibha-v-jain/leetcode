import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int result = solution.minMutation(startGene, endGene, bank);
        System.out.println("Minimum mutations needed: " + result);
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0; // If start and end genes are the same, no mutation is needed
        Map<String,Integer> map = new HashMap<>(); // Map to store the mutation steps for each gene
        for(String s: bank) map.put(s, -1); // Initialize all genes in the bank with -1 (unvisited)
        Queue<String> q = new LinkedList<>(); // Queue for BFS
        map.put(startGene, 0); // Start gene has 0 mutations
        q.offer(startGene); // Add start gene to the queue
        while(!q.isEmpty()) { // While there are genes to process
            String curr = q.poll(); // Get the current gene
            for(String s: bank) { // Check all genes in the bank
            if (isValidMutation(curr, s) && map.get(s) == -1) { // If valid mutation and not visited
                map.put(s, map.get(curr) + 1); // Update mutation steps
                q.offer(s); // Add gene to the queue
            }
            }
        }
        return map.get(endGene) == null ? -1 : map.get(endGene); // Return mutation steps to end gene or -1 if not reachable
        }
        public boolean isValidMutation(String a, String b) {
        if (a.length() != b.length()) return false; // Genes must be of the same length
        int changes = 0; // Count the number of changes
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) { // If characters at position i are different
            changes++; // Increment changes
            if (changes > 1) return false; // More than one change is not a valid mutation
            }
        }
        return true; // Valid mutation if exactly one change
    }
}