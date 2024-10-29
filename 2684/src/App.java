import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] grid = {{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}};
        int ans = solution.maxMoves(grid);
        System.out.println(ans);
    }
}
class Solution {
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col]; // the maximum moves from (i, j) to the right-bottom corner
        for (int[] d : dp) {
            Arrays.fill(d, 1);
        }
        for (int j = col - 2; j >= 0; j--) {
            for (int i = 0; i < row; i++) {
                int val = grid[i][j];
                int maxMove = val < grid[i][j + 1] ? dp[i][j + 1] : 0;
                if (i < row - 1) {
                    maxMove = Math.max(maxMove, val < grid[i + 1][j + 1] ? dp[i + 1][j + 1] : 0);
                }
                if (i > 0) {
                    maxMove = Math.max(maxMove, val < grid[i - 1][j + 1] ? dp[i - 1][j + 1] : 0);
                }
                dp[i][j] = 1 + maxMove;
            }
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            ans = Math.max(ans, dp[i][0]);
        }
        return ans - 1;
    }
}