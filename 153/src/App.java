public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {3,4,5,1,2};
        System.out.println(obj.findMin(nums));
    }
}
class Solution {
    public int findMin(int[] nums) {
        int s = 0; // start index
        int e = nums.length-1; // end index
        while(s < e){
            int mid = s + (e - s)/2; // middle index
            if(mid + 1 <= e && nums[mid] > nums[mid+1]) return nums[mid+1]; // if mid element is greater than next element, return next element
            if(mid - 1 >= 0 && nums[mid] < nums[mid-1]) return nums[mid]; // if mid element is smaller than previous element, return mid element
            if(nums[s] >= nums[mid]) e = mid - 1; // if start element is greater than or equal to mid element, search in left half
            else s = mid + 1; // else search in right half
        }
        return nums[0]; // return the first element if no rotation
    }
}