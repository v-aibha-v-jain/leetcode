import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(obj.countBadPairs(nums));
    }
}
class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length; // Get the length of the array
        long total = n * (n - 1) / 2; // Calculate the total number of pairs
        long goodpairs = 0; // Initialize the count of good pairs
        HashMap<Integer, Integer> map = new HashMap<>(); // Create a HashMap to store the differences
        for (int i = 0; i < nums.length; i++) {
            goodpairs += map.getOrDefault(i - nums[i], 0); // Count the good pairs
            map.put(i - nums[i], map.getOrDefault(i - nums[i], 0) + 1); // Update the HashMap with the current difference
        }
        return total - goodpairs; // Return the number of bad pairs
    }
}