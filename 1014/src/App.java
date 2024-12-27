public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] values = {8,1,5,2,6};
        System.out.println(obj.maxScoreSightseeingPair(values));
    }
}
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length; // get the length of the array
        int prevMax = values[n-1] - 1; // initialize prevMax with the last element minus 1
        int ans = Integer.MIN_VALUE; // initialize ans with the minimum integer value
        for (int i = n - 2; i >= 0; i--) { // iterate from the second last element to the first
            ans = Math.max(ans, prevMax + values[i]); // update ans with the maximum value of ans and prevMax + current element
            prevMax = Math.max(values[i] - 1, prevMax - 1); // update prevMax with the maximum value of current element minus 1 and prevMax minus 1
        }
        return ans; // return the maximum score
    }
}