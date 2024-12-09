public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {3, 4, 1, 2, 6};
        int[][] queries = {{0, 4}};
        boolean[] res = solution.isArraySpecial(nums, queries);
        for (boolean b : res) {
            System.out.println(b);
        }
    }
}
class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] sliceAssignment = new int[nums.length];
        int sliceNum = 0;
        sliceAssignment[0] = sliceNum; // initialize the first slice
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] + nums[i - 1]) % 2 == 0) {
            sliceNum++; // increment slice number if the sum of adjacent elements is even
            }
            sliceAssignment[i] = sliceNum; // assign the current slice number
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = sliceAssignment[queries[i][0]] == sliceAssignment[queries[i][1]]; // check if both indices belong to the same slice
        }
        return res;
    }
}