public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int nums[] = {0,1,2,2,5,7};
        int maximumBit = 3;
        int ans[] = obj.getMaximumXor(nums, maximumBit);
        for(int i:ans) System.out.print(i+" ");
    }
}
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int ans[] = new int[nums.length];
        int currXor = 0;
        int maxXor = (1<<maximumBit)-1; //Maximum XOR possible
        for(int i:nums) currXor^=i; //XOR of all elements
        for(int i=0;i<nums.length;i++){
            ans[i] = currXor^maxXor; //XOR of all elements and maximum XOR possible
            currXor^=nums[nums.length-i-1]; //Remove the last element
        }
        return ans;
    }
}