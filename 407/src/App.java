import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] heightMap = {
            {1, 4, 3, 1, 3, 2},
            {3, 2, 1, 3, 2, 4},
            {2, 3, 3, 2, 3, 1}
        };
        Solution solution = new Solution();
        int result = solution.trapRainWater(heightMap);
        System.out.println("Water trapped: " + result);
    }
}
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0; // return 0 if the heightMap is empty
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
            if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                minHeap.offer(new int[] {heightMap[i][j], i, j}); // add boundary cells to the minHeap
                visited[i][j] = true; // mark boundary cells as visited
            }
            }
        }
        int[] directions = {-1, 0, 1, 0, -1}; // directions for moving up, right, down, left
        int waterTrapped = 0;
        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll(); // get the cell with the minimum height
            int height = cell[0];
            int x = cell[1];
            int y = cell[2];
            for (int i = 0; i < 4; i++) {
            int nx = x + directions[i]; // calculate new x coordinate
            int ny = y + directions[i + 1]; // calculate new y coordinate
            if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) {
                continue; // skip if out of bounds or already visited
            }
            if (heightMap[nx][ny] < height) {
                waterTrapped += height - heightMap[nx][ny]; // calculate trapped water
            }
            visited[nx][ny] = true; // mark the cell as visited
            minHeap.offer(new int[] {Math.max(heightMap[nx][ny], height), nx, ny}); // add the cell to the minHeap
            }
        }
        return waterTrapped; // return the total water trapped
    }
}