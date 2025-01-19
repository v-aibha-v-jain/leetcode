import java.util.ArrayDeque;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] grid = {
            {1, 1, 1, 1},
            {2, 2, 2, 2},
            {1, 1, 1, 1},
            {2, 2, 2, 2}
        };
        int result = obj.minCost(grid);
        System.out.println("Minimum cost to make at least one valid path in the grid: " + result);
    }
}
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // directions: right, left, down, up
    public int minCost(int[][] grid) {
        int n = grid.length; // number of rows
        int m = grid[0].length; // number of columns
        boolean[][] vis = new boolean[n][m]; // visited array
        Queue<int[]> q = new ArrayDeque<>(); // queue for BFS
        dfs(grid, 0, 0, 0, q, vis); // start DFS from (0, 0)
        int cost = 0; // initial cost
        while(!vis[n - 1][m - 1]){ // while bottom-right cell is not visited
            cost++; // increment cost
            for (int sz = q.size(); sz > 0; sz--) { // process all nodes in the queue
                int[] cur = q.poll(); // get current node
                int i = cur[0]; // current row
                int j = cur[1]; // current column
                for (int[] dir : dirs) // explore all 4 directions
                    dfs(grid, i + dir[0], j + dir[1], cost, q, vis); // DFS in the new direction
            }
        }
        return cost; // return the minimum cost
    }
    private void dfs(int[][] grid, int i, int j, int cost, Queue<int[]> q, boolean[][] vis) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || vis[i][j]) // if out of bounds or already visited
            return;
        vis[i][j] = true; // mark as visited
        q.add(new int[]{i, j}); // add to queue
        int[] dir = dirs[grid[i][j] - 1]; // get direction based on grid value
        dfs(grid, i + dir[0], j + dir[1], cost, q, vis); // DFS in the new direction
    }
}