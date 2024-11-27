import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(); // create a new HashSet to store unique numbers
        for (int i = 0; i < nums.length; i++) { // iterate through the array
            set.add(nums[i]); // add each number to the set
        }
        int max = 0; // initialize max to 0
        for (int i = 0; i < nums.length; i++) { // iterate through the array again
            if (!set.contains(nums[i] - 1)) { // check if the previous number is not in the set
                int cnt = 1; // initialize count to 1
                int n = nums[i]; // get the current number
                while (set.contains(n + 1)) { // check if the next number is in the set
                    cnt++; // increment count
                    n++; // move to the next number
                }
                max = Math.max(cnt, max); // update max if count is greater
            }
        }
        return max; // return the maximum length of consecutive sequence
    }
}