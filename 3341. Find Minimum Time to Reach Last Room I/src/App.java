import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] moveTime = {
            {0, 4},
            {4, 4}
        };
        int result = solution.minTimeToReach(moveTime);
        System.out.println("Minimum time to reach the last room: " + result); // Expected output: 5
    }
}

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length; // number of rows
        int n = moveTime[0].length; // number of columns
        int[][] dist = new int[m][n]; // distance array to store minimum time to reach each cell
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE); // initialize all distances to infinity
        }
        dist[0][0] = 0; // starting point distance is 0
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); // min-heap based on time
        pq.offer(new int[]{0, 0, 0}); // add starting point to the queue
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // possible directions: up, down, left, right
        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); // get the cell with the smallest time
            int x = curr[0]; // current row
            int y = curr[1]; // current column
            int time = curr[2]; // current time
            if (x == m - 1 && y == n - 1) { // if we reached the last cell
                return time; // return the minimum time
            }
            for (int[] dir : dirs) { // iterate through all possible directions
                int nx = x + dir[0], ny = y + dir[1]; // calculate new position
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) { // check if new position is within bounds
                    int waitTime = Math.max(0, moveTime[nx][ny] - time); // calculate wait time if needed
                    int arriveTime = time + 1 + waitTime; // calculate arrival time
                    if (arriveTime < dist[nx][ny]) { // if new time is better than the current distance
                        dist[nx][ny] = arriveTime; // update distance
                        pq.offer(new int[]{nx, ny, arriveTime}); // add new position to the queue
                    }
                }
            }
        }
        return -1; // return -1 if the last cell is not reachable
    }
}