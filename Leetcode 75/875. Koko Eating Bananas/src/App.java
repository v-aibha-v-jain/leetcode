import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // minimum possible eating speed
        int right = Arrays.stream(piles).max().orElse(-1); // maximum possible eating speed
        while (left <= right) { // binary search loop
            int mid = left + (right - left) / 2; // calculate mid-point of current range
            int ans = 0; // total hours needed at current speed
            for (int i : piles) {
            ans += Math.ceil((double) i / mid); // calculate hours for each pile at speed 'mid'
            }
            if (ans <= h) // if total hours is within limit
            right = mid - 1; // try smaller speeds
            else
            left = mid + 1; // try larger speeds
        }
        return left; // return the minimum speed that works
    }
}