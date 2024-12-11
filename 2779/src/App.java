import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {4,6,1,2};
        int k = 2;
        System.out.println(obj.maximumBeauty(nums, k));
    }
}
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array
        int n = nums.length;
        int s = 0, max = 0;
        for(int i = 0; i < n; i++) {
            while(s <= i && nums[i] - nums[s] > 2 * k) // Check if the difference exceeds 2*k
                s++; // Move the start pointer
            max = Math.max(max, i - s + 1); // Update the maximum length
        }
        return max; // Return the maximum beauty
    }
}