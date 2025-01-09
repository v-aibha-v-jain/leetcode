public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        obj.solve(board);
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public void solve(char[][] board) {
        int n = board.length; // number of rows
        int m = board[0].length; // number of columns
        int[][] vis = new int[n][m]; // visited array
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // if 'O' is on the border, mark it as 'V' and start DFS
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == n-1 || j == m-1)) {
                    board[i][j] = 'V';
                    dfs(board, i, j, vis, n, m);
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                // convert all 'O' to 'X'
                if(board[i][j] == 'O') board[i][j] = 'X';
                // convert all 'V' back to 'O'
                if(board[i][j] == 'V') board[i][j] = 'O';
            }
        }
    }

    void dfs(char[][] board, int i, int j, int[][] vis, int n, int m) {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // possible directions
        vis[i][j] = 1; // mark as visited
        for(int[] x : dir) {
            int r = i + x[0]; // new row
            int c = j + x[1]; // new column
            // if the new cell is within bounds, is 'O', and not visited
            if(r >= 0 && c >= 0 && r < n && c < m && board[r][c] == 'O' && vis[r][c] == 0) {
                board[r][c] = 'V'; // mark as 'V'
                dfs(board, r, c, vis, n, m); // continue DFS
            }
        }
    }
}