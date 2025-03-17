import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution.divideArray(nums));
    }
}
class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums); // Sort the array to group identical numbers together
        for (int i = 0; i < nums.length; i += 2) { // Iterate through the array in steps of 2
            if (nums[i] != nums[i + 1]) // Check if the current pair of numbers are not equal
                return false; // Return false if a pair is not equal
        }
        return true; // Return true if all pairs are equal
    }
}