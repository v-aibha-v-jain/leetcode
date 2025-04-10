public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        System.out.println(solution.numberOfPowerfulInt(1, 6000, 4, "124")); // Example usage
    }
}
class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        long suff = 0L; // Initialize suffix to 0
        for (char c : s.toCharArray()) {
            suff = suff * 10 + c - '0'; // Convert string to numeric suffix
        }
        if (suff > finish) return 0; // If suffix exceeds finish, return 0
        long div = (long) Math.pow(10, s.length()); // Calculate divisor based on string length
        long ps = start / div; // Calculate prefix for start
        long pf = finish / div; // Calculate prefix for finish
        if (finish % div >= suff) pf++; // Adjust prefix for finish if remainder is greater or equal to suffix
        if (start % div > suff) ps++; // Adjust prefix for start if remainder is greater than suffix
        return getAvailNum(pf, limit) - getAvailNum(ps, limit); // Calculate the difference in available numbers
    }

    private long getAvailNum(long num, long limit) {
        if (num == 0) return 0; // If number is 0, return 0
        if (limit == 9) return num; // If limit is 9, return the number directly
        int digits = (int) Math.log10(num); // Calculate the number of digits in the number
        long div = (long) Math.pow(10, digits); // Calculate divisor based on digits
        long res = 0L; // Initialize result to 0
        for (int i = digits; i >= 0; i--) {
            int d = (int) (num / div); // Extract the current digit
            if (d > limit) {
                return res + (long) Math.pow(limit + 1, i + 1); // If digit exceeds limit, return result with adjustment
            } else {
                res += d * (long) Math.pow(limit + 1, i); // Add contribution of the digit to result
            }
            num %= div; // Reduce number by removing the processed digit
            div /= 10; // Reduce divisor for the next digit
        }
        return res; // Return the final result
    }
}