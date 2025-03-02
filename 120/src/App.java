import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        System.out.println(obj.minimumTotal(triangle));
    }
}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); // Get the number of rows in the triangle
        int[][] dp = new int[n][n]; // Create a 2D array to store the minimum path sums
        for(int j=0; j<n; j++) // Initialize the last row of dp with the last row of the triangle
            dp[n-1][j] = triangle.get(n-1).get(j);
        for(int i=n-2; i>=0; i--){ // Iterate from the second last row to the top row
            for(int j=i; j>=0;j--){ // Iterate through each element in the current row
                int down = triangle.get(i).get(j) + dp[i+1][j]; // Calculate the sum if moving down
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1]; // Calculate the sum if moving diagonally
                dp[i][j] = Math.min(down,diagonal); // Store the minimum of the two sums in dp
            }
        }
        return dp[0][0]; // Return the minimum path sum from the top of the triangle
    }
}