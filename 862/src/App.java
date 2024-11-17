public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2, -1, 2};
        int k = 3;
        System.out.println(obj.shortestSubarray(nums, k));
    }
}
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for(int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i]; // calculate prefix sums
        int[] que = new int[n + 1];
        int l = 0, r = 0;
        int minlength = n + 1;
        for(int i = 0; i < sum.length; i++){
            while(r > l && sum[i] >= sum[que[l]] + k)
                minlength = Math.min(minlength, i - que[l++]); // update minlength
            while(r > l && sum[i] <= sum[que[r - 1]])
                r--; // maintain deque
            que[r++] = i; // add current index to deque
        }
        return minlength <= n ? minlength : -1; // return result
    }
}