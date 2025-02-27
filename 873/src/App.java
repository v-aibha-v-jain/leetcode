public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {1,2,3,4,5,6,7,8};
        System.out.println(obj.lenLongestFibSubseq(arr));
    }
}
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length; // length of the input array
        int[][] dp = new int[n][n]; // 2D array to store the length of Fibonacci subsequence
        int max = 0; // variable to store the maximum length of Fibonacci subsequence
        for (int cur = 2; cur < n; cur++) { // iterate from the third element to the end of the array
            int start = 0, end = cur - 1; // initialize start and end pointers
            while (start < end) { // loop until start is less than end
                int pairSum = arr[start] + arr[end]; // calculate the sum of elements at start and end
                if (pairSum > arr[cur]) { // if pairSum is greater than the current element
                    end--; // move the end pointer to the left
                } 
                else if (pairSum < arr[cur]) { // if pairSum is less than the current element
                    start++; // move the start pointer to the right
                } 
                else { // if pairSum is equal to the current element
                    dp[end][cur] = dp[start][end] + 1; // update the dp array with the length of the subsequence
                    max = Math.max(dp[end][cur], max); // update the maximum length
                    end--; // move the end pointer to the left
                    start++; // move the start pointer to the right
                }
            }
        }
        return max == 0 ? 0 : max + 2; // return the maximum length of the Fibonacci subsequence
    }
}