public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] result = solution.buildArray(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length; // get the length of the input array
        int[] ans = new int[n]; // create a new array to store the result
        for (int i = 0; i < n; ++i) { // iterate through each index of the array
            ans[i] = nums[nums[i]]; // set ans[i] to the value at nums[nums[i]]
        }
        return ans; // return the resulting array
    }
}