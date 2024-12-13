import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {2,1,3,4,5,2};
        System.out.println(obj.findScore(nums));
    }
}
class Solution {
    public long findScore(int[] nums) {
        int arr[][] = new int[nums.length][2]; // create a 2D array to store numbers and their indices
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i]; // store the number
            arr[i][1] = i; // store the index
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]); // sort the array based on the numbers
        boolean mark[] = new boolean[nums.length]; // create a boolean array to mark visited indices
        long score = 0; // initialize score to 0
        for (int i = 0; i < nums.length; i++) {
            if (mark[arr[i][1]] == false) { // if the current index is not marked
            score += arr[i][0]; // add the number to the score
            if ((arr[i][1] - 1) >= 0)
                mark[arr[i][1] - 1] = true; // mark the previous index
            if ((arr[i][1] + 1) < nums.length)
                mark[arr[i][1] + 1] = true; // mark the next index
            }
        }
        return score; // return the final score
    }
}