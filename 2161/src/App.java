public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {9, 12, 3, 5, 14, 10, 10};
        int pivot = 10;
        int[] ans = obj.pivotArray(nums, pivot);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length]; // create an array to store the result
        int m = 0; // initialize a pointer for the result array
        for(int i=0; i<nums.length; i++){
            if(nums[i] < pivot){
            ans[m] = nums[i]; // add elements less than pivot to the result array
            m++; // move the pointer
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == pivot){
            ans[m] = nums[i]; // add elements equal to pivot to the result array
            m++; // move the pointer
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > pivot){
            ans[m] = nums[i]; // add elements greater than pivot to the result array
            m++; // move the pointer
            }
        }
        return ans; // return the result array
    }
}