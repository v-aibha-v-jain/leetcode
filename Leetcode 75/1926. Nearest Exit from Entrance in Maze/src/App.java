import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        char[][] maze = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};
        int result = solution.nearestExit(maze, entrance);
        System.out.println("Nearest exit distance: " + result); // Expected output: 3
    }
}
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length; // number of rows in the maze
        int n = maze[0].length; // number of columns in the maze
        int entranceI = entrance[0]; // entrance row index
        int entranceJ = entrance[1]; // entrance column index
        
        int[][] dirArray = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}}; // directions: right, down, up, left
        
        Queue<int[]> queue = new LinkedList<>(); // queue for BFS
        queue.add(new int[]{entranceI, entranceJ, 0}); // add entrance to the queue with distance 0
        
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>(); // set to track visited cells
        visited.add(new Pair<>(entranceI, entranceJ)); // mark entrance as visited
        
        while(!queue.isEmpty()) { // process until queue is empty
            int[] cell = queue.poll(); // get the next cell from the queue
            int x = cell[0]; // current row
            int y = cell[1]; // current column
            int distance = cell[2]; // current distance

            for(int[] dir : dirArray) { // iterate over all possible directions
                int newX = x + dir[0]; // calculate new row
                int newY = y + dir[1]; // calculate new column
                if(newX<0 || newY<0 || newX>m-1 || newY>n-1 || maze[newX][newY] != '.') continue; // skip invalid or blocked cells
                if(visited.contains(new Pair<>(newX, newY))) continue; // skip already visited cells
                if(newX == 0 || newY == 0 || newX == m-1 || newY == n-1) return distance + 1; // if at boundary, return distance
                visited.add(new Pair<>(newX, newY)); // mark cell as visited
                queue.add(new int[]{newX, newY, distance+1}); // add cell to queue with updated distance
            }
        }
        return -1; // return -1 if no exit is found
    }
}