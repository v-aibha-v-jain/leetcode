import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String num = "123";
        int result = solution.countBalancedPermutations(num);
        System.out.println("Number of balanced permutations: " + result);
    }
}
class Solution {
    static final int M = 1_000_000_007; // Modulo value for calculations
    int[][][] dp; // Memoization table for dynamic programming
    int[] cnt = new int[10], leftS = new int[10], leftC = new int[10]; // Count of digits and remaining sums/counts
    long[] r1 = new long[11]; // Precomputed factorial-like values
    int[][] cb = new int[81][81]; // Pascal's triangle for combinations

    void pascal() {
        // Build Pascal's triangle for combinations
        for (int i = 0; i <= 80; i++) {
            cb[i][0] = cb[i][i] = 1; // Base cases
            for (int j = 1; j < i; j++)
                cb[i][j] = (cb[i - 1][j - 1] + cb[i - 1][j]) % M; // Compute combinations
        }
    }

    long dfs(int i, int s, int c) {
        // Base case: if sum and count are zero, return precomputed value
        if (s == 0 && c == 0) return r1[i];
        // If out of bounds or invalid state, return 0
        if (i == 10 || s > leftS[i] || c > leftC[i]) return 0;
        // Return memoized result if already computed
        if (dp[i][s][c] != -1) return dp[i][s][c];
        long res = 0; // Initialize result
        int a = s; // Remaining sum
        for (int x = 0, y = cnt[i]; x <= cnt[i] && a >= 0 && c >= x; x++, y--, a -= i) {
            // Skip invalid states
            if (y > leftC[i] - c) continue;
            // Recursive call and combination calculations
            long b = dfs(i + 1, a, c - x) * cb[c][x] % M;
            res = (res + b * cb[leftC[i] - c][y]) % M; // Update result
        }
        return dp[i][s][c] = (int) res; // Memoize and return result
    }

    public int countBalancedPermutations(String num) {
        int n = num.length(), s = 0, ls = 0, lc = 0; // Initialize variables
        for (char ch : num.toCharArray()) {
            cnt[ch - '0']++; // Count occurrences of each digit
            s += ch - '0'; // Compute total sum of digits
        }
        if ((s & 1) != 0) return 0; // If sum is odd, return 0 (not balanced)
        pascal(); // Precompute Pascal's triangle
        r1[10] = 1; // Initialize base case for r1
        for (int i = 9; i >= 0; i--) {
            ls += i * cnt[i]; // Update remaining sum
            lc += cnt[i]; // Update remaining count
            leftS[i] = ls; // Store remaining sum
            leftC[i] = lc; // Store remaining count
            r1[i] = r1[i + 1] * cb[leftC[i]][cnt[i]] % M; // Precompute factorial-like values
        }
        dp = new int[10][361][41]; // Initialize DP table
        for (int[][] mat : dp)
            for (int[] row : mat)
                Arrays.fill(row, -1); // Fill DP table with -1 (uncomputed)
        return (int) dfs(0, s >> 1, n >> 1); // Start DFS with half sum and half count
    }
}