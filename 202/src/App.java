import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 19;
        boolean result = solution.isHappy(n);
        System.out.println(result);
    }
}
class Solution {
    public boolean isHappy(int n) { // method to determine if a number is a happy number
        HashSet<Integer> seen = new HashSet<>(); // set to keep track of seen numbers
        while (n != 1 && !seen.contains(n)) { // loop until n is 1 or a cycle is detected
            seen.add(n); // add the current number to the set
            n = getSumOfSquares(n); // update n to the sum of squares of its digits
        }
        return n == 1; // return true if n is 1, false otherwise
    }

    public static int getSumOfSquares(int num) { // method to calculate the sum of squares of digits
        int sum = 0; // initialize sum to 0
        while (num > 0) { // loop until num is 0
            int digit = num % 10; // get the last digit of num
            sum += digit * digit; // add the square of the digit to sum
            num /= 10; // remove the last digit from num
        }
        return sum; // return the calculated sum
    }
}