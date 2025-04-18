import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        int result = solution.orangesRotting(grid);
        System.out.println(result);
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}}; // Directions for adjacent cells (right, down, left, up)
        int time = 0; // Time counter for rotting process
        int row = grid.length; // Number of rows in the grid
        int col = grid[0].length; // Number of columns in the grid
        Queue<int[]> queue = new LinkedList<>(); // Queue to store rotten oranges' positions
        
        // Add all initially rotten oranges to the queue
        for(int i = 0 ; i < row ; i++)
            for(int j = 0 ; j < col ; j++)
                if(grid[i][j] == 2) // If the orange is rotten
                    queue.offer(new int[]{i,j}); // Add its position to the queue
                    
        // Process the queue until all reachable oranges are rotten
        while(!queue.isEmpty()){
            int size = queue.size(); // Number of rotten oranges to process in this time unit
            while(size-- > 0){
                int[] element = queue.poll(); // Get the position of a rotten orange
                for(int[] dir : direction){ // Check all adjacent cells
                    int x = element[0] + dir[0]; // Calculate new row index
                    int y = element[1] + dir[1]; // Calculate new column index
                    if(x >= 0 && y >= 0 && x < row && y < col){ // Check if the cell is within bounds
                        if(grid[x][y] == 1){ // If the orange is fresh
                            grid[x][y] = 2; // Make it rotten
                            queue.offer(new int[]{x, y}); // Add its position to the queue
                        }
                    }
                }
            }
            time++; // Increment time after processing one level of the queue
        }
        
        // Check if there are any fresh oranges left
        for(int i = 0 ; i < row ; i++)
            for(int j = 0 ; j < col ; j++)
                if(grid[i][j] == 1) // If a fresh orange is found
                    return -1; // Return -1 as not all oranges can rot

        return time > 0 ? time - 1 : 0; // Return the total time taken, subtracting 1 if time > 0
    }
}