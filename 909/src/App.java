import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] board = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };
        int result = solution.snakesAndLadders(board);
        System.out.println("Minimum moves to reach the end: " + result);
    }
}
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length; // get the size of the board
        if (n == 0) return -1; // if the board is empty, return -1
        Queue<int[]> q = new LinkedList<>(); // create a queue to store positions and moves
        q.add(new int[] { 1, 0 }); // start from position 1 with 0 moves
        boolean[] visited = new boolean[(n * n) + 1]; // create a visited array to track visited positions
        visited[1] = true; // mark the start position as visited
        while (!q.isEmpty()) { // while there are positions to process
            int[] curr = q.poll(); // get the current position and move count
            int currPos = curr[0]; // current position
            int currMove = curr[1]; // current move count
            if (currPos == n * n) return currMove; // if reached the last position, return the move count
            for (int dice = 1; dice <= 6; dice++) { // simulate dice roll from 1 to 6
                int next = currPos + dice; // calculate the next position
                if (next > n * n) break; // if next position is out of bounds, break
                int row = (next - 1) / n; // calculate the row of the next position
                int col = (next - 1) % n; // calculate the column of the next position
                if (row % 2 == 1) col = n - 1 - col; // adjust column for snake and ladder board pattern
                row = n - 1 - row; // adjust row for snake and ladder board pattern
                if (board[row][col] != -1) next = board[row][col]; // if there's a snake or ladder, move to the destination
                if (!visited[next]) { // if the next position is not visited
                    visited[next] = true; // mark it as visited
                    q.add(new int[] { next, currMove + 1 }); // add the next position and move count to the queue
                }
            }
        }
        return -1; // if unable to reach the last position, return -1
    }
 }