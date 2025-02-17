public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,2,3,2};
        System.out.println(obj.singleNumber(nums));
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int flag = 0; // Initialize flag to 0 for each element
            for(int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    flag = 1; // Set flag to 1 if a duplicate is found
                    break; // Exit inner loop if duplicate is found
                }
            }
            if(flag == 0) return nums[i]; // Return the element if no duplicate is found
        }
        return 0; // Return 0 if no single element is found
    }
}