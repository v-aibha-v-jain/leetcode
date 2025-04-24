import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 3, 1, 2, 2};
        int result = solution.countCompleteSubarrays(nums);
        System.out.println("Count of complete subarrays: " + result);
    }
}
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int count = 0; // Initialize count of complete subarrays
        int n = nums.length, i = 0, j = 0; // Initialize pointers and array length
        int total = Arrays.stream(nums).boxed().collect(Collectors.toSet()).size(); // Calculate the total number of unique elements in the array
        Map<Integer, Integer> map = new HashMap<>(); // Map to store frequency of elements in the current window
        int mapSize = 0; // Variable to track the size of the map
        while(j < n) { // Iterate through the array
            map.merge(nums[j], 1, Integer::sum); // Add the current element to the map and update its frequency
            mapSize = map.size(); // Update the size of the map
            if(mapSize < total) j++; // If the current window doesn't contain all unique elements, expand the window
            else {
            while(mapSize == total) { // While the current window contains all unique elements
                count += n - j; // Count all subarrays starting from i to the end of the array
                if(map.merge(nums[i], -1, Integer::sum) == 0) { // Decrease the frequency of the element at i and remove it if its frequency becomes 0
                map.remove(nums[i]); // Remove the element from the map
                --mapSize; // Decrease the map size
                }
                ++i; // Shrink the window from the left
            }
            ++j; // Expand the window from the right
            } 
        }
        return count; // Return the total count of complete subarrays
    }
}