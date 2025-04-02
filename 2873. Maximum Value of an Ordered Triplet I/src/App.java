public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] nums = {12, 6, 1, 2, 7};
        long result = solution.maximumTripletValue(nums);
        System.out.println("Maximum Triplet Value: " + result);
    }
}
class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxTriplet = 0, maxElement = 0, maxDiff = 0;
        for (int num : nums) {
            maxTriplet = Math.max(maxTriplet, maxDiff * num); // update maxTriplet with the maximum value of maxDiff * num
            maxDiff = Math.max(maxDiff, maxElement - num); // update maxDiff with the maximum difference between maxElement and num
            maxElement = Math.max(maxElement, num); // update maxElement with the maximum value encountered so far
        }
        return maxTriplet; // return the maximum triplet value
    }
}