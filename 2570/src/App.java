import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] nums1 = {{1, 2}, {2, 3}, {4, 5}};
        int[][] nums2 = {{1, 4}, {3, 4}, {4, 1}};
        int[][] result = solution.mergeArrays(nums1, nums2);
        for (int[] pair : result) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // Create a map to store the merged results
        for (int[] pair : nums1) map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]); // Add elements from nums1 to the map
        for (int[] pair : nums2) map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]); // Add elements from nums2 to the map
        List<int[]> result = new ArrayList<>(); // Create a list to store the final merged array
        for (int key : map.keySet()) {
            result.add(new int[]{key, map.get(key)}); // Add each key-value pair from the map to the result list
        }
        result.sort(Comparator.comparingInt(a -> a[0])); // Sort the result list by the first element of each pair
        return result.toArray(new int[0][]); // Convert the result list to an array and return it
    }
}