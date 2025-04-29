public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int m = 3;
        int n = 7;
        int result = solution.uniquePaths(m, n);
        System.out.println("Number of unique paths from top-left to bottom-right: " + result);
    }
}
class Solution {
    public int uniquePaths(int m, int n) {
        long[][] cntPath = new long[m+1][n+1]; // Create a 2D array to store the number of unique paths
        for(int i = 0; i < m; i++) cntPath[i][0] = 1; // Initialize the first column with 1 (only one way to move down)
        for(int i = 0; i < n; i++) cntPath[0][i] = 1; // Initialize the first row with 1 (only one way to move right)
        for(int i = 1; i < m; i++) // Loop through rows starting from the second row
            for(int j = 1; j < n; j++) // Loop through columns starting from the second column
                cntPath[i][j] = cntPath[i-1][j] + cntPath[i][j-1]; // Sum paths from the top and left cells
        return (int) cntPath[m-1][n-1]; // Return the total unique paths to the bottom-right corner
    }
}