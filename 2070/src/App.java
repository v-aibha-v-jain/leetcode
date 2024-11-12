import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] items = {{1, 2}, {2, 1}, {3, 5}, {4, 4}, {5, 3}};
        int[] queries = {2, 3, 4};
        int[] result = solution.maximumBeauty(items, queries);
        System.out.println(Arrays.toString(result));
    }
}
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> { // Sort items based on the first element, and if equal, then by the second element
            return (a[0] != b[0]) ? a[0] - b[0] : (a[1] - b[1]);
        });
        int n1 = items.length; // Number of items
        int n2 = queries.length; // Number of queries
        int que[] = new int[n2]; // Array to store sorted queries
        for (int i = 0; i < n2; ++i) // Copy queries to que array
            que[i] = queries[i];
        Arrays.sort(que); // Sort the queries
        int arr[] = new int[n2]; // Array to store results
        int maxProfit = 0; // Variable to store maximum beauty value
        HashMap<Integer, Integer> hm = new HashMap<>(); // HashMap to store query results
        int p1 = 0; // Pointer for items array
        // Process each query
        for (int i = 0; i < n2; ++i) { // Update maxProfit for items with price less than or equal to current query
            while (p1 < n1 && items[p1][0] <= que[i]) {
                if (items[p1][1] > maxProfit)
                    maxProfit = items[p1][1];
                p1++;
            } // Store the result for the current query
            hm.put(que[i], maxProfit);
        }
        // Fill the result array with the stored results
        for (int i = 0; i < n2; ++i)
            arr[i] = hm.get(queries[i]);
        return arr; // Return the result array
    }
}