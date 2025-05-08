import java.util.Arrays;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] moveTime = {
            {0, 4},
            {4, 4}
        };
        int result = solution.minTimeToReach(moveTime);
        System.out.println("Minimum time to reach the last room: " + result); // Expected output: 21
    }
}
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length; // number of rows in the grid
        int cols = moveTime[0].length; // number of columns in the grid
        int[][] timeToReach = new int[rows][cols]; // stores minimum time to reach each cell
        for (int[] row : timeToReach) {
            Arrays.fill(row, Integer.MAX_VALUE); // initialize all cells with maximum time
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap to process cells by time
        pq.offer(new int[]{0, 0, 0, 1}); // start from the top-left corner with time 0 and stepTime 1
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // possible movement directions
        while (!pq.isEmpty()) {
            int[] current = pq.poll(); // get the cell with the smallest time
            int currentTime = current[0]; // current time to reach this cell
            int currentRow = current[1]; // current row index
            int currentCol = current[2]; // current column index
            int stepTime = current[3]; // current step time (1 or 2)
            if (currentRow == rows - 1 && currentCol == cols - 1) {
                return currentTime; // return time if the last cell is reached
            }
            for (int[] direction : directions) {
                int newRow = currentRow + direction[0]; // calculate new row index
                int newCol = currentCol + direction[1]; // calculate new column index
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) { // check if within bounds
                    int newTime = Math.max(currentTime + stepTime, moveTime[newRow][newCol] + stepTime); // calculate new time
                    if (newTime < timeToReach[newRow][newCol]) { // update if new time is smaller
                        timeToReach[newRow][newCol] = newTime; // update minimum time to reach this cell
                        pq.offer(new int[]{newTime, newRow, newCol, stepTime == 1 ? 2 : 1}); // add to queue with toggled stepTime
                    }
                }
            }
        }
        return -1; // return -1 if the last cell cannot be reached
    }
}