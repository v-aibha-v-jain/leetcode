public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(obj.searchInsert(nums, target));
    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0; // initialize left pointer
        int right = nums.length - 1; // initialize right pointer
        while (left <= right) { // binary search loop
            int mid = (left + right) / 2; // calculate mid index
            if (nums[mid] == target) { // check if mid element is the target
                return mid; // return mid index if target is found
            } else if (target > nums[mid]) { // if target is greater than mid element
                left = mid + 1; // move left pointer to mid + 1
            } else { // if target is less than mid element
                right = mid - 1; // move right pointer to mid - 1
            }
        }
        return left; // return left pointer as the insert position
    }
}