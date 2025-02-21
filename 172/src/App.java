public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int n = 5;
        System.out.println(obj.trailingZeroes(n));
    }
}
class Solution {
    private static int fun(int n, int k) {
        int cnt = 0; // Initialize count to 0
        while(n > 0) { // Loop until n is greater than 0
            cnt += n / k; // Add the quotient of n divided by k to count
            n /= k; // Update n to be the quotient of n divided by k
        }
        return cnt; // Return the count
    }
    public int trailingZeroes(int n) {
        double ans = Math.min(fun(n, 2), fun(n, 5)); // Find the minimum of the results of fun(n, 2) and fun(n, 5)
        return (int) ans; // Cast the result to int and return
    }
}