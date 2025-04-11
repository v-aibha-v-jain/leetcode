public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution(); // Create an instance of the Solution class
        int low = 1; // Define the lower bound of the range
        int high = 100; // Define the upper bound of the range
        int result = solution.countSymmetricIntegers(low, high); // Call the method to count symmetric integers
        System.out.println("Count of symmetric integers between " + low + " and " + high + ": " + result); // Print the result
    }
}
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0; // Initialize counter for symmetric integers
        for (int i = low; i <= high; i++) { // Iterate through the range [low, high]
            int num = i;
            if (num > 10 && num <= 99) { // Check if the number is a two-digit number
                if (num % 11 == 0) ans++; // Increment if the number is divisible by 11 (symmetric)
            }
            else if (num > 1000 && num <= 9999) { // Check if the number is a four-digit number
                int first = num % 10; // Extract the last digit
                num /= 10; // Remove the last digit
                first += num % 10; // Add the second last digit to 'first'
                num /= 10; // Remove the second last digit
                int second = num % 10; // Extract the third digit
                num /= 10; // Remove the third digit
                second += num % 10; // Add the fourth digit to 'second'
                if (first == second) ans++; // Increment if the sum of first two digits equals the sum of last two digits
            }
        }
        return ans; // Return the count of symmetric integers
    }
}