public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 2, 2, 1, 1, 0};
        int[] result = obj.applyOperations(nums);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] applyOperations(int[] nums) {
        int nz = 0; // Initialize the non-zero index
        int n = nums.length; // Get the length of the array
        for(int i=0; i<n; i++) {
            if(i < n-1 && nums[i] != 0 && nums[i] == nums[i+1]) {
                nums[i] *= 2; // Double the current element if it is equal to the next element
                nums[i+1] = 0; // Set the next element to zero
            }
            if(nums[i] != 0) {
                if(i != nz) {
                    int temp = nums[i]; // Swap the current element with the element at the non-zero index
                    nums[i] = nums[nz];
                    nums[nz] = temp;
                }
                nz++; // Increment the non-zero index
            }
        }
        return nums; // Return the modified array
    }
}