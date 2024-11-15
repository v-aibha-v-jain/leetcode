public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {1,2,3,10,4,2,3,5};
        int result = obj.findLengthOfShortestSubarray(arr);
        System.out.println(result);
    }
}
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) // find the first decreasing element from the end
            right--;
        int ans = right; // initial answer is the length of the right subarray
        while (left < right && (left == 0 || arr[left] >= arr[left - 1])) { // find the first decreasing element from the start
            while (right < arr.length && arr[left] > arr[right]) // move right pointer to find a valid subarray
                right++;
            ans = Math.min(ans, right - left - 1); // update the answer with the minimum length
            left++; // move left pointer to the next element
        }
        return ans; // return the length of the shortest subarray to remove
    }
}