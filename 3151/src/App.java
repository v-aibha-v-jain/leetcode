public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(obj.isArraySpecial(nums));
    }
}
class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;
        for (int i=1; i<nums.length; i++){
            if((nums[i-1] % 2 == 0 && nums[i] %2 != 0) || (nums[i]%2 ==0 &&nums[i-1]%2!=0)) continue;
            else return false;
        }
        return true;
    }
}