public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        System.out.println(obj.totalNQueens(4));
    }
}
class Solution {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n]; // Initialize the chessboard
        return backtrack(board, 0); // Start the backtracking process from the first row
    }

    private int backtrack(int[][] board, int row) {
        if (row == board.length) // If all rows are processed, we found a solution
            return 1;
        int solutions = 0; // Initialize the number of solutions
        for (int col = 0; col < board.length; col++) { // Iterate through each column in the current row
            if (!isValid(board, row, col, board.length)) // Check if placing a queen here is valid
                continue;
            board[row][col] = 1; // Place the queen
            solutions += backtrack(board, row + 1); // Recur to place the rest of the queens
            board[row][col] = 0; // Remove the queen (backtrack)
        }
        return solutions; // Return the number of solutions found
    }

    private boolean isValid(int[][] board, int row, int col, int n) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 1) // Check the row
                return false;
            if (board[i][col] == 1) // Check the column
                return false;
        }
        int i = row;
        int j = col;
        while (i >= 0 && j >= 0) { // Check the upper left diagonal
            if (board[i][j] == 1)
                return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < n) { // Check the upper right diagonal
            if (board[i][j] == 1)
                return false;
            i--;
            j++;
        }
        i = row;
        j = col;
        while (i < n && j >= 0) { // Check the lower left diagonal
            if (board[i][j] == 1)
                return false;
            i++;
            j--;
        }
        i = row;
        j = col;
        while (i < n && j < n) { // Check the lower right diagonal
            if (board[i][j] == 1)
                return false;
            i++;
            j++;
        }
        return true; // Return true if no conflicts are found
    }
}