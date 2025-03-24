public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] gain = {-5, 1, 5, 0, -7};
        int result = solution.largestAltitude(gain);
        System.out.println(result);
    }
}
class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0; // Initialize max altitude to 0
        int[] res = new int[gain.length + 1]; // Create an array to store altitudes
        res[0] = 0; // Starting altitude is 0
        for (int i = 1; i < res.length; i++) { // Iterate through the gain array
            res[i] = res[i - 1] + gain[i - 1]; // Calculate the current altitude
            max = Math.max(max, res[i]); // Update max altitude if current altitude is higher
        }
        return max; // Return the highest altitude
    }
}