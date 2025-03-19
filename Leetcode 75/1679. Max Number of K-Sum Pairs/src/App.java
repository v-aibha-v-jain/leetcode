import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        int k = 5;
        System.out.println(solution.maxOperations(nums, k));
    }
}
class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array to use two-pointer technique
        int start = 0; // Initialize the start pointer
        int end = nums.length - 1; // Initialize the end pointer
        int count = 0; // Initialize the count of operations
        while(start < end){ // Loop until the two pointers meet
            int sum = nums[start] + nums[end]; // Calculate the sum of the two pointers
            if(sum == k){ 
                count++; // When the sum equals k, increase count
                start++; // Move the start pointer forward
                end--; // Move the end pointer backward
            }
            else if (sum > k) end--; // If the sum is greater than k, move the end pointer backward
            else start++; // If the sum is less than k, move the start pointer forward
        }
        return count; // Return the total count of operations
    }
}