import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        List<Integer> nums = List.of(8,3,9,3,8);
        int k = 2;
        int result = solution.maximumScore(nums, k);
        System.out.println(result);
    }
}
class Solution {
    private final int mod = (int) 1e9 + 7; // Modulo value for large numbers

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size(); // Size of the input list
        int[][] arr = new int[n][0]; // Array to store index, prime factors count, and value
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {i, primeFactors(nums.get(i)), nums.get(i)}; // Populate array
        }
        int[] left = new int[n]; // Array to store left boundaries
        int[] right = new int[n]; // Array to store right boundaries
        Arrays.fill(left, -1); // Initialize left boundaries to -1
        Arrays.fill(right, n); // Initialize right boundaries to n
        Deque<Integer> stk = new ArrayDeque<>(); // Stack for left boundary calculation
        for (int[] e : arr) {
            int i = e[0], f = e[1]; // Index and prime factor count
            while (!stk.isEmpty() && arr[stk.peek()][1] < f) {
                stk.pop(); // Pop elements with fewer prime factors
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek(); // Set left boundary
            }
            stk.push(i); // Push current index onto stack
        }
        stk.clear(); // Clear stack for right boundary calculation
        for (int i = n - 1; i >= 0; --i) {
            int f = arr[i][1]; // Prime factor count
            while (!stk.isEmpty() && arr[stk.peek()][1] <= f) {
                stk.pop(); // Pop elements with fewer or equal prime factors
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek(); // Set right boundary
            }
            stk.push(i); // Push current index onto stack
        }
        Arrays.sort(arr, (a, b) -> b[2] - a[2]); // Sort by value in descending order
        long ans = 1; // Initialize result
        for (int[] e : arr) {
            int i = e[0], x = e[2]; // Index and value
            int l = left[i], r = right[i]; // Left and right boundaries
            long cnt = (long) (i - l) * (r - i); // Calculate contribution count
            if (cnt <= k) {
                ans = ans * qpow(x, cnt) % mod; // Multiply result with power of x
                k -= cnt; // Decrease k by count
            } else {
                ans = ans * qpow(x, k) % mod; // Multiply result with remaining k
                break; // Exit loop as k is exhausted
            }
        }
        return (int) ans; // Return final result
    }

    private int primeFactors(int n) {
        int i = 2; // Start with smallest prime
        Set<Integer> ans = new HashSet<>(); // Set to store unique prime factors
        while (i <= n / i) {
            while (n % i == 0) {
                ans.add(i); // Add prime factor
                n /= i; // Reduce n
            }
            ++i; // Increment to next number
        }
        if (n > 1) {
            ans.add(n); // Add remaining prime factor if any
        }
        return ans.size(); // Return count of unique prime factors
    }

    private int qpow(long a, long n) {
        long ans = 1; // Initialize result
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod; // Multiply result if bit is set
            }
            a = a * a % mod; // Square base
        }
        return (int) ans; // Return final result
    }
}