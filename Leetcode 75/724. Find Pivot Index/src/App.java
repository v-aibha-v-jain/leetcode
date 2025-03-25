public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int result = obj.pivotIndex(nums);
        System.out.println(result);
    }
}
class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        // Calculate the total sum of the array
        for (int num : nums) {
            rightSum = rightSum + num; // Add each element to rightSum
        }
        int leftSum = 0;
        // Iterate through the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            rightSum = rightSum - nums[i]; // Subtract the current element from rightSum
            if (rightSum == leftSum) return i; // Check if leftSum equals rightSum
            leftSum = leftSum + nums[i]; // Add the current element to leftSum
        }
        return -1; // Return -1 if no pivot index is found
    }
}