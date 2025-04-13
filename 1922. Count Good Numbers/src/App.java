public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.countGoodNumbers(1));
    }
}
class Solution {
    // Helper function to calculate (base^expo) % mod using modular exponentiation
    public long helper(long base, long expo, long mod) {
        long ans = 1; // Initialize result
        while (expo > 0) {
            if (expo % 2 == 0) { // If expo is even
                base = (base * base) % mod; // Square the base and take mod
                expo = expo / 2; // Halve the exponent
            } else { // If expo is odd
                ans = (ans * base) % mod; // Multiply result with base and take mod
                expo -= 1; // Decrease exponent by 1
            }
        }
        return ans; // Return the final result
    }

    // Function to count the number of "good numbers" for a given n
    public int countGoodNumbers(long n) {
        if (n == 1) return 5; // If n is 1, return 5 as there are 5 good numbers
        long even = (n + 1) / 2; // Calculate the number of even positions
        long odd = n / 2; // Calculate the number of odd positions
        long mod = 1000000007; // Modulo value to prevent overflow
        // Calculate the result using helper function for even and odd positions
        return (int)((helper(5, even, mod) * helper(4, odd, mod)) % mod);
    }
}