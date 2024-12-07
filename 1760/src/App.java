import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {9};
        int maxOperations = 2;
        System.out.println(obj.minimumSize(nums, maxOperations));
    }
}
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt(); // initialize left and right boundaries
        int answer = right; // initialize answer with the maximum value in nums
        while (left <= right) { // binary search loop
            int mid = (left + right) / 2; // calculate mid point
            int os = 0; // initialize operations count
            for (int n : nums) { // iterate through nums
            os += (n - 1) / mid; // calculate required operations for current mid
            if (os > maxOperations) break; // break if operations exceed maxOperations
            }
            if (os <= maxOperations) { // if operations are within limit
            answer = mid; // update answer
            right = mid - 1; // move right boundary to mid - 1
            } else {
            left = mid + 1; // move left boundary to mid + 1
            }
        }
        return answer; // return the minimum possible size
    }
}