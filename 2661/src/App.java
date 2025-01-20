public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        int[] arr = {1, 3, 4, 2};
        int[][] mat = {{1, 4}, {2, 3}};
        int result = obj.firstCompleteIndex(arr, mat);
        System.out.println(result);
    }
}
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] matrix) {
        int m = matrix.length; // number of rows in the matrix
        int n = matrix[0].length; // number of columns in the matrix
        int[] rows = new int[m]; // array to count filled cells in each row
        int[] cols = new int[n]; // array to count filled cells in each column
        int[][] map = new int[m*n+1][2]; // map to store the position of each number in the matrix
        for(int i=0;i<m;i++){ // iterate through each row
            for(int j=0;j<n;j++){ // iterate through each column
                map[matrix[i][j]][0] = i; // store row index of the number
                map[matrix[i][j]][1] = j; // store column index of the number
            }
        }
        for(int i=0;i<arr.length;i++){ // iterate through the array
            int row = map[arr[i]][0]; // get the row index of the current number
            int col = map[arr[i]][1]; // get the column index of the current number
            rows[row]++; // increment the count for the row
            cols[col]++; // increment the count for the column
            if(rows[row]==n || cols[col]==m) return i; // check if the row or column is completely filled
        }
        return -1; // return -1 if no row or column is completely filled
    }
}