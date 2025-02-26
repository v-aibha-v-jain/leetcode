public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,7,9,3,1};
        System.out.println(obj.rob(nums));
    }
}
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0; // if there are no houses, return 0
        if (nums.length == 1) return nums[0]; // if there is only one house, return its value
        int max = 0; // initialize max to 0
        int secondLast = 0, last = nums[0]; // initialize secondLast to 0 and last to the value of the first house
        for (int i = 1; i < nums.length; i++) { // iterate through the houses starting from the second one
            max = Math.max(secondLast + nums[i], last); // calculate the maximum money that can be robbed up to the current house
            secondLast = last; // update secondLast to the value of last
            last = max; // update last to the value of max
        }
        return max; // return the maximum money that can be robbed
    }
}