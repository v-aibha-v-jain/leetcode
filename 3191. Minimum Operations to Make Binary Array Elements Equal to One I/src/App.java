public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 0, 0, 1, 0, 1};
        int result = solution.minOperations(nums);
        System.out.println(result);
    }
}
class Solution {
    public int minOperations(int[] nums) {
        int count = 0; // Initialize the operation count to 0
        for(int i = 0; i < nums.length - 2; i++) { // Iterate through the array up to the third last element
            if(nums[i] == 0) { // If the current element is 0
                nums[i] = 1 - nums[i]; // Flip the current element
                nums[i+1] = 1 - nums[i+1]; // Flip the next element
                nums[i+2] = 1 - nums[i+2]; // Flip the element after the next
                count += 1; // Increment the operation count
            }
        }
        // Check if the last two elements are 0, which makes it impossible to make all elements 1
        if(nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) {
            return -1; // Return -1 if it's not possible
        }
        return count; // Return the total number of operations
    }
}