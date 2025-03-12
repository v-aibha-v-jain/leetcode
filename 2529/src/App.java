public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {-2,-1,-1,1,2,3};
        System.out.println(obj.maximumCount(nums));
    }
}
class Solution {
    public int maximumCount(int[] nums) {
        int pcount = 0; // Initialize positive count
        int ncount = 0; // Initialize negative count
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) ncount += 1; // Increment negative count if number is less than 0
            else if(nums[i] > 0 && nums[i] != 0) pcount += 1; // Increment positive count if number is greater than 0 and not equal to 0
        }
        return Math.max(pcount, ncount); // Return the maximum of positive and negative counts
    }
}