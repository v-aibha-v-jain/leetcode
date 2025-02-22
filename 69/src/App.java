public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int x = 8;
        int result = obj.mySqrt(x);
        System.out.println(result);
    }
}
class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x; // If x is less than 2, return x as the square root of 0 or 1 is the number itself
        int left = 1, right = x / 2, ans = 0; // Initialize left to 1, right to x/2, and ans to 0
        while(left <= right) { // Continue the loop while left is less than or equal to right
            int mid = left + (right - left) / 2; // Calculate the mid value to avoid overflow
            long sq = (long) mid * mid; // Calculate the square of mid
            if(sq == x) return mid; // If the square of mid is equal to x, return mid
            else if(sq < x) { // If the square of mid is less than x
                ans = mid; // Update ans to mid
                left = mid + 1; // Move left to mid + 1
            } else { // If the square of mid is greater than x
                right = mid - 1; // Move right to mid - 1
            }
        }
        return ans; // Return the answer
    }
}