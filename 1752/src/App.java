public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {3,4,5,1,2};
        boolean result = obj.check(nums);
        System.out.println(result);
    }
}
class Solution {
    public boolean check(int[] nums) {
        int n = nums.length; // get the length of the array
        int count = 0; // initialize count to 0
        for(int i = 0; i < n; i++) { // iterate through the array
            if(nums[i] > nums[(i + 1) % n]) { // check if the current element is greater than the next element (with wrap-around)
                count++; // increment count if the condition is true
            }
            if(count > 1) { // if count is greater than 1, return false
                return false;
            }
        }
        return true; // return true if the array is sorted and rotated at most once
    }
}