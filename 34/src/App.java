public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = obj.searchRange(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1}; // Initialize result array with -1, -1
        res[0] = lol(nums, target, true); // Find the first occurrence of target
        res[1] = lol(nums, target, false); // Find the last occurrence of target
        return res; // Return the result array
    }

    private int lol(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1; // Initialize left and right pointers
        int point = -1; // Initialize point to -1
        while (left <= right) { // Binary search loop
            int mid = left + (right - left) / 2; // Calculate mid index
            if (nums[mid] == target) { // If mid element is target
                point = mid; // Update point to mid
                if (isFirst) { // If searching for first occurrence
                    right = mid - 1; // Move right pointer to mid - 1
                } else { // If searching for last occurrence
                    left = mid + 1; // Move left pointer to mid + 1
                }
            } else if (nums[mid] < target) { // If mid element is less than target
                left = mid + 1; // Move left pointer to mid + 1
            } else { // If mid element is greater than target
                right = mid - 1; // Move right pointer to mid - 1
            }
        }
        return point; // Return the found index or -1
    }
}
