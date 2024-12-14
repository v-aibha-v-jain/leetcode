import java.util.ArrayDeque;
import java.util.Deque;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {5,4,2,4};
        long result = solution.continuousSubarrays(nums);
        System.out.println(result);
    }
}
class Solution {
    public long continuousSubarrays(int[] nums) {
        if (nums == null) return 0L; // return 0 if nums is null
        int n = nums.length; // get the length of nums
        long cnt = 0; // initialize count of subarrays
        Deque<Integer> minDq = new ArrayDeque<>(); // deque to store indices of minimum elements
        Deque<Integer> maxDq = new ArrayDeque<>(); // deque to store indices of maximum elements
        int left = 0; // initialize left pointer
        for (int right = 0; right < n; right++) { // iterate over nums with right pointer
            while (!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[right]) maxDq.pollLast(); // maintain decreasing order in maxDq
            maxDq.addLast(right); // add current index to maxDq
            while (!minDq.isEmpty() && nums[minDq.peekLast()] > nums[right]) minDq.pollLast(); // maintain increasing order in minDq
            minDq.addLast(right); // add current index to minDq
            while (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > 2) { // check if the difference exceeds 2
            if (maxDq.peekFirst() == left) maxDq.pollFirst(); // remove left index from maxDq if it matches
            if (minDq.peekFirst() == left) minDq.pollFirst(); // remove left index from minDq if it matches
            left++; // move left pointer to the right
            }
            cnt += right - left + 1; // count the number of valid subarrays ending at right
        }
        return cnt; // return the total count of subarrays
    }
}