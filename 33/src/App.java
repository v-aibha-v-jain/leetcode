public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(obj.search(nums, target));
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length; // get the length of the array
        int start = 0, end = n - 1; // initialize start and end pointers
        while (start <= end) { // binary search loop
            int mid = (start + end) / 2; // find the middle index
            if (nums[mid] == target) return mid; // if the middle element is the target, return its index
            if (nums[start] <= nums[mid]) { // if the left half is sorted
                if (nums[start] <= target && target < nums[mid]) end = mid - 1; // if the target is in the left half, move the end pointer
                else start = mid + 1; // otherwise, move the start pointer
            }
            else { // if the right half is sorted
                if (nums[mid] < target && target <= nums[end]) start = mid + 1; // if the target is in the right half, move the start pointer
                else end = mid - 1; // otherwise, move the end pointer
            }
        }
        return -1; // if the target is not found, return -1
    }
}