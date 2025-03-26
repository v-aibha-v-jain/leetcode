import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] grid = {{2, 4}, {6, 8}};
        int x = 2;
        int answer = solution.minOperations(grid, x);
        System.out.println(answer);
    }
}
class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>(); // List to store all grid elements
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num); // Add each grid element to the list
            }
        }

        int base = list.get(0); // Use the first element as the base for modulo check
        for (int num : list) {
            if ((num - base) % x != 0) { 
                return -1; // Return -1 if any element is not transformable
            }
        }

        Collections.sort(list); // Sort the list to find the median
        int median = list.get(list.size() / 2); // Median minimizes the total operations
        int operations = 0; // Initialize operation count

        for (int num : list) {
            operations += Math.abs(num - median) / x; // Calculate operations for each element
        }

        return operations; // Return the total operations
    }
}