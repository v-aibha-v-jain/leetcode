public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        int zeropos = 0; // Position to place the next non-zero element
        for (int i = 0; i < nums.length; i++) { // Iterate through the array
            if (nums[i] != 0) { // Check if the current element is non-zero
                int temp = nums[i]; // Store the current element in a temporary variable
                nums[i] = nums[zeropos]; // Move the zero to the current position
                nums[zeropos] = temp; // Place the non-zero element at the zeropos
                zeropos++; // Increment the zeropos for the next non-zero element
            }
        }
    }
}