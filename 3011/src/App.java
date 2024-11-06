public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {8, 4, 2, 30, 15};
        System.out.println(obj.canSortArray(nums));
    }
}
class Solution {
    public boolean canSortArray(int[] nums) {
        int cMin, cMax, cBitCount, lMax; 
        lMax = 0 ;
        cMin = cMax = nums[0]; 
        cBitCount = Integer.bitCount(nums[0]); 
        for(int i = 1; i<nums.length; i++){
            int bitCount = Integer.bitCount(nums[i]); 
            if(cBitCount == bitCount){
                cMin = Math.min(cMin, nums[i]); 
                cMax = Math.max(cMax, nums[i]); 
            }else {
                if(lMax > cMin)
                    return false; 
                lMax = cMax;  
                cBitCount = bitCount; 
                cMax = nums[i];
                cMin = nums[i]; 
            }
        }
        return lMax < cMin ;
    }
}