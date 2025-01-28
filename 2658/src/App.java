public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] grid = {
            {0, 2, 1, 0},
            {4, 0, 0, 3},
            {1, 0, 0, 4},
            {0, 3, 2, 0}
        };
        int maxFish = solution.findMaxFish(grid);
        System.out.println("Maximum fish: " + maxFish);
    }
}
class Solution {
    int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0; // return 0 if out of bounds or cell is 0
        }
        int curr = grid[i][j]; // store current cell value
        grid[i][j] = 0; // mark cell as visited
        int res = curr; // initialize result with current cell value
        res = curr + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1); // sum up values from all 4 directions
        return res; // return the total sum
    }

    public int findMaxFish(int[][] grid) {
        int res = 0; // initialize result to 0
        for (int i = 0; i < grid.length; i++) { // iterate over all rows
            for (int j = 0; j < grid[0].length; j++) { // iterate over all columns
                if (grid[i][j] == 0) continue; // skip if cell is 0
                res = Math.max(res, dfs(grid, i, j)); // update result with maximum value
            }
        }
        return res; // return the maximum fish count
    }
}