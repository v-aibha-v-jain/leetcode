public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] grid = {{1,0},{0,1}};
        System.out.println(obj.countServers(grid));
    }
}
class Solution {
    public int countServers(int[][] grid) {
        int rlength = grid.length; // number of rows
        int clength = grid[0].length; // number of columns
        
        int row[] = new int[rlength]; // array to count servers in each row
        int coloumn[] = new int[clength]; // array to count servers in each column

        int totalServer = 0; // total number of servers

        // Count servers in each row and column
        for (int i = 0; i < rlength; i++) {
            for (int j = 0; j < clength; j++) {
            if (grid[i][j] == 1) { // if there's a server at grid[i][j]
                totalServer += 1; // increment total server count
                row[i] += 1; // increment server count for the row
                coloumn[j] += 1; // increment server count for the column
            }
            }   
        }

        // Check for isolated servers
        for (int i = 0; i < rlength; i++) {
            for (int j = 0; j < clength; j++) {
            if (grid[i][j] == 1) { // if there's a server at grid[i][j]
                if (row[i] < 2 && coloumn[j] < 2) { // if the server is isolated
                totalServer -= 1; // decrement total server count
                }
            }
            }
        }
        return totalServer; // return the number of servers that can communicate
    }
}