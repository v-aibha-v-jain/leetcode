public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 3};
        int result = solution.subsetXORSum(nums);
        System.out.println(result);
    }
}
class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length; // Get the length of the input array
        int total = 0; // Initialize total XOR sum of all subsets
        int subsetCount = 1 << n; // Calculate the total number of subsets (2^n)
        
        for (int i = 0; i < subsetCount; i++) { // Iterate through all possible subsets
            int xorSum = 0; // Initialize XOR sum for the current subset
            for (int j = 0; j < n; j++) { // Check each element in the array
                if ((i & (1 << j)) != 0) { // If the j-th element is in the current subset
                    xorSum ^= nums[j]; // Add it to the XOR sum
                }
            }
            total += xorSum; // Add the XOR sum of the current subset to the total
        }
        
        return total; // Return the total XOR sum of all subsets
    }
}