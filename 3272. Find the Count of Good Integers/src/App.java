import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.countGoodIntegers(3, 2));
    }
}
class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> st = new HashSet<>(); // To store unique permutations of digits
        int d = (n + 1) / 2; // Calculate half the length of the number
        int start = (int) Math.pow(10, d - 1); // Start of the range for left half
        int end = (int) Math.pow(10, d) - 1; // End of the range for left half

        for (int num = start; num <= end; num++) {
            String leftHalf = Integer.toString(num); // Generate left half of the number
            String full;

            if (n % 2 == 0) {
                StringBuilder rightHalf = new StringBuilder(leftHalf).reverse(); // Reverse left half for even-length numbers
                full = leftHalf + rightHalf.toString(); // Combine left and right halves
            } else {
                StringBuilder rightHalf = new StringBuilder(leftHalf.substring(0, d - 1)).reverse(); // Reverse left half excluding middle digit for odd-length numbers
                full = leftHalf + rightHalf.toString(); // Combine left and right halves
            }

            long number = Long.parseLong(full); // Convert the full number to long
            if (number % k != 0) // Skip if the number is not divisible by k
                continue;

            char[] chars = full.toCharArray(); // Convert the number to a character array
            Arrays.sort(chars); // Sort the digits
            st.add(new String(chars)); // Add the sorted digits as a unique key
        }

        long[] factorial = new long[11]; // Precompute factorials up to 10
        factorial[0] = 1;
        for (int i = 1; i < 11; i++) {
            factorial[i] = factorial[i - 1] * i; // Compute factorial iteratively
        }

        long result = 0; // Initialize result
        for (String s : st) {
            int[] count = new int[10]; // Count occurrences of each digit
            for (char ch : s.toCharArray()) {
                count[ch - '0']++; // Increment count for the digit
            }

            int totalDigits = s.length(); // Total digits in the number
            int zeroDigits = count[0]; // Count of zeros
            int nonZeroDigits = totalDigits - zeroDigits; // Count of non-zero digits

            long perm = nonZeroDigits * factorial[totalDigits - 1]; // Calculate permutations for non-zero starting digits
            for (int i = 0; i < 10; i++) {
                perm /= factorial[count[i]]; // Divide by factorial of counts to handle repeated digits
            }

            result += perm; // Add permutations to the result
        }

        return result; // Return the final result
    }
}