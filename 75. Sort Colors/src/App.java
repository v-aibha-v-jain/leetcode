public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {2,0,2,1,1,0};
        solution.sortColors(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
class Solution {
    public void sortColors(int[] nums) {
        int start = 0; // pointer to traverse the array
        int end  = nums.length - 1; // pointer to the end of the array
        int pivot = 0; // pointer to place 0s
        while(start <= end){
            if(nums[start] == 0){
                int temp = 0; // temporary variable for swapping
                temp = nums[start];
                nums[start] = nums[pivot]; // swap 0 to the front
                nums[pivot] = temp;
                pivot++; // move pivot forward after placing 0
                start++; // move start forward
            }
            else if(nums[start] == 1)
                start++; // skip 1s
            else{
                int temp = 0; // temporary variable for swapping
                temp = nums[start];
                nums[start] = nums[end]; // swap 2 to the end
                nums[end] = temp;
                end--; // move end backward after placing 2
            }
        }
    }
}