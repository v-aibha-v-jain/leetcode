public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 5;
        int[] result = obj.constructDistancedSequence(n);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    public int[] constructDistancedSequence(int n) {
        boolean used[] = new boolean[n + 1]; // Array to track used numbers
        int seq[] = new int[2 * n - 1]; // Array to store the sequence
        backtrack(0, used, seq, n); // Start backtracking from index 0
        return seq; // Return the constructed sequence
        }

        public static boolean backtrack(int index, boolean used[], int seq[], int n) {
        while (index < seq.length && seq[index] != 0) {
            index++; // Move to the next empty position
        }
        if (index == seq.length) {
            return true; // All positions are filled
        }
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue; // Skip if the number is already used
            if (i == 1) {
            seq[index] = i; // Place number 1 at the current index
            used[i] = true; // Mark number 1 as used
            if (backtrack(index + 1, used, seq, n)) return true; // Recur for the next index
            seq[index] = 0; // Reset the current index
            used[i] = false; // Unmark number 1 as used
            } else if (index + i < seq.length && seq[index + i] == 0) {
            seq[index] = i; // Place number i at the current index
            seq[index + i] = i; // Place number i at the index + i
            used[i] = true; // Mark number i as used
            if (backtrack(index + 1, used, seq, n)) return true; // Recur for the next index
            seq[index] = 0; // Reset the current index
            seq[index + i] = 0; // Reset the index + i
            used[i] = false; // Unmark number i as used
            }
        }
        return false; // No valid sequence found
    }
}