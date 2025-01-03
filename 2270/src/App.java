public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {10,4,-8,7};
        System.out.println(obj.waysToSplitArray(nums));
    }
}
class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int num : nums) sum += num; // calculate the total sum of the array
        int i = 0;
        int cnt = 0; // initialize the count of valid splits
        long n = 0; // initialize the left part sum
        while(i < nums.length-1){
            n += nums[i]; // add the current element to the left part sum
            long r = sum - n; // calculate the right part sum
            if(n >= r) cnt++; // if left part sum is greater than or equal to right part sum, increment the count
            i++; // move to the next element
        }
        return cnt; // return the count of valid splits
    }
}