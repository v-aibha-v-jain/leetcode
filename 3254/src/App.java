public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = obj.resultsArray(nums, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length; // length of the input array
        int left = 0; // left pointer
        int max = -1; // maximum value initialized to -1
        int[] result = new int[n - k + 1]; // result array of size n-k+1
        int idx = 0; // index for result array
        for (int i = 0; i < n; i++) {
            if (nums[i] != max + 1) // if current number is not max+1
                left = i; // update left pointer
            max = nums[i]; // update max to current number

            if (i < k - 1) continue; // if window size is less than k, continue
            if (i - left + 1 >= k) // if window size is at least k
                result[idx++] = max; // add max to result array
            else
                result[idx++] = -1; // else add -1 to result array
        }
        return result; // return the result array
    }
}