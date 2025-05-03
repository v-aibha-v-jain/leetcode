public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int a = 2;
        int b = 6;
        int c = 5;
        int result = solution.minFlips(a, b, c);
        System.out.println("Minimum flips required: " + result);
    }
}
class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0; // Initialize the count of flips to 0
        while (a != 0 || b != 0 || c != 0) { // Loop until all bits of a, b, and c are processed
            int lastA = a & 1; // Extract the last bit of a
            int lastB = b & 1; // Extract the last bit of b
            int lastC = c & 1; // Extract the last bit of c
            if ((lastA | lastB) != lastC) { // Check if the OR of lastA and lastB matches lastC
                if (lastC == 1) ans += 1; // If lastC is 1, one flip is needed
                else ans += (lastA & lastB) == 1 ? 2 : 1; // If lastC is 0, flip both bits if both are 1, otherwise flip one bit
            }
            a >>= 1; // Right shift a to process the next bit
            b >>= 1; // Right shift b to process the next bit
            c >>= 1; // Right shift c to process the next bit
        }
        return ans; // Return the total number of flips
    }
}