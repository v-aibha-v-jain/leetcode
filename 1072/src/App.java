import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        int matrix[][] = {{0,1},{1,1}};
        System.out.println(solution.maxEqualRowsAfterFlips(matrix));
    }
}
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int max  = 0 ;
        int n = matrix[0].length;
        for(int[] currrow  : matrix){
            int inver[]= new int [n];
            int count  = 0;
            for(int col = 0 ; col < n ; col++){
                inver[col] = currrow[col] == 0?1:0;
            }
            for(int row[] : matrix){
                if(Arrays.equals(row , currrow) || Arrays.equals(row,inver)){
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }
}