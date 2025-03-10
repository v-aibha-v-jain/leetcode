public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(obj.maximalSquare(matrix));
    }
}
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length; // Get the dimensions of the matrix
        int[] dp = new int[n + 1]; // Create a DP array to store the size of the largest square ending at each position
        int maxSide = 0, prev = 0; // Initialize maxSide to track the largest square and prev to store the previous value in DP array
        for (int i = 1; i <= m; i++) { // Iterate over each row
            for (int j = 1, temp; j <= n; j++) { // Iterate over each column
                temp = dp[j]; // Store the current dp[j] value in temp
                if (matrix[i - 1][j - 1] == '1') { // Check if the current cell in the matrix is '1'
                    dp[j] = Math.min(dp[j - 1], Math.min(dp[j], prev)) + 1; // Update dp[j] with the size of the largest square
                    maxSide = Math.max(maxSide, dp[j]); // Update maxSide if the current square is larger
                } else dp[j] = 0; // If the current cell is '0', reset dp[j] to 0
                prev = temp; // Update prev with the value of temp
            }
        }
        return maxSide * maxSide; // Return the area of the largest square
    }
}