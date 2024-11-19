import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        System.out.println(obj.maximumSubarraySum(nums, k));
    }
}
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length; 
        int l = 0;
        int r = 0;
        Set<Integer> set = new HashSet<>();
        long ans = 0, sum = 0;
        for(r = 0; r < n; r++){
            sum += nums[r]; // add current element to sum
            while((r - l + 1) > k || set.contains(nums[r])){
                sum -= nums[l]; // remove element from sum as window size exceeds k or duplicate found
                set.remove(nums[l]); // remove element from set
                l++; // move left pointer to right
            }
            set.add(nums[r]); // add current element to set
            if(r - l + 1 == k)
                ans = Math.max(ans, sum); // update maximum sum if window size is k
        }
        return ans;
    }
}