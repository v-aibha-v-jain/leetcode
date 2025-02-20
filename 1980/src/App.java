import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        String[] nums = {"00", "01"};
        String result = solution.findDifferentBinaryString(nums);
        System.out.println(result);
    }
}
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>(); // Create a set to store the decimal values of binary strings
        int n = nums.length; // Get the length of the input array
        for (int i = 0; i < n; i++) {
            int decimal = Integer.parseInt(nums[i], 2); // Convert binary string to decimal
            set.add(decimal); // Add the decimal value to the set
        }
        for (int num = 0; num <= n; num++) {
            if (!set.contains(num)) { // Check if the decimal value is not in the set
                String res = Integer.toBinaryString(num); // Convert the decimal value back to binary string
                int m = res.length(); // Get the length of the binary string
                StringBuilder result = new StringBuilder(); // Create a StringBuilder to build the result
                for (int i = 0; i < n - m; i++) result.append('0'); // Append leading zeros to match the length
                result.append(res); // Append the binary string
                return result.toString(); // Return the result
            }
        }
        return ""; // Return an empty string if no different binary string is found
    }
}