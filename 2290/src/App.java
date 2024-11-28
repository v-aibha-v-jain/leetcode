import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] grid = {{0, 1, 1}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(obj.minimumObstacles(grid));
    }
}
class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length; // get the number of rows
        int m = grid[0].length; // get the number of columns
        int[] dx = {-1, 0, 1, 0}; // direction array for row movement
        int[] dy = {0, 1, 0, -1}; // direction array for column movement
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // priority queue to store the cells
        boolean[][] vis = new boolean[n][m]; // visited array to mark visited cells
        pq.add(new int[]{grid[0][0], 0, 0}); // add the starting cell to the queue
        vis[0][0] = true; // mark the starting cell as visited
        while (!pq.isEmpty()) { // while the queue is not empty
            int[] curr = pq.poll(); // get the cell with the minimum obstacles
            int steps = curr[0]; // get the number of obstacles to reach this cell
            int x = curr[1]; // get the row index of the cell
            int y = curr[2]; // get the column index of the cell
            if (x == n - 1 && y == m - 1) { // if we reached the bottom-right cell
                return steps; // return the number of obstacles
            }
            for (int i = 0; i < 4; i++) { // for each direction
                int nx = x + dx[i]; // calculate the new row index
                int ny = y + dy[i]; // calculate the new column index
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) { // if the new cell is within bounds and not visited
                    vis[nx][ny] = true; // mark the new cell as visited
                    pq.add(new int[]{steps + grid[nx][ny], nx, ny}); // add the new cell to the queue with updated obstacles
                }
            }
        }
        return -1; // return -1 if there is no path to the bottom-right cell
    }
}