public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4,2,3,3,5,7};
        int result = solution.minimumOperations(nums);
        System.out.println("Minimum number of operations: " + result);
    }
}
class Solution {
    public int minimumOperations(int[] nums) {
        int[] arr = new int[101]; // Array to track the last occurrence of each number
        int last = -1; // Variable to track the last repeated element's index
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i]; // Current number in the array
            if (arr[a] == 0) arr[a] = i + 1; // If the number is seen for the first time, store its index
            else {
                last = Math.max(last, arr[a]); // Update the last repeated element's index
                arr[a] = i + 1; // Update the index of the current number
            }
        }
        return (last > 0) ? (int) Math.ceil(last / 3.0) : 0; // Calculate and return the result
    }
}