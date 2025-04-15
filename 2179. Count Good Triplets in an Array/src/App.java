public class App {
    public static void main(String[] args) throws Exception {
        int[] nums1 = {2, 0, 1, 3};
        int[] nums2 = {0, 1, 2, 3};
        Solution solution = new Solution();
        long result = solution.goodTriplets(nums1, nums2);
        System.out.println("Number of good triplets: " + result);
    }
}
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        
        // Map each value in nums2 to its index
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }

        int[] mapped = new int[n];
        // Map nums1 values to their positions in nums2
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }

        long[] left = new long[n];
        int[] bit = new int[n + 2]; // Binary Indexed Tree (BIT) for prefix sums

        // Calculate the number of elements smaller than the current element on the left
        for (int i = 0; i < n; i++) {
            left[i] = query(bit, mapped[i]); // Query BIT for prefix sum
            update(bit, mapped[i] + 1, 1);  // Update BIT with current element
        }

        long[] right = new long[n];
        bit = new int[n + 2]; // Reset BIT for right calculation

        // Calculate the number of elements greater than the current element on the right
        for (int i = n - 1; i >= 0; i--) {
            right[i] = query(bit, n) - query(bit, mapped[i] + 1); // Query BIT for range sum
            update(bit, mapped[i] + 1, 1); // Update BIT with current element
        }

        long res = 0;
        // Calculate the total number of good triplets
        for (int i = 0; i < n; i++) {
            res += left[i] * right[i]; // Multiply left and right counts for the middle element
        }
        return res;
    }

    // Update BIT at index i with value val
    void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val; // Add value to BIT
            i += i & -i; // Move to the next index
        }
    }

    // Query BIT for prefix sum up to index i
    int query(int[] bit, int i) {
        int res = 0;
        while (i > 0) {
            res += bit[i]; // Add BIT value to result
            i -= i & -i; // Move to the parent index
        }
        return res;
    }
}