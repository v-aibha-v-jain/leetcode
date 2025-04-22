public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 2;
        int maxVal = 5;
        int result = solution.idealArrays(n, maxVal);
        System.out.println("Number of ideal arrays: " + result);
    }
}
class Solution {
    static final int MOD = 1_000_000_007; // Modulo for large numbers
    int[] factMemo = new int[100001]; // Memoization for factorials
    int[][] dp = new int[10001][15]; // DP table to store counts of arrays

    long power(long a, long b, long m) { // Fast modular exponentiation
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % m; // Multiply result if b is odd
            a = (a * a) % m; // Square the base
            b >>= 1; // Divide b by 2
        }
        return res;
    }

    long fact(int x) { // Compute factorial with memoization
        if (x == 0 || x == 1) return 1; // Base case
        if (factMemo[x] != 0) return factMemo[x]; // Return memoized value
        return factMemo[x] = (int)(fact(x - 1) * x % MOD); // Compute and memoize
    }

    long nCr(int n, int r) { // Compute nCr using modular arithmetic
        if (r > n) return 0; // If r > n, return 0
        return fact(n) * power(fact(r), MOD - 2, MOD) % MOD * power(fact(n - r), MOD - 2, MOD) % MOD; // nCr formula
    }

    public int idealArrays(int n, int maxVal) { // Main function to calculate ideal arrays
        int maxLen = Math.min(14, n); // Maximum length of arrays to consider
        for (int i = 1; i <= maxVal; i++) {
            dp[i][1] = 1; // Initialize single-length arrays
        }
        for (int len = 2; len <= maxLen; len++) // Iterate over lengths
            for (int i = 1; i <= maxVal; i++) // Iterate over values
                for (int mult = 2; i * mult <= maxVal; mult++) // Iterate over multiples
                    dp[i * mult][len] = (dp[i * mult][len] + dp[i][len - 1]) % MOD; // Update DP table
        long res = 0; // Initialize result
        for (int val = 1; val <= maxVal; val++) { // Iterate over values
            for (int len = 1; len <= maxLen; len++) { // Iterate over lengths
                long ways = nCr(n - 1, len - 1); // Calculate combinations
                res = (res + ways * dp[val][len]) % MOD; // Add to result
            }
        }
        return (int) res; // Return final result
    }
}