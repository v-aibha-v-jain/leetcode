public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        obj.rotate(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) { 
            for (int j = 0; j < n / 2; j++) { 
                int temp = matrix[n-1-j][i]; // store top-left in temp
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; // move bottom-left to top-left
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i]; // move bottom-right to bottom-left
                matrix[j][n-1-i] = matrix[i][j]; // move top-right to bottom-right
                matrix[i][j] = temp; // move temp (top-left) to top-right
            }
        }
    }
}