public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {1, 0, 1};
        int[][] queries = {{0, 2}};
        boolean result = solution.isZeroArray(nums, queries);
        System.out.println(result);
    }
}
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n + 1]; // prefix array for range updates
        for (int[] q : queries){
            prefix[q[0]]--; // decrease at start index
            prefix[q[1] + 1]++; // increase after end index
        }
        int d = 0; // cumulative sum of prefix
        for (int i = 0; i < n; i++){
            d += prefix[i]; // apply prefix sum
            if (Math.max(0, nums[i] + d) != 0) // check if value is not zero after operations
                return false;
        }
        return true; // all values are zero
    }
}