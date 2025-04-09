import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {5,2,5,4,5};
        int k = 2;
        int result = solution.minOperations(nums, k);
        System.out.println("Minimum operations to make all elements equal to " + k + ": " + result);
    }
}
class Solution {
    public int minOperations(int[] nums, int k) {
        // Check if any number in the array is less than k, return -1 if true
        for (int chakra : nums) if (chakra < k) return -1;

        // Create a set to store numbers greater than k
        Set<Integer> aboveK = new HashSet<>();
        for (int chakra : nums) {
            // Add numbers greater than k to the set
            if (chakra > k) aboveK.add(chakra);
        }
        // Return the size of the set, which represents unique numbers greater than k
        return aboveK.size();   
    }
}