public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
class Solution {
    private boolean isPossibleToSteal(int[] amounts, int maxValue, int k) {
        int currentIndex = 0;
        int n = amounts.length;
        int count = 0;
        while (currentIndex < n) {
            if (amounts[currentIndex] <= maxValue) { // check if the current house can be robbed
                count++; // increment count if the house is robbed
                currentIndex += 2; // skip the next house to avoid adjacent robbery
            } 
            else currentIndex++; // move to the next house if current house can't be robbed
        }
        return count >= k; // return true if at least k houses can be robbed
    }

    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE; // initialize the minimum value
        int r = 0; // initialize the maximum value
        for (int num : nums) {
            r = Math.max(r, num); // find the maximum value in the array
            l = Math.min(l, num); // find the minimum value in the array
        }
        int ans = r; // initialize the answer with the maximum value
        while (l <= r) {
            int mid = l + ((r - l) >> 1); // calculate the mid value
            if (isPossibleToSteal(nums, mid, k)) { // check if it's possible to rob k houses with mid as maxValue
                ans = mid; // update the answer to the current mid value
                r = mid - 1; // search in the left half
            } 
            else l = mid + 1; // search in the right half
        }
        return ans; // return the minimum capability required
    }
}