import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {2,1,1,5,6,2,3,1};
        int res = solution.minimumMountainRemovals(nums);
        System.out.println(res);
    }
}
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] lis = new int[nums.length]; // longest increasing subsequence
        int[] lds = new int[nums.length]; // longest decreasing subsequence
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        for (int i = 1; i < nums.length; i++) 
            for (int j = 0; j < i; j++) 
                if (nums[i] > nums[j] && lis[j] + 1 > lis[i]) // increasing
                    lis[i] = lis[j] + 1; // update lis
        int max = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] > nums[j] && lds[j] + 1 > lds[i]) { // decreasing
                    lds[i] = lds[j] + 1;
                }
            }
            if (lis[i] > 1 && lds[i] > 1) { // both increasing and decreasing
                max = Math.max(lis[i] + lds[i] - 1, max); // update max
            }
        }
        return nums.length - max;
    }
}