import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[] digits = {2, 1, 3, 0};
        int[] result = solution.findEvenNumbers(digits);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>(); // To store unique 3-digit even numbers
        int n = digits.length; // Length of the input array
        for (int i = 0; i < n; i++) { // Loop for the hundreds place
            for (int j = 0; j < n; j++) { // Loop for the tens place
                for (int k = 0; k < n; k++) { // Loop for the units place
                    if (i == j || i == k || j == k) continue; // Skip if indices are the same
                    int num = (digits[i] * 100) + (digits[j] * 10) + digits[k]; // Form the 3-digit number
                    if (num % 2 == 0 && digits[i] != 0) set.add(num); // Add to set if even and doesn't start with 0
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set); // Convert set to list
        Collections.sort(list); // Sort the list in ascending order
        int[] result = new int[list.size()]; // Create result array
        for (int i = 0; i < result.length; i++) { // Copy sorted list to result array
            result[i] = list.get(i);
        }
        return result; // Return the result array
    }
}