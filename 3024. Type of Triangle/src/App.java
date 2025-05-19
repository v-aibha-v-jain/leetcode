public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {3, 4, 5};
        System.out.println(obj.triangleType(nums));
    }
}
class Solution {
    public String triangleType(int[] nums) {
        if(nums[0]+nums[1]<=nums[2] || nums[1]+nums[2]<=nums[0] || nums[0]+nums[2]<=nums[1]) return "none";
        if(nums[0]==nums[1] && nums[1]==nums[2]) return "equilateral";
        if(nums[0]!=nums[1] && nums[0]!=nums[2] && nums[1]!=nums[2]) return "scalene";
        return "isosceles";
    }
}                          