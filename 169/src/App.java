public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(obj.majorityElement(nums));
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0]; 
        int count = 1; // count of the majority element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                count++; // if the current element is the majority element, increase the count
            } else {
                count--; // if the current element is not the majority element, decrease the count          
                if (count == 0) {
                    num = nums[i]; // if the count is 0, update the majority element
                    count = 1;
                }
            }
        }
        return num;
    }
}

