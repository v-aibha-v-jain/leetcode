public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,0,2};
        int[][] queries = {{0, 2, 1}, {0, 2, 1}, {1, 1, 3}};
        System.out.println(obj.minZeroArray(nums, queries));
    }
}
class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1]; // difference array to keep track of increments
        int k = 0; // number of queries used
        int sum = 0; // current sum of the array
        for(int i = 0; i < n; i++) {
            while(sum + diff[i] < nums[i]) { // while current sum is less than nums[i]
                k++; // increment the number of queries used
                if(k > queries.length) return -1; // if queries are exhausted, return -1
                int l = queries[k-1][0]; // left index of the query
                int r = queries[k-1][1]; // right index of the query
                int val = queries[k-1][2]; // value to be added
                if(r >= i) { // if the right index is greater than or equal to current index
                    diff[Math.max(l, i)] += val; // add value to the difference array
                    diff[r+1] -= val; // subtract value from the difference array
                }
            }
            sum += diff[i]; // update the current sum
        }
        return k; // return the number of queries used
    }
}