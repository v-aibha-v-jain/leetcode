import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println(obj.lengthOfLIS(nums));
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int lis[] = new int[nums.length]; // Create an array to store the length of the longest increasing subsequence ending at each index
        for(int i=0; i<nums.length; i++)
            lis[i] = 1; // Initialize each position with 1, as the minimum length of LIS ending at each index is 1
        for(int i=nums.length-1; i>=0; i--){ // Iterate from the end of the array to the beginning
            for(int j=i+1; j<nums.length; j++){ // Check all elements after the current element
                if(nums[i]<nums[j]) // If the current element is less than the next element
                    lis[i] = Math.max(lis[i],1+lis[j]); // Update the LIS length at the current index
            }
        }
        Arrays.sort(lis); // Sort the LIS array to find the maximum value
        return lis[lis.length-1]; // Return the maximum value in the LIS array
    }
}