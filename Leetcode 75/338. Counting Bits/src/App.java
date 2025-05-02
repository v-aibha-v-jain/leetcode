public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int n = 5;
        int[] result = solution.countBits(n);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
class Solution {
    public static int[] countBits(int n) {
        int list[] = new int[n+1]; // Array to store the count of 1s for each number from 0 to n
        for(int i = 0; i <= n; i++) { // Loop through each number from 0 to n
            int num = i; // Current number to calculate 1s
            int count = 0; // Counter for the number of 1s in binary representation
            while(num != 0) { // Loop until the number becomes 0
                count += (num & 1); // Add 1 to count if the last bit is 1
                num >>= 1; // Right shift the number to process the next bit
            }
            list[i] = count; // Store the count of 1s for the current number
        }
        return list; // Return the array containing counts of 1s for all numbers
    }
}