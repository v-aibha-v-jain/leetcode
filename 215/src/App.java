import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(obj.findKthLargest(nums, k));
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums); // Sort the array in ascending order
        for(int i=0; i<nums.length; i++) System.out.print(nums[i] + " "); // Print the sorted array
        return nums[(nums.length - k)]; // Return the k-th largest element
    }
}