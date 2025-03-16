public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.increasingTriplet(nums));
    }
}
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE; // Initialize the smallest number to the maximum possible value
        int b = Integer.MAX_VALUE; // Initialize the second smallest number to the maximum possible value
        for(int i = 0; i < nums.length; i++) { // Iterate through the array
            if(nums[i] <= a) a = nums[i]; // Update 'a' if the current number is smaller or equal to 'a'
            else if(nums[i] <= b) b = nums[i]; // Update 'b' if the current number is smaller or equal to 'b' but greater than 'a'
            else return true; // If a number greater than both 'a' and 'b' is found, return true
        }
        return false; // Return false if no increasing triplet is found
    }
}