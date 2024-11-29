import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] grid = { {0, 2, 4}, {3, 2, 1}, {1, 1, 1} };
        int result = obj.minimumTime(grid);
        System.out.println("Minimum time to reach the bottom-right corner: " + result);
    }
}
class Solution {
    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length; // get the dimensions of the grid
        if (grid[0][1] > 1 && grid[1][0] > 1) { // check if the starting point is blocked
            return -1; // return -1 if starting point is blocked
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // create a priority queue to store the cells
        pq.offer(new int[]{0, 0, 0}); // add the starting cell to the queue
        int[][] min = new int[m][n]; // create a 2D array to store the minimum time to reach each cell
        for (int[] r : min) { // iterate over each row in the min array
            Arrays.fill(r, Integer.MAX_VALUE); // fill each row with the maximum integer value
        }
        min[0][0] = 0; // set the starting cell's time to 0
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // define the possible directions to move
        while (!pq.isEmpty()) { // while the priority queue is not empty
            int[] i = pq.poll(); // get the cell with the minimum time
            int t = i[0], x = i[1], y = i[2]; // extract the time, x, and y coordinates
            if (x == m - 1 && y == n - 1) // check if the destination cell is reached
                return t; // return the time if destination is reached
            for (int[] r : dir) { // iterate over each direction
                int nx = x + r[0], ny = y + r[1]; // calculate the new coordinates
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) { // check if the new coordinates are within bounds
                    int nt = t + 1; // increment the time by 1
                    if (nt < grid[nx][ny]) { // check if the new time is less than the grid value
                        int wt = ((grid[nx][ny] - nt + 1) / 2) * 2; // calculate the waiting time
                        nt = nt + wt; // add the waiting time to the new time
                    }
                    if (nt < min[nx][ny]) { // check if the new time is less than the minimum time to reach the new cell
                        min[nx][ny] = nt; // update the minimum time to reach the new cell
                        pq.offer(new int[]{nt, nx, ny}); // add the new cell to the priority queue
                    }
                }
            }
        }
        return -1; // return -1 if the destination is not reachable
    }
}