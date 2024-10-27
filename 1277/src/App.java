public class App {
    public static void main(String[] args) throws Exception {
        Solution obj=new Solution();
        int[][] matrix={{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(obj.countSquares(matrix));
    }
}
class Solution {
    public int countSquares(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=1;i<rows;i++) // 1st row and 1st column will remain same, considering bottom right elemrnt of square with the other elements
            for(int j=1;j<cols;j++) 
                if(matrix[i][j]==1)
                    matrix[i][j]+=Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1])); 
                    // adding the minimum of the top, left and top-left element, if 0 then value doesnt change, if no 0's then value increases by minimum of the 3
        int total=0;
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                total+=matrix[i][j]; // adding all the elements of the matrix
        return total;
    }
}