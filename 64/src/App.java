public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(obj.minPathSum(grid));
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length; // number of rows in the grid
        int col = grid[0].length; // number of columns in the grid
        int[][] dp = new int[row][col]; // create a dp array to store the minimum path sum
        dp[0][0] = grid[0][0]; // initialize the starting point
        for(int i = 1; i < col; i++) dp[0][i] = dp[0][i-1] + grid[0][i]; // fill the first row
        for(int i = 1; i < row; i++) dp[i][0] = dp[i-1][0] + grid[i][0]; // fill the first column
        for(int i = 1; i < row; i++) // iterate through the rows
            for(int j = 1; j < col; j++) // iterate through the columns
                dp[i][j] = Math.min((grid[i][j] + dp[i-1][j]), grid[i][j] + dp[i][j-1]); // calculate the minimum path sum
        return dp[row-1][col-1]; // return the minimum path sum to reach the bottom-right corner
    }
}