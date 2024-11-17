import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length; // get the number of rows
        int col = matrix[0].length; // get the number of columns
        Set<Integer> rowSet = new HashSet<>(); // set to store rows with zero
        Set<Integer> colSet = new HashSet<>(); // set to store columns with zero
        for(int i=0; i<row; i++){ // iterate through each row
            for(int j=0; j<col; j++){ // iterate through each column
                if(matrix[i][j] == 0){ // if the element is zero
                    rowSet.add(i); // add row index to rowSet
                    colSet.add(j); // add column index to colSet
                }
            }
        }
        for(int i=0; i<row; i++){ // iterate through each row again
            for(int j=0; j<col; j++){ // iterate through each column again
                if(rowSet.contains(i) || colSet.contains(j)){ // if row or column index is in the set
                    matrix[i][j] = 0; // set the element to zero
                }
            }
        }
    }
}