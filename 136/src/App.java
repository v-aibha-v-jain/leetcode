public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,2,1};
        System.out.println(obj.singleNumber(nums));
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0; // Initialize result to 0
        for (int num : nums) // Iterate through each number in the array
            result ^= num; // XOR the result with the current number
        return result; // Return the single number
    }
}