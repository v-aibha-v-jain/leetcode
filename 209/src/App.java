public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(obj.minSubArrayLen(target, nums));
    }
}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+1; // to store the minimum length of the subarray
        int start = 0; // to store the starting index of the subarray
        int sum = 0; // to store the sum of the subarray
        for(int i=0; i< nums.length;i++){
            sum+=nums[i];
            while(sum >= target){ // if the sum is greater than or equal to the target
                min = Math.min(min,i-start+1); // compare the minimium length found before with the current length
                sum-=nums[start++]; // remove the starting element from the sum
            }
        }
        return (min == nums.length+1) ? 0 : min;
    }
}