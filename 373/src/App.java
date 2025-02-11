import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(result);
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>(); // Initialize the result list
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result; // Edge case check
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0]) // Min-heap based on the sum of pairs
        );
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0}); // Initialize heap with pairs from nums1 and the first element of nums2
        }
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll(); // Extract the smallest pair
            int i = top[1], j = top[2];
            result.add(Arrays.asList(nums1[i], nums2[j])); // Add the current smallest pair to the result
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1}); // Add the next pair from nums2
            }
        }
        return result; // Return the k smallest pairs
    }
}