public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println(obj.numIslands(grid));
    }
}
class Solution {
    public static void helper(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return; // base case for recursion
        int arr1[] = {-1, 0, 1, 0}; // direction array for row movement
        int arr2[] = {0, 1, 0, -1}; // direction array for column movement
        grid[i][j] = '0'; // mark the cell as visited
        for (int k = 0; k < 4; k++) { // explore all 4 directions
            int first = i + arr1[k]; // new row index
            int second = j + arr2[k]; // new column index
            helper(grid, first, second); // recursive call for the next cell
        }
    }

    public int numIslands(char[][] grid) {
        int count = 0; // initialize island count
        for (int i = 0; i < grid.length; i++) { // iterate over all rows
            for (int j = 0; j < grid[0].length; j++) { // iterate over all columns
                if (grid[i][j] == '1') { // if cell is land
                    helper(grid, i, j); // call helper to mark all connected land
                    count++; // increment island count
                }
            }
        }
        return count; // return the total number of islands
    }
}