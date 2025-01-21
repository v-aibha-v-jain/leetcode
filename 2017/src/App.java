public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] grid = {{2, 5, 4}, {1, 5, 1}};
        long result = obj.gridGame(grid);
        System.out.println(result);
    }
}
class Solution {
    public long gridGame(int[][] grid) {
        long row1 = 0; // Initialize the sum of the first row
        int col_len = grid[0].length; // Get the number of columns
        for(int i = 0; i < col_len; i++){
            row1 += (long)(grid[0][i]); // Sum up all elements in the first row
        }
        long mini = Long.MAX_VALUE; // Initialize the minimum value to the maximum possible value
        long upper_row = 0, lower_row = 0; // Initialize the sums for the upper and lower rows
        for(int i = 0; i < col_len; i++){
            row1 -= (long)(grid[0][i]); // Subtract the current element from the first row sum
            upper_row = row1; // Update the upper row sum
            lower_row += i > 0 ? (long)(grid[1][i - 1]) : 0L; // Update the lower row sum if not the first column
            mini = Math.min(mini, Math.max(upper_row, lower_row)); // Update the minimum value with the maximum of the upper and lower row sums
        }
        return mini; // Return the minimum value
    }
}