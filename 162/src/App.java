public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1,2,3,1};
        System.out.println(obj.findPeakElement(nums));
    }
}
class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length; // get the length of the array
        int start = 1; // initialize start to 1
        int peak = -1; // initialize peak to -1
        int end = n - 2; // initialize end to the second last index
        if (nums.length == 1) return 0; // if there is only one element, return 0
        if (nums[0] > nums[1]) return 0; // if the first element is greater than the second, return 0
        if (nums[n - 1] > nums[n - 2]) return n - 1; // if the last element is greater than the second last, return the last index
        while (end >= start) { // binary search loop
            int mid = (start + end) / 2; // calculate the middle index
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) { // if mid element is greater than its neighbors
                peak = mid; // set peak to mid
                return peak; // return peak
            } else if (nums[mid] > nums[mid - 1]) start = mid + 1; // if mid element is greater than the previous element, move start to mid + 1
            else end = mid - 1; // otherwise, move end to mid - 1
        }
        return peak; // return peak
    }
}